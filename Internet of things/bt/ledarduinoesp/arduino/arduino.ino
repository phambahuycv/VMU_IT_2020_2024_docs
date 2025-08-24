void setup() {
  pinMode(13, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(2,OUTPUT);
  Serial.begin(9600);
}

void loop() {
  if (Serial.available()) {
    int command = Serial.parseInt();
    Serial.println(command);
    if (command == 1000) {
      digitalWrite(13, HIGH);  // Turn LED 1 on
    } else if (command == 1111) {
      digitalWrite(13, LOW);   // Turn LED 1 off
    } else if (command == 2222) {
      digitalWrite(4, HIGH);  // Turn LED 2 on
    } else if (command == 3333) {
      digitalWrite(4, LOW);   // Turn LED 2 off
    }
  }
}