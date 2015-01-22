int Pin0 = 0;    // select the input pin for the potentiometer
int Value0 = 0;  // variable to store the value coming from the sensor
int Pin1 = 1;    // select the input pin for the potentiometer
int Value1 = 0;  // variable to store the value coming from the sensor

void setup() {
    // シリアルポートの通信開始
  Serial.begin(9600);
}

void loop() {  
    // 土壌水分センサから出力電圧の読み取り
  Value0 = analogRead(Pin0);
  Value1 = analogRead(Pin1);   
  int Mv = (Value1 - Value0);
  
   // 距離センサ結果の出力（距離　100cm以内の物体のみを検出し、その距離をかえす）
  Serial.println(Mv);
  delay(500);
}
