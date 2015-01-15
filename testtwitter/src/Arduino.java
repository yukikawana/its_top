	import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.InputStream;
	 
	 
	public class Arduino {
		
	 public static void main( String arg[] )
	 {
	   
	  try
	  {
	 
	   //=====================================================================================
	   //シリアルポートを確保する
	 
	 
	   //使用するCOMポートを取得
	   CommPortIdentifier comID = CommPortIdentifier.getPortIdentifier( "COM4" );
	 
	   //COMポートを開きます
	   CommPort commPort = comID.open("hoge",2000);
	 
	   //シリアルポートのインスタンスを生成…
	   SerialPort port = (SerialPort)commPort;
	 
	 
	 
	   //=====================================================================================
	   //シリアルポートの設定
	 
	 
	   //ボーレート、データビット数、ストップビット数、パリティを設定
	   port.setSerialPortParams( 115200,SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE );
	 
	   //フロー制御はしない
	   port.setFlowControlMode( SerialPort.FLOWCONTROL_NONE );
	 
	 
	 
	   InputStream is = port.getInputStream();
	    
	   int c; // arduinoからの出力読み込み用
	   boolean update_flag = false; // DB updateフラグ
	   boolean flag = true; // 無限ループ用フラグ
	   System.out.println("start reading");
	   int count=0; // 音声ファイル用カウンタ
	   while(true){
                  c = is.read();
	      if (c != -1) {
	    		  System.out.println(count+ "->" + c); // デバッグ用
	    		  // arduinoでは1を出力するはずが、なぜか48 or 49になってる
		    		  if (c > 48) { // ティッシュ抜き取り
	     			  update_flag = true;
		    		  } else {           
	     			  update_flag = false;
	    		  }
	    		  if (update_flag) {
	    			  qcount++;
                                      update_flag = false;
	                  }
	      }
	      if (flag == false) {
	    	  break;
	      }
	   }
               is.close();
               port.close();
               System.out.println("finished reading");
	  }
	  catch( Exception e )
	  {
	   System.out.println( "Error発生:" + e );
	  }
	 
	 }
	}
