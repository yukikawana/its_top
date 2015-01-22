import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Random;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;





public class speechsynthesizer  {
	public static void main(String[] args) {

		String comment = speechsynthesizer.getSpeechComment(90);
		speechsynthesizer.getandsavefile(comment);
		speechsynthesizer.speak("mysound.mp3");
	}
public static String getSpeechComment(int waterLevel){

		// 水分レベルに応じたコメントを返す
		String [][] demandWaterCommentDB = {{"もういらんて、水","お腹たっぷたぷですわー"},{"腹八分目ー","おなか一杯だよ、おれ"},{"水を与えたまえ","われ、水欲す"},{"水をください","おなかすいたよ"},{"水をくださいませんか","そろそろたのんますよ"},{"ちょっ、まじ水くれ","あっ、死ぬかもしんない"}};

		Random rnd = new Random();
        int random_commnet = rnd.nextInt(2);

		if(waterLevel >= 90){
			return demandWaterCommentDB[0][random_commnet];
		}else if((waterLevel >= 70) && (waterLevel < 90)){
			return demandWaterCommentDB[1][random_commnet];
		}else if((waterLevel >= 30) && (waterLevel < 70)){
			return demandWaterCommentDB[2][random_commnet];
		}else if((waterLevel >= 10) && (waterLevel < 30)){
			return demandWaterCommentDB[3][random_commnet];
		}else if((waterLevel >= 1) && (waterLevel < 10)){
			return demandWaterCommentDB[4][random_commnet];
		}else{
			return demandWaterCommentDB[5][random_commnet];
		}


}

public static String getandsavefile(String cmt){

	try {
		String filename = "mysound.mp3";
		 String word=cmt;
         word=java.net.URLEncoder.encode(word, "UTF-8");
         URL url = new URL("http://translate.google.com/translate_tts?ie=UTF-8&tl=ja&q="+word);
         HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
         urlConn.addRequestProperty("User-Agent", "Mozilla/4.76");
         InputStream audioSrc = urlConn.getInputStream();
         DataInputStream read = new DataInputStream(audioSrc);
         OutputStream outstream = new FileOutputStream(new File(filename));
         byte[] buffer = new byte[1024];
         int len;
         while ((len = read.read(buffer)) > 0) {
                 outstream.write(buffer, 0, len);
         }
         outstream.close();
return filename;
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (ProtocolException e) {
	      e.printStackTrace();
	    } catch (MalformedURLException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		finally{

			return null;
		}
	  }
public static void speak(String mp3path){

/*
	try{
		File file = new File(mp3path);
	    AudioInputStream in= AudioSystem.getAudioInputStream(file);
	    AudioInputStream din = null;
	    AudioFormat baseFormat = in.getFormat();
	    AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
	                                                                                  baseFormat.getSampleRate(),
	                                                                                  16,
	                                                                                  baseFormat.getChannels(),
	                                                                                  baseFormat.getChannels() * 2,
	                                                                                  baseFormat.getSampleRate(),
	                                                                                  false);
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(decodedFormat, in));
			FloatControl gainControl =
			    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(1.0f); // Reduce volume by 10 decibels.
			clip.start();
			SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    // A GUI element to prevent the Clip's daemon Thread
                    // from terminating at the end of the main()
                    JOptionPane.showMessageDialog(null, "Close to exit!");
                }
            });


 */

	try{
		File file = new File(mp3path);
		    AudioInputStream in= AudioSystem.getAudioInputStream(file);
		    AudioInputStream din = null;
		    AudioFormat baseFormat = in.getFormat();
		    AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
		                                                                                  baseFormat.getSampleRate(),
		                                                                                  16,
		                                                                                  baseFormat.getChannels(),
		                                                                                  baseFormat.getChannels() * 2,
		                                                                                  baseFormat.getSampleRate(),
		                                                                                  false);
		    din = AudioSystem.getAudioInputStream(decodedFormat, in);
		    // Play now.
		    rawplay(decodedFormat, din);
		    in.close();


	}
	catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}


}


static void rawplay(AudioFormat targetFormat, AudioInputStream din) throws IOException,                                                                                                LineUnavailableException
{
  byte[] data = new byte[4096];
  SourceDataLine line = getLine(targetFormat);
  if (line != null)
  {
    // Start
    line.start();

    int nBytesRead = 0, nBytesWritten = 0;
    while (nBytesRead != -1)
    {
        nBytesRead = din.read(data, 0, data.length);
        if (nBytesRead != -1) nBytesWritten = line.write(data, 0, nBytesRead);
    }
    // Stop
    line.drain();
    line.stop();
    line.close();
    din.close();
  }
}

static SourceDataLine getLine(AudioFormat audioFormat) throws LineUnavailableException
{
  SourceDataLine res = null;
  DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
  res = (SourceDataLine) AudioSystem.getLine(info);
  res.open(audioFormat);
  return res;
}


}




