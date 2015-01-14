import java.util.Random;

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
		// 水分レベル取得

		//Randomクラスのインスタンス化(水分レベルの仮の値)
        Random rnd = new Random();
        int ran = rnd.nextInt(101);
        System.out.println(ran);

		return ran;
	}

	private static String getComment(int waterLevel) {
		// 水分レベルに応じたコメントを返す
		String [][] demandWaterCommentDB = {{"もういらんて、水","お腹たっぷたぷですわｗｗｗ"},{"腹八分目～","おなか一杯だよ、おれ"},{"水を与えたまえ","われ、水欲す"},{"水をください","おなかすいたよ"},{"水をくださいませんか","そろそろたのんますよ"},{"ちょっ、まじ水くれ","あっ、死ぬかもしんない"}};

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
}

