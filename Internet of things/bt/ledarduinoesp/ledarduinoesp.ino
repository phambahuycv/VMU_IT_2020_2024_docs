#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <ESP8266WebServer.h>
#include <ESP8266mDNS.h>
#include <SoftwareSerial.h>

SoftwareSerial espSerial(2, 3);

MDNSResponder mdns;
ESP8266WebServer server(80);

String webPage =
{
  "<!DOCTYPE html>"
  "<html>"
  "<head>"
  "   <meta http-equiv='Content-Type' content='text/html; charset=utf-8'>"
  "  <title>Điều khiển thiết bị</title>"
  "  <meta name='viewport' content='width=device-width, initial-scale=1'>"
  "  <style>"
  "    .b{width: 100px;height: 40px;font-size: 21px;color: #FFF;background-color:#4caf50;border-radius: 10px;}"
  "    .t{width: 100px;height: 40px;font-size: 21px;color: #FFF;background-color:#f44336;border-radius: 10px;}"
  "  </style>"
  "</head>"
  "<body>"
  "<div style='width: 330px;height: auto;margin: 0 auto;margin-top: 70px'>"
  "<h1 align='center'>Điều khiển thiết bị qua WIFI</h1>"
  "  <table align='center'>"
  "    <tr>"
  "    <td><a href='/bat1'><button class='b'>Bật 1</button></a><td>"
  "    <td><a href='/tat1'><button class='t'>Tắt 1</button></a><td>"
  "    <tr>"
  "    <tr>"
  "    <td><a href='/bat2'><button class='b'>Bật 2</button></a><td>"
  "    <td><a href='/tat2'><button class='t'>Tắt 2</button></a><td>"
  "    <tr>"
  "  </table>"
  "</div>"
  "</body>"
  "</html>"
};
void TrangChu()
{
  server.send(200, "text/html", webPage);
}
void bat1()
{
  espSerial.println(1000);
  Serial.println("Bật LED 1");
  server.send(200, "text/html", webPage);
}
void tat1()
{
  espSerial.println(1111);
  digitalWrite(13, LOW); 
  Serial.println("Tắt LED 1");
  server.send(200, "text/html", webPage);
}
void bat2()
{
  espSerial.println(2222);
  Serial.println("Bật LED 2");
  server.send(200, "text/html", webPage);
}
void tat2()
{
  espSerial.println(3333);
  Serial.println("Tắt LED 2");
  server.send(200, "text/html", webPage);
}
void setup()
{
  pinMode(13, OUTPUT);
  pinMode(4, OUTPUT);
  
  espSerial.begin(9600);
  Serial.begin(9600);
  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  WiFi.begin("Phạm Bá Huy", "huycnt61dh");
  
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected"); 
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
  if (mdns.begin("esp8266", WiFi.localIP()))
  Serial.println("MDNS responder started");
  
  server.on("/", TrangChu);
  server.on("/bat1", bat1);
  server.on("/tat1", tat1);
  server.on("/bat2", bat2);
  server.on("/tat2", tat2);
  server.begin();
}
void loop()
{
  IPAddress ip = WiFi.localIP();
    Serial.print("IP Address: ");
    Serial.println(ip);
    
    delay(5000);
  server.handleClient();
}
