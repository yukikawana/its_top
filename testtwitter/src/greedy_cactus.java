
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
			Thread greedycac = new Thread(){
				public void run(){
				while(true)
			{
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// TODO 自動生成された catch ブロック
						e1.printStackTrace();
					}
					System.out.println("is anybody here?!");
					int distance = SerialTest.Getdistance();
					System.out.println(distance);

				if(distance < range)
				{
					System.out.println("somebody is here!");
					speechsynthesizer.begwater();

					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}

				}

			}
			}
		};
		greedycac.start();

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			System.err.println("error, byebye");
			e.printStackTrace();
		}


	}

}
