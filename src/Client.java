/*
 * set first player fonksiyonu duzgun cal�sm�yor
 * son kart atma fonksiyonu da duzgun cal�sm�yor
 */


import java.util.Scanner;

public class Client {

	static Scanner input = new Scanner(System.in);
	
	public static void main (String[] args) {
	
		Game game = new Game();
	
		//game.getMyCardsFromUser(); // 1, it is work !
		
		System.out.print("\n--> What is TRUMP Card [Kupa, Ma�a, Sinek, Karo]: ");
		game.setTrumpCard(input.next()); // 2, it is work !
	
		System.out.print("\n--> Who is FIRST Player [0,1,2,3]: ");
		game.setFirstPlayer(input.nextInt()); // 3, it is work !
		
		while(true) {
			
			game.run();
			game.whoIsWin();
			System.out.println("firstssstst: " + game.getFirstPlayer());
		}
		
	}
	
}
