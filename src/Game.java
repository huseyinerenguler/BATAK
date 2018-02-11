import java.util.Scanner;

public class Game {
	
	Scanner input = new Scanner(System.in);
	
	private MyPlayer myPlayer = new MyPlayer();
	private String trumpCard; // D,H,C,S
	private String[] myCard;  // first index --> D,H,C,S +++ second index --> 2,3,4,..,14
	private String[] firstEnemyCard; // first index --> D,H,C,S +++ second index --> 2,3,4,..,14
	private String[] secondEnemyCard; // first index --> D,H,C,S +++ second index --> 2,3,4,..,14
	private String[] thirdEnemyCard; // first index --> D,H,C,S +++ second index --> 2,3,4,..,14
	private String firstCardType; // D,H,C,S
	private int firstPlayer; // 0,1,2 or 3
	
	public boolean setTrumpCard (String trumpCard) {									// +++
		
		if (trumpCard.equalsIgnoreCase("D")) {
			this.trumpCard = "D";
			return true;
		}
		else if (trumpCard.equalsIgnoreCase("H")) {
			this.trumpCard = "H";
			return true;
		}
		else if (trumpCard.equalsIgnoreCase("C")) {
			this.trumpCard = "C";
			return true;
		}	
		else if (trumpCard.equalsIgnoreCase("S")) {
			this.trumpCard = "S";
			return true;
		}
		else
			return false;
	}
	
	public void setMyCard(String[] myCard) {											// +++
		
		if (myCard[0].equalsIgnoreCase("D")) {
			myPlayer.removeFromDiamonds(new Integer(myCard[1]));
			myPlayer.addToDropDiamonds(new Integer(myCard[1]));
			this.myCard = myCard;
		}	
		else if (myCard[0].equalsIgnoreCase("H")) {
			myPlayer.removeFromHearts(new Integer(myCard[1]));
			myPlayer.addToDropHearts(new Integer(myCard[1]));
			this.myCard = myCard;
		}	
		else if (myCard[0].equalsIgnoreCase("C")) {
			myPlayer.removeFromClubs(new Integer(myCard[1]));
			myPlayer.addToDropClubs(new Integer(myCard[1]));
			this.myCard = myCard;
		}	
		else if (myCard[0].equalsIgnoreCase("S")) {
			myPlayer.removeFromSpades(new Integer(myCard[1]));
			myPlayer.addToDropSpades(new Integer(myCard[1]));
			this.myCard = myCard;
		}
		else {
			System.out.println("ERROR! myCard was not added. (myCard = null)");
			this.myCard = null;
		}
	}	
	
	public void setFirstEnemyCard(String[] firstEnemyCard) {							// +++
		
		if (firstEnemyCard[0].equalsIgnoreCase("D")) {
			myPlayer.addToDropDiamonds(new Integer(firstEnemyCard[1]));
			this.firstEnemyCard = firstEnemyCard;
		}
		else if (firstEnemyCard[0].equalsIgnoreCase("H")) {
			myPlayer.addToDropHearts(new Integer(firstEnemyCard[1]));
			this.firstEnemyCard = firstEnemyCard;
		}
		else if (firstEnemyCard[0].equalsIgnoreCase("C")) {
			myPlayer.addToDropClubs(new Integer(firstEnemyCard[1]));
			this.firstEnemyCard = firstEnemyCard;
		}	
		else if (firstEnemyCard[0].equalsIgnoreCase("S")) {
			myPlayer.addToDropSpades(new Integer(firstEnemyCard[1]));
			this.firstEnemyCard = firstEnemyCard;
		}
		else {
			System.out.println("ERROR! firstEnemyCard was not added. (firstEnemyCard = null)");
			this.firstEnemyCard = null;
		}
	}
	
	public void setSecondEnemyCard(String[] secondEnemyCard) {							// +++
		
		if (secondEnemyCard[0].equalsIgnoreCase("D")) {
			myPlayer.addToDropDiamonds(new Integer(secondEnemyCard[1]));
			this.secondEnemyCard = secondEnemyCard;
		}
		else if (secondEnemyCard[0].equalsIgnoreCase("H")) {
			myPlayer.addToDropHearts(new Integer(secondEnemyCard[1]));
			this.secondEnemyCard = secondEnemyCard;
		}
		else if (secondEnemyCard[0].equalsIgnoreCase("C")) {
			myPlayer.addToDropClubs(new Integer(secondEnemyCard[1]));
			this.secondEnemyCard = secondEnemyCard;
		}	
		else if (secondEnemyCard[0].equalsIgnoreCase("S")) {
			myPlayer.addToDropSpades(new Integer(secondEnemyCard[1]));
			this.secondEnemyCard = secondEnemyCard;
		}
		else {
			System.out.println("ERROR! secondEnemyCard was not added. (secondEnemyCard = null)");
			this.secondEnemyCard = null;
		}
	}
	
	public void setThirdEnemyCard(String[] thirdEnemyCard) {							// +++
		
		if (thirdEnemyCard[0].equalsIgnoreCase("D")) {
			myPlayer.addToDropDiamonds(new Integer(thirdEnemyCard[1]));
			this.thirdEnemyCard = thirdEnemyCard;
		}
		else if (thirdEnemyCard[0].equalsIgnoreCase("H")) {
			myPlayer.addToDropHearts(new Integer(thirdEnemyCard[1]));
			this.thirdEnemyCard = thirdEnemyCard;
		}
		else if (thirdEnemyCard[0].equalsIgnoreCase("C")) {
			myPlayer.addToDropClubs(new Integer(thirdEnemyCard[1]));
			this.thirdEnemyCard = thirdEnemyCard;
		}	
		else if (thirdEnemyCard[0].equalsIgnoreCase("S")) {
			myPlayer.addToDropSpades(new Integer(thirdEnemyCard[1]));
			this.thirdEnemyCard = thirdEnemyCard;
		}
		else {
			System.out.println("ERROR! thirdEnemyCard was not added. (thirdEnemyCard = null)");
			this.thirdEnemyCard = null;
		}
	}
	
	public boolean setFirstPlayer(int firstPlayer) {									// +++
		
		if (firstPlayer == 0 || firstPlayer == 1 || firstPlayer == 2 || firstPlayer == 3) {
			this.firstPlayer = firstPlayer; // 0, 1, 2 or 3
			return true;
		}
		else
			return false;
	}
	
	/*
	 * silinebilir
	public String getTrumpCard() {														// +++
		return trumpCard;
	}
	public String[] getMyCard() {														// +++
		return myCard;
	}
	public String[] getFirstEnemyCard() {												// +++
		return firstEnemyCard;
	}
	public String[] getSecondEnemyCard() {												// +++
		return secondEnemyCard;
	}
	public String[] getThirdEnemyCard() {												// +++
		return thirdEnemyCard;
	}
	public int getFirstPlayer() {														// +++
		return firstPlayer;
	}	
	*/

	public void getMyCardsFromUser() {													// +++
		
		String[] card = new String[2];
		
		for (int x = 0; x < 13; x++) {
			System.out.print("Enter " + (x+1) + ". card (D5,H6,C10,S14): ");
			card = input.next().split("",2);
			
			if (card[0].equalsIgnoreCase("D")) {
				myPlayer.addToDiamonds(new Integer(card[1]));
			}
			else if (card[0].equalsIgnoreCase("H")) {
				myPlayer.addToHearts(new Integer(card[1]));
			}	
			else if (card[0].equalsIgnoreCase("C")) {
				myPlayer.addToClubs(new Integer(card[1]));
			}	
			else if (card[0].equalsIgnoreCase("S")) {
				myPlayer.addToSpades(new Integer(card[1]));
			}	
		}
	}
	
	public void whoIsWin () {															// +++
				
		String[] semiFinalist1 = compareTwoCards(myCard, firstEnemyCard);
		String[] semiFinalist2 = compareTwoCards(secondEnemyCard, thirdEnemyCard);
		String[] winner = compareTwoCards(semiFinalist1, semiFinalist2);

		if (winner[0].equalsIgnoreCase(myCard[0])) {
			if (winner[1].equalsIgnoreCase(myCard[1])) {
				this.setFirstPlayer(0);
				return;
			}
		}
		
		if (winner[0].equalsIgnoreCase(firstEnemyCard[0])) {
			if (winner[1].equalsIgnoreCase(firstEnemyCard[1])) {
				this.setFirstPlayer(1);
				return;
			}
		}
		
		if (winner[0].equalsIgnoreCase(secondEnemyCard[0])) {
			if (winner[1].equalsIgnoreCase(secondEnemyCard[1])) {
				this.setFirstPlayer(2);
				return;
			}
		}
		
		if (winner[0].equalsIgnoreCase(thirdEnemyCard[0])) {
			if (winner[1].equalsIgnoreCase(thirdEnemyCard[1])) {
				this.setFirstPlayer(3);
				return;
			}
		}
		
		System.out.println("ERROR! firstPlayer was not setted. (firstPlayer = -1)");
		this.setFirstPlayer(-1);
	}
	
	public String[] compareTwoCards (String[] card1, String[] card2) {					// +++
		
		if ((card1[0].equalsIgnoreCase(trumpCard) && card2[0].equalsIgnoreCase(trumpCard)) || 
			(card1[0].equalsIgnoreCase(firstCardType) && card2[0].equalsIgnoreCase(firstCardType))) {
			// KK, FF
			if (new Integer(card1[1]) > new Integer(card2[1]))
				return card1;
			else if (new Integer(card1[1]) < new Integer(card2[1]))
				return card2;
		}
		
		if (card1[0].equalsIgnoreCase(trumpCard) && !card2[0].equalsIgnoreCase(trumpCard)) {
			// KF, KO
			return card1;
		}
		
		if (!card1[0].equalsIgnoreCase(trumpCard) && card2[0].equalsIgnoreCase(trumpCard)) {
			// FK, OK
			return card2;
		}
		
		if (card1[0].equalsIgnoreCase(firstCardType) && !card2[0].equalsIgnoreCase(firstCardType) && !card2[0].equalsIgnoreCase(trumpCard)) {
			// FO
			return card1;
		}
		
		if (!card1[0].equalsIgnoreCase(firstCardType) && !card1[0].equalsIgnoreCase(trumpCard) && card2[0].equalsIgnoreCase(firstCardType)) {
			// OF
			return card2;
		}
		
		if (!card1[0].equalsIgnoreCase(firstCardType) && !card1[0].equalsIgnoreCase(trumpCard) &&
			!card2[0].equalsIgnoreCase(firstCardType) && !card2[0].equalsIgnoreCase(trumpCard)) {
			// OO
			if (new Integer(card1[1]) > new Integer(card2[1]))
				return card1;
			else if (new Integer(card1[1]) < new Integer(card2[1]))
				return card2;
		}
		
		System.out.println("ERROR! We not compared two cards! return null.");
		return null;
	}
	
	public void run() {																	// +++
		
		if (firstPlayer == 0) {
			System.out.print("What is MY CARD (D5,H6,C10,S14): ");
			setMyCard(input.next().split("",2));
			
			this.firstCardType = myCard[0];
			
			System.out.print("What is FIRST Enemy Card (D5,H6,C10,S14): ");
			setFirstEnemyCard(input.next().split("",2));
			
			System.out.print("What is SECOND Enemy Card (D5,H6,C10,S14): ");
			setSecondEnemyCard(input.next().split("",2));
			
			System.out.print("What is THIRD Enemy Card (D5,H6,C10,S14): ");
			setThirdEnemyCard(input.next().split("",2));
		}
		
		else if (firstPlayer == 1) {
			System.out.print("What is FIRST Enemy Card (D5,H6,C10,S14): ");
			setFirstEnemyCard(input.next().split("",2));
			
			this.firstCardType = firstEnemyCard[0];
			
			System.out.print("What is SECOND Enemy Card (D5,H6,C10,S14): ");
			setSecondEnemyCard(input.next().split("",2));
			
			System.out.print("What is THIRD Enemy Card (D5,H6,C10,S14): ");
			setThirdEnemyCard(input.next().split("",2));
			
			setMyCard(myPlayer.whatIsMyCardAsLastCard(trumpCard, firstCardType, firstEnemyCard, secondEnemyCard, thirdEnemyCard));
			System.out.println("Bizim oynayacaðýmýz kart: " + myCard[0] + myCard[1]);
		}
		
		else if (firstPlayer == 2) {
			System.out.print("What is SECOND Enemy Card (D5,H6,C10,S14): ");
			setSecondEnemyCard(input.next().split("",2));
			
			firstCardType = secondEnemyCard[0];
			
			System.out.print("What is THIRD Enemy Card (D5,H6,C10,S14): ");
			setThirdEnemyCard(input.next().split("",2));
			
			System.out.print("What is MY CARD (D5,H6,C10,S14): ");
			setMyCard(input.next().split("",2));

			System.out.print("What is FIRST Enemy Card (D5,H6,C10,S14): ");
			setFirstEnemyCard(input.next().split("",2));
		}
		
		else if (firstPlayer == 3) {
			System.out.print("What is THIRD Enemy Card (D5,H6,C10,S14): ");
			setThirdEnemyCard(input.next().split("",2));
			
			firstCardType = thirdEnemyCard[0];
			
			System.out.print("What is MY CARD (D5,H6,C10,S14): ");
			setMyCard(input.next().split("",2));
			
			System.out.print("What is FIRST Enemy Card (D5,H6,C10,S14): ");
			setFirstEnemyCard(input.next().split("",2));
			
			System.out.print("What is SECOND Enemy Card (D5,H6,C10,S14): ");
			setSecondEnemyCard(input.next().split("",2));
		}
		
		else {
			System.out.println("Game will not run. Because firstPlayer != 0,1,2,3.");
		}
	}
	
	public void displayMyCards () {														// +++
		
		System.out.println("\nDiamonds: " + myPlayer.getDiamonds());
		System.out.println("Hearts: " + myPlayer.getHearts());
		System.out.println("Clubs: " + myPlayer.getClubs());
		System.out.println("Spades: " + myPlayer.getSpades());
	}
	
}
