import java.util.Scanner;

public class Game {
	
	Scanner input = new Scanner(System.in);
	
	private MyPlayer myPlayer = new MyPlayer();
	private String trumpCard; // D,H,C or S (UPPERCASE)
	private String[] myCard;  // first index --> D,H,C,S (UPPERCASE)  +++  second index --> 2,3,4,..,14
	private String[] firstEnemyCard; // first index --> D,H,C,S (UPPERCASE) +++  second index --> 2,3,4,..,14
	private String[] secondEnemyCard; // first index --> D,H,C,S (UPPERCASE) +++  second index --> 2,3,4,..,14
	private String[] thirdEnemyCard; // first index --> D,H,C,S (UPPERCASE) +++  second index --> 2,3,4,..,14
	private String firstCardType;
	private int firstPlayer; // 0,1,2 or 3
	
	
	public void setTrumpCard (String trumpCard) {
		
		if (trumpCard.equalsIgnoreCase("Kupa"))
			this.trumpCard = "H";
		else if (trumpCard.equalsIgnoreCase("Maça"))
			this.trumpCard = "S";
		else if (trumpCard.equalsIgnoreCase("Sinek"))
			this.trumpCard = "C";
		else if (trumpCard.equalsIgnoreCase("Karo"))
			this.trumpCard = "D";
		else
			this.trumpCard = "NULL";
	}
	public void setMyCard(String[] myCard) {
		
		if (myCard[0].equalsIgnoreCase("D")) {
			myPlayer.removeFromDiamonds(new Integer(myCard[1]));
			myPlayer.addToDropDiamonds(new Integer(myCard[1]));
			this.myCard = myCard;
		}
			
		else if (myCard[0].equalsIgnoreCase("K")) {
			myPlayer.removeFromHearts(new Integer(myCard[1]));
			myPlayer.addToDropHearts(new Integer(myCard[1]));
			this.myCard = myCard;
		}
			
		else if (myCard[0].equalsIgnoreCase("S")) {
			myPlayer.removeFromClubs(new Integer(myCard[1]));
			myPlayer.addToDropClubs(new Integer(myCard[1]));
			this.myCard = myCard;
		}
			
		else if (myCard[0].equalsIgnoreCase("M")) {
			myPlayer.removeFromSpades(new Integer(myCard[1]));
			myPlayer.addToDropSpades(new Integer(myCard[1]));
			this.myCard = myCard;
		}
		else {
			System.out.println("ERROR! myCard was not added. (myCard = null)");
			this.myCard = null;
		}
	}	
	public void setFirstEnemyCard(String[] firstEnemyCard) {
		
		if (firstEnemyCard[0].equalsIgnoreCase("D")) {
			myPlayer.addToDropDiamonds(new Integer(firstEnemyCard[1]));
			this.firstEnemyCard = firstEnemyCard;
		}
		
		else if (firstEnemyCard[0].equalsIgnoreCase("K")) {
			myPlayer.addToDropHearts(new Integer(firstEnemyCard[1]));
			this.firstEnemyCard = firstEnemyCard;
		}
		
		else if (firstEnemyCard[0].equalsIgnoreCase("S")) {
			myPlayer.addToDropClubs(new Integer(firstEnemyCard[1]));
			this.firstEnemyCard = firstEnemyCard;
		}	
		
		else if (firstEnemyCard[0].equalsIgnoreCase("M")) {
			myPlayer.addToDropSpades(new Integer(firstEnemyCard[1]));
			this.firstEnemyCard = firstEnemyCard;
		}
		
		else {
			System.out.println("ERROR! firstEnemyCard was not added. (firstEnemyCard = null)");
			this.firstEnemyCard = null;
		}
		
	}
	public void setSecondEnemyCard(String[] secondEnemyCard) {
		
		if (secondEnemyCard[0].equalsIgnoreCase("D")) {
			myPlayer.addToDropDiamonds(new Integer(firstEnemyCard[1]));
			this.secondEnemyCard = secondEnemyCard;
		}
		
		else if (secondEnemyCard[0].equalsIgnoreCase("K")) {
			myPlayer.addToDropHearts(new Integer(secondEnemyCard[1]));
			this.secondEnemyCard = secondEnemyCard;
		}
		
		else if (secondEnemyCard[0].equalsIgnoreCase("S")) {
			myPlayer.addToDropClubs(new Integer(secondEnemyCard[1]));
			this.secondEnemyCard = secondEnemyCard;
		}	
		
		else if (secondEnemyCard[0].equalsIgnoreCase("M")) {
			myPlayer.addToDropSpades(new Integer(secondEnemyCard[1]));
			this.secondEnemyCard = secondEnemyCard;
		}
		
		else {
			System.out.println("ERROR! secondEnemyCard was not added. (secondEnemyCard = null)");
			this.secondEnemyCard = null;
		}
	}
	public void setThirdEnemyCard(String[] thirdEnemyCard) {
		
		if (thirdEnemyCard[0].equalsIgnoreCase("D")) {
			myPlayer.addToDropDiamonds(new Integer(thirdEnemyCard[1]));
			this.thirdEnemyCard = thirdEnemyCard;
		}
		
		else if (thirdEnemyCard[0].equalsIgnoreCase("K")) {
			myPlayer.addToDropHearts(new Integer(thirdEnemyCard[1]));
			this.thirdEnemyCard = thirdEnemyCard;
		}
		
		else if (thirdEnemyCard[0].equalsIgnoreCase("S")) {
			myPlayer.addToDropClubs(new Integer(thirdEnemyCard[1]));
			this.thirdEnemyCard = thirdEnemyCard;
		}	
		
		else if (thirdEnemyCard[0].equalsIgnoreCase("M")) {
			myPlayer.addToDropSpades(new Integer(thirdEnemyCard[1]));
			this.thirdEnemyCard = thirdEnemyCard;
		}
		
		else {
			System.out.println("ERROR! thirdEnemyCard was not added. (thirdEnemyCard = null)");
			this.thirdEnemyCard = null;
		}
	}
	public void setFirstPlayer(int firstPlayer) {
		this.firstPlayer = firstPlayer; // 0, 1, 2 or 3
	}
	
	public String getTrumpCard() {
		return trumpCard;
	}
	public String[] getMyCard() {
		return myCard;
	}
	public String[] getFirstEnemyCard() {
		return firstEnemyCard;
	}
	public String[] getSecondEnemyCard() {
		return secondEnemyCard;
	}
	public String[] getThirdEnemyCard() {
		return thirdEnemyCard;
	}
	public int getFirstPlayer() {
		return firstPlayer;
	}	
	
	/*
	// This function distributes the cards in a mixed way to the players.
	public void distributeCards() {
		
		int[] numbers = new int[13];
		int randomNumber;
		boolean control = false;
		
		for (int x = 0; x < 13; x++) {
			
			randomNumber = 1 + (int)(Math.random() * 52);
			
			for (int index = 0; index < numbers.length; index++) {
				
				if (numbers[index] == randomNumber) {
					control = true;
					break;
				}
			}
			
			if (control == true) {
				control = false;
				x--;
			}
			
			else {
				
				numbers[x] = randomNumber;
					
				if (randomNumber < 14)
					myPlayer.addToDiamonds(randomNumber%13 + 2);
				else if (randomNumber < 27)
					myPlayer.addToHearts(randomNumber%13 + 2);
				else if (randomNumber < 40)
					myPlayer.addToClubs(randomNumber%13 + 2);
				else
					myPlayer.addToSpades(randomNumber%13 + 2);
			}
		}
	}*/
	
	public void getMyCardsFromUser() {
		
		String[] card = new String[2];
		
		for (int x = 0; x < 13; x++) {
			System.out.print("Enter " + (x+1) + ". card (K5,M6,S13,D14): ");
			card = input.next().toUpperCase().split("",2);
			
			if (card[0].equalsIgnoreCase("D"))
				myPlayer.addToDiamonds(new Integer(card[1]));
			else if (card[0].equalsIgnoreCase("K"))
				myPlayer.addToHearts(new Integer(card[1]));
			else if (card[0].equalsIgnoreCase("S"))
				myPlayer.addToClubs(new Integer(card[1]));
			else if (card[0].equalsIgnoreCase("M"))
				myPlayer.addToSpades(new Integer(card[1]));
		}
	}
	
	// This function finds the winner and determines the first player for the new hand.
	public void whoIsWin () {
		
		System.out.println("ilk incerde print: " + firstPlayer);
		
		String[] semiFinalist1 = compareTwoCards(myCard, firstEnemyCard);
		String[] semiFinalist2 = compareTwoCards(secondEnemyCard, thirdEnemyCard);
		String[] winner = compareTwoCards(semiFinalist1, semiFinalist2);
		
		System.out.println(winner[0] + winner[1]);
		
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
				System.out.println("ýcerde: " + firstPlayer);
				return;
			}
		}
		
		System.out.println("ERROR! firstPlayer was not setted. (firstPlayer = -1)");
		this.setFirstPlayer(-1);
	}
	
	// This function compares two cards and returns the winning card.
	public String[] compareTwoCards (String[] card1, String[] card2) {
		
		if ((card1[0].equalsIgnoreCase(trumpCard) && card2[0].equalsIgnoreCase(trumpCard)) || 
			(card1[0].equalsIgnoreCase(firstCardType) && card2[0].equalsIgnoreCase(firstCardType))) {
			
			// buyuk olan
		}
		
		
		
		if (card1[0].equalsIgnoreCase(trumpCard) && !card2[0].equalsIgnoreCase(trumpCard)) {
			
			// card1
			// KF, KO
		}
		
		if (!card1[0].equalsIgnoreCase(trumpCard) && card2[0].equalsIgnoreCase(trumpCard)) {
			
			// card2
			// FK, OK
		}
		
		if (card1[0].equalsIgnoreCase(firstCardType) && !card2[0].equalsIgnoreCase(firstCardType) && !card2[0].equalsIgnoreCase(trumpCard)) {
			
			// card1
			// FO
		}
		
		if (!card1[0].equalsIgnoreCase(firstCardType) && !card1[0].equalsIgnoreCase(trumpCard) && card2[0].equalsIgnoreCase(firstCardType)) {
			
			// card1
			// OF
		}
		
		
		
		
		
		
		
		/*if ((card1[0].equalsIgnoreCase(firstCardType) && card2[0].equalsIgnoreCase(firstCardType)) || 
			(card1[0].equalsIgnoreCase(trumpCard) && card2[0].equalsIgnoreCase(trumpCard)) || 
			(!card1[0].equalsIgnoreCase(firstCardType) && !card2[0].equalsIgnoreCase(firstCardType) && !card1[0].equalsIgnoreCase(trumpCard) && card2[0].equalsIgnoreCase(trumpCard))) {
			
			if (new Integer(card1[1]) > new Integer(card2[1])) {
				return card1;
			}
			else {
				return card2;
			}
		}
		
		
		if (card1[0] != trumpCard && card2[0] == trumpCard) {
			return card2;
		}
		
		if (card1[0] == firstCardType && card2[0] != firstCardType && card2[0] != trumpCard) {
			return card1;
		}
		
		if (card1[0] != trumpCard && card1[0] != firstCardType && card2[0] == firstCardType) {
			return card2;
		}
		*/
		return null;
	}
	
	public void run() {
		
		if (firstPlayer == 0) {
					
			System.out.print("\nWhat is MY CARD (K5,M6,S13,D14): ");
			setMyCard(input.next().split("",2));
			
			this.firstCardType = myCard[0];
			
			System.out.print("What is FIRST Enemy Card (K5,M6,S13,D14): ");
			setFirstEnemyCard(input.next().split("",2));
			
			System.out.print("What is SECOND Enemy Card (K5,M6,S13,D14): ");
			setSecondEnemyCard(input.next().split("",2));
			
			System.out.print("What is THIRD Enemy Card (K5,M6,S13,D14): ");
			setThirdEnemyCard(input.next().split("",2));
		}
		
		else if (firstPlayer == 1) {
			
			System.out.print("/nWhat is FIRST Enemy Card (K5,M6,S13,D14): ");
			setFirstEnemyCard(input.next().split("",2));
			
			this.firstCardType = firstEnemyCard[0];
			
			System.out.print("What is SECOND Enemy Card (K5,M6,S13,D14): ");
			setSecondEnemyCard(input.next().split("",2));
			
			System.out.print("What is THIRD Enemy Card (K5,M6,S13,D14): ");
			setThirdEnemyCard(input.next().split("",2));
			
			setMyCard(myPlayer.whatIsMyCardAsLastCard(trumpCard, firstCardType, firstEnemyCard, secondEnemyCard, thirdEnemyCard));
			System.out.println("Bilgisayarin oynayacagi bizim kartimiz: " + myCard[0] + myCard[1]);
		}
		
		else if (firstPlayer == 2) {
		
			System.out.print("/nWhat is SECOND Enemy Card (K5,M6,S13,D14): ");
			setSecondEnemyCard(input.next().split("",2));
			
			firstCardType = secondEnemyCard[0];
			
			System.out.print("What is THIRD Enemy Card (K5,M6,S13,D14): ");
			setThirdEnemyCard(input.next().split("",2));
			
			System.out.print("What is MY CARD (K5,M6,S13,D14): ");
			setMyCard(input.next().split("",2));

			System.out.print("What is FIRST Enemy Card (K5,M6,S13,D14): ");
			setFirstEnemyCard(input.next().split("",2));
		}
		
		else if (firstPlayer == 3) {
			
			System.out.print("/nWhat is THIRD Enemy Card (K5,M6,S13,D14): ");
			setThirdEnemyCard(input.next().split("",2));
			
			firstCardType = thirdEnemyCard[0];
			
			System.out.print("What is MY CARD (K5,M6,S13,D14): ");
			setMyCard(input.next().split("",2));
			
			System.out.print("What is FIRST Enemy Card (K5,M6,S13,D14): ");
			setFirstEnemyCard(input.next().split("",2));
			
			System.out.print("What is SECOND Enemy Card (K5,M6,S13,D14): ");
			setSecondEnemyCard(input.next().split("",2));
		}
	}
	
	public void displayMyCards () {
		
		System.out.println("\nMy Diamonds: " + myPlayer.getDiamonds());
		System.out.println("Hearts: " + myPlayer.getHearts());
		System.out.println("Clubs: " + myPlayer.getClubs());
		System.out.println("Spades: " + myPlayer.getSpades());
	}
}
