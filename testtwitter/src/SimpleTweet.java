import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class SimpleTweet {

	public static void main(String[] args) {
		int waterLevel = get_waterLevel();

		String comment = getComment(waterLevel);
		//System.out.println("What's happening???");

		try {
			// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// String tweetString = br.readLine();
			String tweetString = comment;

			Twitter twitter = new TwitterFactory().getInstance();
			twitter.updateStatus(tweetString);

		} catch (TwitterException e) {
		}
	}

	private static int get_waterLevel() {
		// TODO 自動生成されたメソッド・スタブ
		return 90;
	}

	private static String getComment(int waterLevel) {
		// 水分レベルに応じたコメントを返す
		String [] commentDB = new String [] {"もういらんて、水","腹八分目～","水を与えたまえ","水をください","水をくださいませんか","ちょっ、まじ水くれ"};

		if(waterLevel >= 90){
			return commentDB[0];
		}else if((waterLevel >= 70) && (waterLevel < 90)){
			return commentDB[1];
		}else if((waterLevel >= 30) && (waterLevel < 70)){
			return commentDB[2];
		}else if((waterLevel >= 10) && (waterLevel < 30)){
			return commentDB[3];
		}else if((waterLevel >= 1) && (waterLevel < 10)){
			return commentDB[4];
		}else{
			return commentDB[5];
		}
	}
}

