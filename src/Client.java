import java.util.Scanner;
// I m in :D
public class Client {

	static Scanner input = new Scanner(System.in);
	
	public static void main (String[] args) {
	
		Game game = new Game();
		
		game.getMyCardsFromUser();
		game.displayMyCards();
		
		do {
			System.out.print("--> What is TRUMP Card [D,H,C,S]: ");
		} while (!game.setTrumpCard(input.next()));
		
		System.out.println();
		
		do {
			System.out.print("--> Who is FIRST Player [0,1,2,3]: ");
		} while (!game.setFirstPlayer(input.nextInt()));
		
		while(true) {
			
			game.run();
			//game.whoIsWin();
			game.displayMyCards();
		}
	}
}