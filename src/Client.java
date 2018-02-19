/*
 * Last Update: 19.02.2018 13:20
 * 
 * I tried a new system that every card is an object. 
 * But I measured some performance losses related to comparisons times. 
 * The project will continue through the current version.
 */

import java.util.Scanner;

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
			game.whoIsWin();
			game.displayMyCards();
		}
	}
}