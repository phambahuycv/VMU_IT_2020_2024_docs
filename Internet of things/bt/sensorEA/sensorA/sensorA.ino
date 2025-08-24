#include <SoftwareSerial.h>

SoftwareSerial espSerial(0, 1); // RX, TX

void setup() {
 Serial.begin(8500);
  espSerial.begin(9600);
  pinMode(2, INPUT); // Cảm biến chuyển động
  pinMode(4,OUTPUT);
  pinMode(13,OUTPUT);
}

void loop() {
  int motionState = digitalRead(2);
  if (motionState == HIGH) {
    espSerial.write('1'); // Gửi dữ liệu '1' đến ESP8266
  } else {
    espSerial.write('0'); // Gửi dữ liệu '0' đến ESP8266
  }
  while (espSerial.available()) {
    char receivedChar = espSerial.read(); // Nhận dữ liệu từ ESP8266
    // Xử lý dữ liệu nhận được nếu cần  
    espSerial.println(receivedChar);
    espSerial.write(receivedChar);
    if(receivedChar=='2'){
      digitalWrite(13,HIGH);
    }
    else if(receivedChar=='3'){
      digitalWrite(13,LOW);
    }
    else if(receivedChar=='4'){
      digitalWrite(4,HIGH);
    }
    else if(receivedChar=='5'){
      digitalWrite(4,LOW);
    }
    else if(receivedChar=='6'){
      
    }
  }

  delay(1000);
}