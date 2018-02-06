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
		this.trumpCard = trumpCard; // D, H, C or S
	}
	public void setMyCard(String[] myCard) {
		this.myCard = myCard;
		
		if (myCard[0].compareToIgnoreCase("D") == 0)
			myPlayer.addToDropDiamonds(new Integer(myCard[1]));
		else if (myCard[0].compareToIgnoreCase("H") == 0)
			myPlayer.addToDropHearts(new Integer(myCard[1]));
		else if (myCard[0].compareToIgnoreCase("C") == 0)
			myPlayer.addToDropClubs(new Integer(myCard[1]));
		else if (myCard[0].compareToIgnoreCase("S") == 0)
			myPlayer.addToDropSpades(new Integer(myCard[1]));
	}	
	public void setFirstEnemyCard(String[] firstEnemyCard) {
		this.firstEnemyCard = firstEnemyCard;
		
		if (firstEnemyCard[0].compareToIgnoreCase("D") == 0)
			myPlayer.addToDropDiamonds(new Integer(firstEnemyCard[1]));
		else if (firstEnemyCard[0].compareToIgnoreCase("H") == 0)
			myPlayer.addToDropHearts(new Integer(firstEnemyCard[1]));
		else if (firstEnemyCard[0].compareToIgnoreCase("C") == 0)
			myPlayer.addToDropClubs(new Integer(firstEnemyCard[1]));
		else if (firstEnemyCard[0].compareToIgnoreCase("S") == 0)
			myPlayer.addToDropSpades(new Integer(firstEnemyCard[1]));
	}
	public void setSecondEnemyCard(String[] secondEnemyCard) {
		this.secondEnemyCard = secondEnemyCard;
		
		if (secondEnemyCard[0].compareToIgnoreCase("D") == 0)
			myPlayer.addToDropDiamonds(new Integer(secondEnemyCard[1]));
		else if (secondEnemyCard[0].compareToIgnoreCase("H") == 0)
			myPlayer.addToDropHearts(new Integer(secondEnemyCard[1]));
		else if (secondEnemyCard[0].compareToIgnoreCase("C") == 0)
			myPlayer.addToDropClubs(new Integer(secondEnemyCard[1]));
		else if (secondEnemyCard[0].compareToIgnoreCase("S") == 0)
			myPlayer.addToDropSpades(new Integer(secondEnemyCard[1]));
	}
	public void setThirdEnemyCard(String[] thirdEnemyCard) {
		this.thirdEnemyCard = thirdEnemyCard;
		
		if (thirdEnemyCard[0].compareToIgnoreCase("D") == 0)
			myPlayer.addToDropDiamonds(new Integer(thirdEnemyCard[1]));
		else if (thirdEnemyCard[0].compareToIgnoreCase("H") == 0)
			myPlayer.addToDropHearts(new Integer(thirdEnemyCard[1]));
		else if (thirdEnemyCard[0].compareToIgnoreCase("C") == 0)
			myPlayer.addToDropClubs(new Integer(thirdEnemyCard[1]));
		else if (thirdEnemyCard[0].compareToIgnoreCase("S") == 0)
			myPlayer.addToDropSpades(new Integer(thirdEnemyCard[1]));
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
	}
	
	// This function finds the winner and determines the first player for the new hand.
	public void whoIsWin () {
		
		String[] semiFinalist1 = compareTwoCards(myCard, firstEnemyCard);
		String[] semiFinalist2 = compareTwoCards(secondEnemyCard, thirdEnemyCard);
		String[] winner = compareTwoCards(semiFinalist1, semiFinalist2);
		
		if (winner == myCard) {
			setFirstPlayer(0);
		}
		else if (winner == firstEnemyCard) {
			setFirstPlayer(1);
		}
		else if (winner == secondEnemyCard) {
			setFirstPlayer(2);
		}
		else if (winner == thirdEnemyCard) {
			setFirstPlayer(3);
		}
	}
	
	// This function compares two cards and returns the winning card.
	public String[] compareTwoCards (String[] card1, String[] card2) {
		
		if ((card1[0] == firstCardType && card2[0] == firstCardType) || 
			(card1[0] == trumpCard && card2[0] == trumpCard) || 
			(card1[0] != firstCardType && card2[0] != firstCardType)) {
			
			if (new Integer(card1[1]) > new Integer(card2[1])) {
				return card1;
			}
			else {
				return card2;
			}
		}
		
		if (card1[0] == trumpCard && card2[0] != trumpCard) {
			return card1;
		}
		
		if (card1[0] != trumpCard && card2[0] == trumpCard) {
			return card2;
		}
		
		if (card1[0] == firstCardType && card2[0] != firstCardType) {
			return card1;
		}
		
		if (card1[0] != firstCardType && card2[0] == firstCardType) {
			return card2;
		}
		
		return null;
	}
	
	public void run() {
		
		if (firstPlayer == 0) {
			// what is my card ?
			firstCardType = myCard[0];
			
			System.out.print("What is FIRST Enemy Card: "); // D5, H6, C12, S10 ...
			setFirstEnemyCard(input.next().toUpperCase().split(""));
			
			System.out.print("What is SECOND Enemy Card: ");
			setSecondEnemyCard(input.next().toUpperCase().split(""));
			
			System.out.print("What is THIRD Enemy Card: ");
			setThirdEnemyCard(input.next().toUpperCase().split(""));
		}
		
		else if (firstPlayer == 1) {
			System.out.print("What is FIRST Enemy Card: ");
			setFirstEnemyCard(input.next().toUpperCase().split(""));
			firstCardType = firstEnemyCard[0];
			
			System.out.print("What is SECOND Enemy Card: ");
			setSecondEnemyCard(input.next().toUpperCase().split(""));
			
			System.out.print("What is THIRD Enemy Card: ");
			setThirdEnemyCard(input.next().toUpperCase().split(""));
			
			// what is my card ?
		}
		
		else if (firstPlayer == 2) {
			System.out.print("What is SECOND Enemy Card: ");
			setSecondEnemyCard(input.next().toUpperCase().split(""));
			firstCardType = secondEnemyCard[0];
			
			System.out.print("What is THIRD Enemy Card: ");
			setThirdEnemyCard(input.next().toUpperCase().split(""));
			
			// what is my card ? 
			
			System.out.print("What is FIRST Enemy Card: ");
			setFirstEnemyCard(input.next().toUpperCase().split(""));
		}
		
		else if (firstPlayer == 3) {
			System.out.print("What is THIRD Enemy Card: ");
			setThirdEnemyCard(input.next().toUpperCase().split(""));
			firstCardType = thirdEnemyCard[0];
			
			// what is my card ? 
			
			System.out.print("What is FIRST Enemy Card: ");
			setFirstEnemyCard(input.next().toUpperCase().split(""));
			
			System.out.print("What is SECOND Enemy Card: ");
			setSecondEnemyCard(input.next().toUpperCase().split(""));
		}
	}
	
	// gereksiz
	public void calculateExactHand() {
		
		int diamondsNumber = 0;
		int heartsNumber = 0;
		int clubsNumber = 0;
		int spadesNumber = 0;
		int notdiamondsNumber = 0;
		int notheartsNumber = 0;
		int notclubsNumber = 0;
		int notspadesNumber = 0;
		
		for (int x: myPlayer.getDiamonds()) {diamondsNumber += (x*x);}
		for (int x: myPlayer.getHearts()) {heartsNumber += (x*x);}
		for (int x: myPlayer.getClubs()) {clubsNumber += (x*x);}
		for (int x: myPlayer.getSpades()) {spadesNumber += (x*x);}
		for (int x: myPlayer.getNotMyDiamonds()) {notdiamondsNumber += (x*x);}
		for (int x: myPlayer.getNotMyHearts()) {notheartsNumber += (x*x);}
		for (int x: myPlayer.getNotMyClubs()) {notclubsNumber += (x*x);}
		for (int x: myPlayer.getNotMySpades()) {notspadesNumber += (x*x);}
		
		System.out.println("\nDiamonds NUMBER: " + diamondsNumber);
		System.out.println("Hearts NUMBER: " + heartsNumber);
		System.out.println("Clubs NUMBER: " + clubsNumber);
		System.out.println("Spades NUMBER: " + spadesNumber);
		System.out.println("\nNot Diamonds NUMBER: " + notdiamondsNumber);
		System.out.println("Not Hearts NUMBER: " + notheartsNumber);
		System.out.println("Not Clubs NUMBER: " + notclubsNumber);
		System.out.println("Not Spades NUMBER: " + notspadesNumber);
		
	}
	
	// gereksiz
	public void display () {
		
		System.out.println("\nMy Diamonds: " + myPlayer.getDiamonds());
		System.out.println("Not My Diamonds: " + myPlayer.getNotMyDiamonds());
		System.out.println("Drop Diaomonds: " + myPlayer.getDropDiamonds());
		
		/*System.out.println("\nHearts: " + myPlayer.getHearts());
		System.out.println("Not My Hearts: " + myPlayer.getNotMyHearts());
		
		System.out.println("\nClubs: " + myPlayer.getClubs());
		System.out.println("Not My Clubs: " + myPlayer.getNotMyClubs());
		
		System.out.println("\nSpades: " + myPlayer.getSpades());
		System.out.println("Not My Spades: " + myPlayer.getNotMySpades());
		*/
	}
}
