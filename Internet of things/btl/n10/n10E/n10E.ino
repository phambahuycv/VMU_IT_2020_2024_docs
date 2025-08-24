#include <Arduino.h>
#include <ArduinoJson.h>
#include <Wire.h>
#include <ESP8266WiFi.h>
#include <WebSocketsClient.h>  //https://github.com/Links2004/arduinoWebSockets
unsigned long times;
WebSocketsClient webSocket;
// const char* ssid = "Chess";           
// const char* password = "ohnomyrook";  
// const char* ip_host = "192.168.0.103";  

const char* ssid = "Phạm Bá Huy";           
const char* password = "huycnt61dh";  
const char* ip_host = "192.168.243.55";  
// const char* ssid = "Thu vien 01";           
// const char* password = "qd3382016";  
// const char* ip_host = "192.168.8.12";  

const uint16_t port = 3000;    

float receivedTemperature = 0.0;
float receivedHumidity = 0.0;
float t,h;
String Chedo;
String Led;
void webSocketEvent(WStype_t type, uint8_t* payload, size_t length) {
  Chedo = (char*)payload;
  switch (type) {
    case WStype_DISCONNECTED:
      Serial.printf("[WSc] Disconnected!\n");
      break;
    case WStype_CONNECTED:
      {
        Serial.printf("[WSc] Connected to url: %s\n", payload);
      }
      break;
    case WStype_BIN:
      Serial.println(Chedo);
      break;
  }
}

void setup() {
  Serial.begin(9600);
  Wire.begin(5, 4);
  times = millis();
  Serial.println("ESP8266 Websocket Client");
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println(WiFi.localIP());
  webSocket.begin(ip_host, port);
  webSocket.onEvent(webSocketEvent);
  
}

void Guidulieu_Arduino() {
  Wire.beginTransmission(8); /* begin with device address 8 */
  Wire.write(Chedo.c_str()); /* sends hello string */
  Wire.endTransmission();    /* stop transmitting */
}

void loop() {
  readArduino();
  sendReadings();
  Guidulieu_Arduino();
  webSocket.loop();
}
const size_t bufferSize = JSON_OBJECT_SIZE(4);
void sendReadings() {
  // Tạo một đối tượng JSON
  DynamicJsonDocument jsonBuffer(bufferSize);
  Led = Chedo.c_str();
  if(Led == "2"){
    jsonBuffer["led1"] = 2;
  }else if(Led == "3"){
    jsonBuffer["led1"] = 3;
  }else{
    jsonBuffer["led1"] = 3;
  }
  if(Led == "4"){
    jsonBuffer["led2"] = 4;
  }else if(Led == "5"){
    jsonBuffer["led2"] = 5;
  }else{
    jsonBuffer["led2"] = 5;
  }
  jsonBuffer["temperature"] = t;
  jsonBuffer["humidity"] = h;
  String jsonString;
  serializeJson(jsonBuffer, jsonString);

  webSocket.sendTXT(jsonString);
}

void receiveData(int byteCount) {
  while (Wire.available() > 0) {
    uint8_t buffer[sizeof(float) * 2];  // Tạo một buffer để lưu trữ dữ liệu
    Wire.readBytes(buffer, sizeof(float) * 2);
    memcpy(&receivedTemperature, &buffer[0], sizeof(float));
    memcpy(&receivedHumidity, &buffer[sizeof(float)], sizeof(float));
  }
}
void readArduino(){
  String string, string1, string2;
  Wire.requestFrom(8, 10);
  do {
    char c = Wire.read();
    string = string + c;
    string1 = string.substring(0, 5);
    string2 = string.substring(5);
  } while (Wire.available());
  h = atof(string1.c_str());
  t = atof(string2.c_str());
  Serial.print(string1);
  Serial.println();
  Serial.print(string2);
  Serial.println();
}