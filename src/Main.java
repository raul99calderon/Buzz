public class Main {
    
	public static void main(String[] args) {
		Game game = new Game();
		try {
			game.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}