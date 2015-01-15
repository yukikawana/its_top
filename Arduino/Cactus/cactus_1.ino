int Pin0 = 0;    // select the input pin for the potentiometer
int Value0 = 0;  // variable to store the value coming from the sensor
int Pin1 = 1;    // select the input pin for the potentiometer
int Value1 = 0;  // variable to store the value coming from the sensor

void setup() {
  Serial.begin(9600); // シリアルポートの通信開始
}

void loop() {
  int V = analogRead(2);  // A0からセンサの出力電圧Voを読み取る
  double d = 5461 / (V - 17) - 2;  // 距離を算出する近似式
  
  // 距離センサ結果の出力（距離　100cm以内の物体のみを検出し、その距離をかえす）
  if (d<0 || 100<d){
    Serial.println("100cm");
    delay(500);
  } else {
    Serial.print(d);
    Serial.println("cm");
    delay(500);
  }
 
  // 土壌水分センサ結果の出力
  Value0 = analogRead(Pin0);
  Value1 = analogRead(Pin1);
  delay(1000);          
  Serial.print("sensor0 = " );                       
  Serial.println(Value0);
  Serial.print("sensor1 = " );                       
  Serial.println(Value1);
}
