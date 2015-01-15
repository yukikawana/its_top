	import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.BufferedReader;
import java.io.InputStreamReader;


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
	   port.setSerialPortParams( 9600,SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE );

	   //フロー制御はしない
	   port.setFlowControlMode( SerialPort.FLOWCONTROL_NONE );



	   BufferedReader is = new BufferedReader(new InputStreamReader(port.getInputStream()));

	   int c; // arduinoからの出力読み込み用
	   System.out.println("start reading");
	   while(true){
                  String line = is.readLine();
                  System.out.println(line); // デバッグ用

	    	  break;
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
