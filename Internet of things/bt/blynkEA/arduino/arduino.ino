#include <Wire.h>
#include <DHT.h>
// slave
#define DHTPIN 2
#define DHTTYPE DHT11
DHT dht(DHTPIN, DHTTYPE);

char vy[7];
char ix[8];
void onReceive(int count) {
  while (Wire.available() > 0) {
    char c = Wire.read();
    Serial.print(c);
    if (c == '2') {
      digitalWrite(13, HIGH);
    } else if (c == '3') {
      digitalWrite(13, LOW);
    } else if (c == '4') {
      digitalWrite(4, HIGH);
    } else if (c == '5') {
      digitalWrite(4, LOW);
    }
  }
}

void onRequest(int count) {
  float humidity, temperature;
  humidity = float(dht.readHumidity());        // Đọc độ ẩm và chuyển đổi thành kiểu int
  temperature = float(dht.readTemperature());  // Đọc nhiệt độ và chuyển đổi thành kiểu int
  dtostrf(humidity, 5, 2, ix);
  dtostrf(temperature, 5, 2, vy);
  Wire.write(ix);
  Wire.write(vy);
}

void setup() {
  Serial.begin(9600);
  Wire.begin(8);
  pinMode(4, OUTPUT);
  pinMode(13, OUTPUT);
  dht.begin();
  Wire.onReceive(onReceive);
  Wire.onRequest(onRequest);
}

void loop() {
  float humidity, temperature;
  humidity = float(dht.readHumidity());        
  temperature = float(dht.readTemperature());  
  // Gửi dữ liệu nhiệt độ và độ ẩm dưới dạng kiểu int
  Wire.beginTransmission(8);  // Địa chỉ của ESP8266 (8 là địa chỉ mặc định của ESP8266)
  Wire.write((uint8_t*)&temperature, sizeof(float));
  Wire.write((uint8_t*)&humidity, sizeof(float));
  Wire.endTransmission();
  delay(500);  // Đợi một chút trước khi gửi dữ liệu tiếp theo
}