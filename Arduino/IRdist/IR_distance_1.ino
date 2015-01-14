// 電源起動時とリセットの時だけのみ処理される(初期化と設定処理)
void setup() {
     Serial.begin(9600) ;                    // 9600bpsでシリアル通信のポートを開きます
}
// 繰り返し実行される処理(メインの処理)
void loop() {
     int val ;

     val = IDSread(0)  ;                     // センサーから読み込む
     Serial.print(val) ;                     // アナログ値を表示する
     Serial.print("  ") ;
     Serial.println(AnaToCm(val)) ;          // 距離を表示する
     delay(500) ;                            // 500ms後に繰り返す
}
// センサーからの読み込み処理(100回読込み平均をとる)
int IDSread(int PinNo) {
     long ans ;
     int i ;

     ans = 0 ;
     for (i=0 ; i < 100 ; i++) {
          ans  = ans + analogRead(0) ;   // 指定のアナログピン(0番端子)から読取ります
     }
     return ans/100 ;                        // 100回の平均値を返します
}
// センサーから読込んだ値を距離(cm)に変換する処理
// 距離が短くなるとセンサー値は大きくなるが、４ｃｍ以内になると逆に小さくなっていく注意
int AnaToCm(int analogValue) {

     if (analogValue <  85 ) return(0)  ;     // ６０ｃｍ以上離れている
     if (analogValue >= 470) return(10) ;     // １０ｃｍ以内
     if (analogValue >= 260) return(20) ;     // ２０ｃｍ以内(10-20cm)
     if (analogValue >= 165) return(30) ;     // ３０ｃｍ以内(20-30cm)
     if (analogValue >= 126) return(40) ;     // ４０ｃｍ以内(30-40cm)
     if (analogValue >= 105) return(50) ;     // ５０ｃｍ以内(40-50cm)
     if (analogValue >= 85 ) return(60) ;     // ６０ｃｍ以内(50-60cm)
     return(-1) ;                             // この行実行は有得ないと思うが....
}
