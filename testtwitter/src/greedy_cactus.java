
public class greedy_cactus {

	static int range=50; //centimeter
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("Hello this is greedy cactus. ");
		try {
			System.out.println("initialize arduino connection");
			SerialTest.StartArdCon();
			System.out.println("start tweeting");
			SimpleTweet.startTweet();
			System.out.println("now system is ready!");
			while(true)
			{
				if(SerialTest.Getdistance() < range)
				{
					speechsynthesizer.begwater();
					Thread.sleep(10000);
				}

			}


		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			System.err.println("error, byebye");
			e.printStackTrace();
		}


	}

}
