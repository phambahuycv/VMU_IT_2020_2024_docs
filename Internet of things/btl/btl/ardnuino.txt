#include <Wire.h>
#include <DHT.h>
#define led1 4
#define led2 13
#define dhtPin 2
DHT dht(dhtPin, DHT11);
char vy[7];
char ix[8];
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
  Wire.begin(8); /* join i2c bus with address 8 */
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  Wire.onReceive(onReceive); /* register receive event */
  Serial.begin(9600); /* start serial for debug */
  dht.begin();
  Wire.onRequest(onRequest);
}

void loop() {
  readDHTData();
}
void onReceive(int count) {
  if (Wire.available() > 0) {
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
void readDHTData() {
  float temperature = dht.readTemperature();
  float humidity = dht.readHumidity();
  //Serial.print("Nhiệt độ (°C): ");
  Serial.println(temperature);
  //Serial.print("Độ ẩm (%): ");
  Serial.println(humidity);
  Wire.beginTransmission(8);
  // Wire.write((byte*)&temperature, sizeof(float));
  // Wire.write((byte*)&humidity, sizeof(float));
  Wire.write((uint8_t*)&humidity, sizeof(float));
  Wire.write((uint8_t*)&temperature, sizeof(float));
  Wire.endTransmission();
}
