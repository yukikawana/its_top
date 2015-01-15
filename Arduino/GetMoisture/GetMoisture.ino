/*
//Example 01 :Blinking LED

const int LED =13;

void setup()
{
  pinMode(LED,OUTPUT);
}

void loop()
{
  digitalWrite(LED,HIGH);
  delay(100);
  digitalWrite(LED,LOW);
  delay(100);
}
*/
/////////////////////////////////////////////////////////////////////////////////////////////////////
int Pin0 = 0;    // select the input pin for the potentiometer
int Value0 = 0;  // variable to store the value coming from the sensor
int Pin1 = 1;    // select the input pin for the potentiometer
int Value1 = 0;  // variable to store the value coming from the sensor

void setup() {
  // declare the ledPin as an OUTPUT:
   Serial.begin(9600);
}

void loop() {
  // read the value from the sensor:
  Value0 = analogRead(Pin0);
  Value1 = analogRead(Pin1);
  delay(1000);          
  Serial.print("sensor0 = " );                       
  Serial.println(Value0);      
  Serial.print("sensor1 = " );                       
  Serial.println(Value1);  
}
