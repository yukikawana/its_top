#include <stdio.h>

static FILE uartout;

static int uart_putchar (char c, FILE *stream) {
    if (Serial.write(c) > 0) {
      return 0;
    } else {
      return -1;
    }
}

int Pin0 = 0;    // select the input pin for the potentiometer
int Value0 = 0;  // variable to store the value coming from the sensor
int Pin1 = 1;    // select the input pin for the potentiometer
int Value1 = 0;  // variable to store the value coming from the sensor

void setup() {
    // シリアルポートの通信開始
  Serial.begin(9600);
  fdev_setup_stream (&uartout, uart_putchar, NULL, _FDEV_SETUP_WRITE);
  stdout = &uartout;
}

void loop() {
    // A2から距離センサの出力電圧Voを読み取る
  int V = analogRead(2);
  int d = 5461 / (V - 17) - 2;  // 距離を算出する近似式
  
    // 土壌水分センサから出力電圧の読み取り
  Value0 = analogRead(Pin0);
  Value1 = analogRead(Pin1);   
  int Mv = (Value1 - Value0);
  int sum;
  
       if (Mv > 250){
        Mv = 250;
      }else if(Mv < 5){
        Mv = 5;
      } 
     
     for (int i=0; i <= 50; i++){
     if (i == 0){
       sum = 0;
     }
       sum = sum + Mv;
      delay(500);
     }
     
  float avr = (sum / 50);
  float a = (avr - 5)/(250 - 5);
  int cal = a * 100;
  
    
    // 距離センサ結果の出力（距離　100cm以内の物体のみを検出し、その距離をかえす）
  if (d<0 || 100<d){
  printf("100,%d\n", cal);
    delay(500);
   
  } else {  
  printf("%d,%d\n", d, cal);
    delay(500);
  }
}
