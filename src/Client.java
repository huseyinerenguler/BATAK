/*
 * set first player fonksiyonu duzgun calýsmýyor
 * son kart atma fonksiyonu da duzgun calýsmýyor
 */


import java.util.Scanner;

public class Client {

	static Scanner input = new Scanner(System.in);
	
	public static void main (String[] args) {
	
		Game game = new Game();
	
		//game.distributeCards();
		//game.displayMyCards();
		game.getMyCardsFromUser(); // 1, it is work !
		game.displayMyCards();
		
		System.out.print("\n--> What is TRUMP Card [Kupa, Maça, Sinek, Karo]: ");
		game.setTrumpCard(input.next()); // 2, it is work !
	
		System.out.print("\n--> Who is FIRST Player [0,1,2,3]: ");
		game.setFirstPlayer(input.nextInt()); // 3, it is work !
		
		while(true) {
			
			game.run();
			game.whoIsWin();
			game.displayMyCards();
		}
		
	}
	
}
