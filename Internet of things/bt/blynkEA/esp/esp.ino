#define BLYNK_TEMPLATE_ID "TMPL6jPxYTrVm"
#define BLYNK_TEMPLATE_NAME "sens"
#define BLYNK_AUTH_TOKEN "je3HzRVXnuLJmNf8emEcP1hcK4yH6vcP"
#define BLYNK_PRINT Serial

#include <ESP8266WiFi.h>
#include <BlynkSimpleEsp8266.h>
#include <Wire.h>
//master
float receivedTemperature = 0.0;
float receivedHumidity = 0.0;

char ssid[] = "Phạm Bá Huy";
char pass[] = "huycnt61dh";

BLYNK_WRITE(V1) {
  int virtual_pin_value = param.asInt();
  if (virtual_pin_value == 0) {
    Wire.beginTransmission(8);
    Wire.write('3');
    Wire.endTransmission();
  } else if (virtual_pin_value == 1) {
    Wire.beginTransmission(8);
    Wire.write('2');
    Wire.endTransmission();
  }
}

BLYNK_WRITE(V2) {
  int virtual_pin_value = param.asInt();
  if (virtual_pin_value == 0) {
    Wire.beginTransmission(8);
    Wire.write('5');
    Wire.endTransmission();
  } else if (virtual_pin_value == 1) {
    Wire.beginTransmission(8);
    Wire.write('4');
    Wire.endTransmission();
  }
}

void receiveData(int byteCount) {
  while (Wire.available() > 0) {
    uint8_t buffer[sizeof(float) * 2];  // Tạo một buffer để lưu trữ dữ liệu

    // Đọc dữ liệu từ Arduino vào buffer
    Wire.readBytes(buffer, sizeof(float) * 2);

    // Sử dụng hàm memcpy để chuyển đổi từ buffer sang kiểu float
    memcpy(&receivedTemperature, &buffer[0], sizeof(float));
    memcpy(&receivedHumidity, &buffer[sizeof(float)], sizeof(float));

    Blynk.virtualWrite(V5, receivedTemperature);
    Blynk.virtualWrite(V6, receivedHumidity);
    // Hiển thị dữ liệu trên Serial
    Serial.println(receivedTemperature);
    Serial.println(receivedHumidity);
  }
}


void setup() {
  Wire.begin(5, 4);
  Serial.begin(9600);

  Wire.onReceive(receiveData);
  Blynk.begin(BLYNK_AUTH_TOKEN, ssid, pass);
}

void loop() {
  Blynk.run();
  String string, string1, string2;

  Wire.requestFrom(8, 10);
  do {
    char c = Wire.read();
    string = string + c;
    string1 = string.substring(0, 5);
    string2 = string.substring(5);
  } while (Wire.available());
  Serial.print(string1);
  Serial.println();
  Serial.print(string2);
  Serial.println();
  
  Blynk.virtualWrite(V5, string2);
  Blynk.virtualWrite(V6, string1);
  Serial.println();
  delay(500);
}