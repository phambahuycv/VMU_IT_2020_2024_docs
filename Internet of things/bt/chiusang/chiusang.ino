int sensorPin = 2;  // ket noi cam bien vs Pin2
int sensor_value;
void setup() {
  // put your setup code here, to run once:
  pinMode(13, OUTPUT);
  pinMode(sensorPin, INPUT);  // set input
  digitalWrite(sensorPin, LOW);
}

void loop() {
  sensor_value = digitalRead(sensorPin);
  if (sensor_value == HIGH) {
    digitalWrite(13, HIGH);  // bat den
    //delay(1000);
  }
  sensor_value = digitalRead(sensorPin);
  if (sensor_value == HIGH) {
    digitalWrite(13, LOW);  // bat den
    //delay(1000);
  }
}