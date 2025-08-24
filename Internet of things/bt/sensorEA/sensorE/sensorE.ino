#include <ESP8266WiFi.h>
#include <ESP8266WebServer.h>
#include <SoftwareSerial.h>

SoftwareSerial espSerial(3, 1);  // RX, TX

const char* apSSID = "Huydeptrai";    // Tên mạng Wi-Fi của Access Point
const char* apPassword = "password";  // Mật khẩu mạng Wi-Fi của Access Point

ESP8266WebServer server(80);
int motionCount = 0;

String html;
void setup() {
  Serial.begin(9600);
  espSerial.begin(9600);     // Khởi đầu giao tiếp UART với Arduino
  // Thiết lập chế độ Access Point với tên và mật khẩu
  WiFi.softAP(apSSID, apPassword);

  IPAddress apIP = WiFi.softAPIP();
  Serial.print("AP IP address: ");
  Serial.println(apIP);

  server.on("/", HTTP_GET, handleRoot);
  server.on("/bat1", bat1);
  server.on("/tat1", tat1);

  server.on("/bat2", bat2);
  server.on("/tat2", tat2);
  server.begin();
}

void loop() {
  // while(espSerial.available()){
  //   char sens = espSerial.read();
  //   espSerial.write(sens);
  //   if(sens == '0'){
  //     motionCount = 0;

  //   }else if(sens == '1'){
  //     motionCount = 1;
  //   }
  // }
  server.handleClient();
}

void handleRoot() {
  html = "<html><head>";
  html += "<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>";
  html += "<title>Điều khiển thiết bị</title>";
  html += " <meta name='viewport' content='width=device-width, initial-scale=1'>";
  html += "<style>";
  html += ".b{width: 100px;height: 40px;font-size: 21px;color: #FFF;background-color:#4caf50;border-radius: 10px;}";
  html += " .t{width: 100px;height: 40px;font-size: 21px;color: #FFF;background-color:#f44336;border-radius: 10px;}";
  html += "</style>";
  html += "</head>";
  html += "<body>";
  html += "<div style='width: 330px;height: auto;margin: 0 auto;margin-top: 70px'>";
  html += "<h1 align='center'>Điều khiển thiết bị qua WIFI</h1>";
  html += "<p>Cảm biến chuyển động: " + String(motionCount) + "</p>";
  html += "<p>Đèn LED 1: <a href='/bat1'><button class='b'>Bật 1</button></a> <a href='/tat1'><button class='t'>Tắt 1</button></a></p>";
  html += "<p>Đèn LED 2: <a href='/bat2'><button class='b'>Bật 2</button></a> <a href='/tat2'><button class='t'>Tắt 2</button></a></p>";
  html += "</div>";
  html += "</body></html>";
  server.send(200, "text/html", html);
}

void bat1() {
  espSerial.write('2');
  server.send(200, "text/html", html);
}
void tat1() {
  espSerial.write('3');
  server.send(200, "text/html", html);
}

void bat2() {
  espSerial.write('4');
  server.send(200, "text/html", html);
}
void tat2() {
  espSerial.write('5');
  server.send(200, "text/html", html);
}