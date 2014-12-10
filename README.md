its_top
=======
ソフトウェア開発演習II

制作物：土壌水分センサを用いた植物育成支援システム

システム概要：
鉢植えの土壌水分を計測する。土壌水分値に応じたコメントをTwitterに投稿する（「土壌水分値は８０パーセントです」等）。水やりが必要なレベルに達したと判断した場合、鉢植えの前を人が通った時に合成音声によって水やりを促す。

システム構成概要：
1)土壌水分センサとマイクロコントローラであるArduinoを用いて、鉢植えの土壌水分を計測する。またArduinoとPC間でシリアル通信を行い、土壌水分値は常時PC上のプログラムに転送するとする。
2)距離センサ（超音波距離センサまたは赤外線距離センサ）とArduinoを用いて鉢植えの前を通る人の有無を検知する。またArduinoとPC間でシリアル通信を行い、検知結果は常時PC上のプログラムに転送するとする。
3)Arduinoと接続されたPC上プログラムから土壌水分値に応じてTwitterへ投稿する。
4)音声合成はオープンソースライブラリを用いて行うことを考えている。
5)PC上のプログラムの作成はArduinoと親和性の高いProcessingの使用を考えている。
