
public class SimpleTweet {

	public static void main(String[] args) {

		String comment = speechsynthesizer.getSpeechComment(40);
		speechsynthesizer.getandsavefile(comment);
		speechsynthesizer.speak("mysound.mp3");
	}
}