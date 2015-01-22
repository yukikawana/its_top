import java.util.Random;
import java.util.TimerTask;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class SimpleTweet {
	public static void main(String[] args) {
		//3分ごとにツイート
		//int tweetInterval = 3;

		TimerStar task = new TimerStar();//タイマータスククラスのインスタンス
		java.util.Timer timer = new java.util.Timer(); //タイマークラスのインスタンス
		timer.schedule(task, 60000,180000);//タイマーのスケジューリング
		System.out.println("Tweet Program Start!");

	}
}

class TimerStar extends TimerTask {
	public void run(){
		int waterLevel = get_waterLevel();

		String comment = getComment(waterLevel);
		//System.out.println("What's happening???");

		try {
			// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// String tweetString = br.readLine();
			String tweetString = comment;

			Twitter twitter = new TwitterFactory().getInstance();
			twitter.updateStatus(tweetString);
			System.out.println("Tweet Success!");

		} catch (TwitterException e) {
			System.out.println("error");
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
		String [][] demandWaterCommentDB = {{"もういらんて、水","お腹たっぷたぷですわｗｗｗ","だめよ～、だめだめｗｗｗ"},{"腹八分目～","おなか一杯だよ、おれ","もう大丈夫だから"},{"水を与えたまえ","われ、水欲す","水をくれてもいいじゃないの～"},{"水をください","おなかすいたよ"},{"水をくださいませんか","そろそろたのんますよ","ちょマジでのどカラカラなんすけどぉ～ｗｗｗ"},{"ちょっ、まじ水くれ","あっ、死ぬかもしんない","ここまでか"}};

		Random rnd = new Random();
        int random_commnet = rnd.nextInt(3);

		if(waterLevel >= 85){
			return demandWaterCommentDB[0][random_commnet];
		}else if((waterLevel >= 75) && (waterLevel < 85)){
			return demandWaterCommentDB[1][random_commnet];
		}else if((waterLevel >= 50) && (waterLevel < 75)){
			return demandWaterCommentDB[2][random_commnet];
		}else if((waterLevel >= 35) && (waterLevel < 50)){
			return demandWaterCommentDB[3][random_commnet];
		}else if((waterLevel >= 15) && (waterLevel < 35)){
			return demandWaterCommentDB[4][random_commnet];
		}else{
			return demandWaterCommentDB[5][random_commnet];
		}
	}
}


