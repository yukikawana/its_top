import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class SimpleTweet {

	public static void main(String[] args) {

		System.out.println("What's happening?");

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String tweetString = br.readLine();

			Twitter twitter = new TwitterFactory().getInstance();
			twitter.updateStatus(tweetString);

		} catch (IOException e) {
		} catch (TwitterException e) {
		}
	}
}