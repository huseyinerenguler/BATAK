/*
 * set first player fonksiyonu duzgun calýsmýyor
 * son kart atma fonksiyonu da duzgun calýsmýyor
 */


import java.util.Scanner;

public class Client {

	static Scanner input = new Scanner(System.in);
	
	public static void main (String[] args) {
	
		Game game = new Game();
	
		game.distributeCards();
		
		game.displayMyCards();
		
		//game.getMyCardsFromUser();
		
	
		
		System.out.print("What is TRUMP Card (D,H,C,S): ");
		game.setTrumpCard(input.next().toUpperCase());
	
		System.out.print("Who is FIRST Player (0,1,2,3): ");
		game.setFirstPlayer(input.nextInt());
		
		while (true) {
			
			game.run();
			game.whoIsWin();
		}
		
	}
	
}
