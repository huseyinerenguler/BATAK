import java.util.ArrayList;
import java.util.Collections;

public class MyPlayer extends Player {

	private ArrayList<Integer> notMyDiamonds = new ArrayList<Integer>();
	private ArrayList<Integer> notMyHearts = new ArrayList<Integer>();
	private ArrayList<Integer> notMyClubs = new ArrayList<Integer>();
	private ArrayList<Integer> notMySpades = new ArrayList<Integer>();
	
	private ArrayList<Integer> dropDiamonds = new ArrayList<Integer>();
	private ArrayList<Integer> dropHearts = new ArrayList<Integer>();
	private ArrayList<Integer> dropClubs = new ArrayList<Integer>();
	private ArrayList<Integer> dropSpades = new ArrayList<Integer>();
	
	MyPlayer() {																		// +++
		for (int x = 2; x < 15; x++) {
			this.addToNotMyDiamonds(x);
			this.addToNotMyHearts(x);
			this.addToNotMyClubs(x);
			this.addToNotMySpades(x);
		}
	}
	
	public boolean doIHaveThisCard (String cardType, int card) {						// +++
		
		if (cardType.equalsIgnoreCase("D")) {
			return getDiamonds().contains(new Integer(card));
		}
		else if (cardType.equalsIgnoreCase("H")) {
			return getHearts().contains(new Integer(card));
		}
		else if (cardType.equalsIgnoreCase("C")) {
			return getClubs().contains(new Integer(card));
		}
		else if (cardType.equalsIgnoreCase("S")) {
			return getSpades().contains(new Integer(card));
		}
		
		return false;
	}
	
	public boolean doIHaveAnyCardInThisType (String cardType) {							// +++
		
		if (cardType.equalsIgnoreCase("D")) {
			if (getDiamonds().size() > 0)
				return true;
		}
		else if (cardType.equalsIgnoreCase("H")) {
			if (getHearts().size() > 0)
				return true;
		}
		else if (cardType.equalsIgnoreCase("C")) {
			if (getClubs().size() > 0)
				return true;
		}
		else if (cardType.equalsIgnoreCase("S")) {
			if (getSpades().size() > 0)
				return true;
		}
		
		return false;
	}
	
	// it is actually work for all card combinations									// +++
	public String[] whatIsMyCardAsLastCard (String trumpCard, String firstCardType, String[] firstPlayerCard, String[] secondPlayerCard, String[] thirdPlayerCard) {
		
		String[] myCard = new String[2];
		
		System.out.println("first: " + firstCardType);
		System.out.println("trump: " + trumpCard);
		if (firstCardType.equalsIgnoreCase(trumpCard)) {
			System.out.println("control-1");
			if (doIHaveAnyCardInThisType(trumpCard)) {
				System.out.println("control-2");
				int max_value = findMaxValueInAType(trumpCard, firstPlayerCard, secondPlayerCard, thirdPlayerCard);
				myCard = chooseSensibleCard(trumpCard, max_value);
					
				if (myCard == null){
					System.out.println("control-3");
					myCard = chooseSensibleCard(trumpCard, 1);
				}
				
				return myCard;
			}
			
			else {
				System.out.println("control-4");
				myCard = findOtherMinimumCard(firstCardType, trumpCard);
				return myCard;
			}
		}
		
		else {
			System.out.println("control-5");
			if (doIHaveAnyCardInThisType(firstCardType)) {
				System.out.println("control-6");
				if (secondPlayerCard[0] != trumpCard && thirdPlayerCard[0] != trumpCard) {
					System.out.println("control-7");
					int max_value = findMaxValueInAType(firstCardType, firstPlayerCard, secondPlayerCard, thirdPlayerCard);
					myCard = chooseSensibleCard(firstCardType, max_value);
					
					if (myCard == null) {
						System.out.println("control-8");
						myCard = chooseSensibleCard(firstCardType, 1);
					}
						
					return myCard;
				}
				
				else {
					System.out.println("control-9");
					myCard = chooseSensibleCard(firstCardType, 1);
					return myCard;
				}
			}
			
			else if (doIHaveAnyCardInThisType(trumpCard)) {
				System.out.println("control-10");
				int max_value = findMaxValueInAType(trumpCard, firstPlayerCard, secondPlayerCard, thirdPlayerCard);
				myCard = chooseSensibleCard(trumpCard, max_value);
					
				if (myCard == null) {
					System.out.println("control-11");
					myCard = chooseSensibleCard(trumpCard, 1);
				}
					
				return myCard;
			}
			
			else {
				System.out.println("control-12");
				myCard = findOtherMinimumCard(firstCardType, trumpCard);
				return myCard;
			}
		}
	}
	
	public String[] whatIsMyCardAsFirstCard (String trumpCard, boolean trumpCardSituation) {	// 14.02.2018 13:20
	
		// First part --> Control all of my #14 cards and control how many dropped in each type.
		if (!trumpCard.equalsIgnoreCase("D") && this.doIHaveThisCard("D", 14) && dropDiamonds.size() < 10) {
			return new String[] {"D", (14 + "")};}
		if (!trumpCard.equalsIgnoreCase("H") && this.doIHaveThisCard("H", 14) && dropHearts.size() < 10) {
			return new String[] {"H", (14 + "")};}
		if (!trumpCard.equalsIgnoreCase("C") && this.doIHaveThisCard("C", 14) && dropClubs.size() < 10) {
			return new String[] {"C", (14 + "")};}
		if (!trumpCard.equalsIgnoreCase("S") && this.doIHaveThisCard("S", 14) && dropSpades.size() < 10) {
			return new String[] {"S", (14 + "")};}
		
		// Second part --> ?????????????????????????????????????????????????????????????????????????????????
		int myBiggestDiamond = (this.getDiamonds().size() > 0) ? Collections.max(this.getDiamonds()) : -1;
		int myBiggestHeart = (this.getHearts().size() > 0) ? Collections.max(this.getHearts()) : -1;
		int myBiggestClub = (this.getClubs().size() > 0) ? Collections.max(this.getClubs()) : -1;
		int myBiggestSpade = (this.getSpades().size() > 0) ? Collections.max(this.getSpades()) : -1;
		
		// Diamonds control part
		int control = 1;
		if (myBiggestDiamond != -1) {
			for (int card = myBiggestDiamond + 1; card < 15; card++) {
				if (!dropDiamonds.contains(new Integer(card)))
					control = 0;}
			if (control == 1 && dropDiamonds.size() < 10) {
				return new String[] {"D", (myBiggestDiamond + "")};}}
		
		// Hearts control part
		control = 1;
		if (myBiggestHeart != -1) {
			for (int card = myBiggestHeart + 1; card < 15; card++) {
				if (!dropHearts.contains(new Integer(card)))
					control = 0;}
			if (control == 1 && dropHearts.size() < 10) {
				return new String[] {"H", (myBiggestHeart + "")};}}
		
		// Clubs control part
		control = 1;
		if (myBiggestClub != -1) {
			for (int card = myBiggestClub + 1; card < 15; card++) {
				if (!dropClubs.contains(new Integer(card)))
					control = 0;}
			if (control == 1 && dropClubs.size() < 10) {
				return new String[] {"C", (myBiggestClub + "")};}}
		
		// Spades control part
		control = 1;
		if (myBiggestSpade != -1) {
			for (int card = myBiggestSpade + 1; card < 15; card++) {
				if (!dropSpades.contains(new Integer(card)))
					control = 0;}
			if (control == 1 && dropSpades.size() < 10) {
				return new String[] {"S", (myBiggestSpade + "")};}}
				
		// Third Part --> ?????????????????????????????????????????????????????????
		
		
		
		
		
		
		return null;
	}
	
	public String[] findOtherMinimumCard (String firstCardType, String trumpCard) {		// +++
		
		String cardType1 = "default";
		String cardType2 = "default";
		String cardType3 = "default";
		
		if (firstCardType.equalsIgnoreCase("D")) {
			if (trumpCard.equalsIgnoreCase("D")) {
				cardType1 = "H";
				cardType2 = "C";
				cardType3 = "S";
			}
			else if (trumpCard.equalsIgnoreCase("H")) {
				cardType1 = "C";
				cardType2 = "S";
			}
			else if (trumpCard.equalsIgnoreCase("C")) {
				cardType1 = "H";
				cardType2 = "S";	
			}
			else if (trumpCard.equalsIgnoreCase("S")) {
				cardType1 = "H";
				cardType2 = "C";
			}
		}

		else if (firstCardType.equalsIgnoreCase("H")) {
			if (trumpCard.equalsIgnoreCase("H")) {
				cardType1 = "D";
				cardType2 = "C";
				cardType3 = "S";
			}
			else if (trumpCard.equalsIgnoreCase("D")) {
				cardType1 = "C";
				cardType2 = "S";
			}
			else if (trumpCard.equalsIgnoreCase("C")) {
				cardType1 = "D";
				cardType2 = "S";	
			}
			else if (trumpCard.equalsIgnoreCase("S")) {
				cardType1 = "D";
				cardType2 = "C";
			}
		}
		
		else if (firstCardType.equalsIgnoreCase("C")) {
			if (trumpCard.equalsIgnoreCase("C")) {
				cardType1 = "D";
				cardType2 = "H";
				cardType3 = "S";
			}
			else if (trumpCard.equalsIgnoreCase("H")) {
				cardType1 = "D";
				cardType2 = "S";
			}
			else if (trumpCard.equalsIgnoreCase("D")) {
				cardType1 = "H";
				cardType2 = "S";	
			}
			else if (trumpCard.equalsIgnoreCase("S")) {
				cardType1 = "D";
				cardType2 = "H";
			}
		}
		
		else if (firstCardType.equalsIgnoreCase("S")) {
			if (trumpCard.equalsIgnoreCase("S")) {
				cardType1 = "D";
				cardType2 = "H";
				cardType3 = "C";
			}
			else if (trumpCard.equalsIgnoreCase("H")) {
				cardType1 = "D";
				cardType2 = "C";
			}
			else if (trumpCard.equalsIgnoreCase("D")) {
				cardType1 = "H";
				cardType2 = "C";	
			}
			else if (trumpCard.equalsIgnoreCase("C")) {
				cardType1 = "D";
				cardType2 = "H";
			}
		}
		
		if (cardType1 == "default" || cardType2 == "default") {
			System.out.println("ERROR! in findOtherMinimum() someone(card1,card2) still 'default', return null. ");
			return null;
		}
		
		for (int number = 2; number < 15; number++) {
			if (doIHaveThisCard(cardType1, number)) {
				String[] myCard = {cardType1, (number + "")};
				return myCard;
			}
			if (doIHaveThisCard(cardType2, number)) {
				String[] myCard = {cardType2, (number + "")};
				return myCard;
			}
			if (doIHaveThisCard(cardType3, number)) {
				String[] myCard = {cardType3, (number + "")};
				return myCard;
			}
		}
		
		System.out.println("ERROR! in findOtherMinimum() something wrong, return null.");
		return null;
	}
	
	public String[] chooseSensibleCard (String cardType, int max_value) {				// +++
		
		for (int number = max_value+1; number < 15; number++) {
								
			if (doIHaveThisCard(cardType, number)) {
				String[] myCard = {cardType, (number + "")};	
				return myCard;
			}
		}
		return null;
	}
	
	public int findMaxValueInAType (String cardType, String[] firstPlayerCard, String[] secondPlayerCard, String[] thirdPlayerCard) {		// +++
	
		int max_value = -1;
		
		if (firstPlayerCard[0].equalsIgnoreCase(cardType)) {
			if (new Integer(firstPlayerCard[1]) > max_value)
				max_value = new Integer(firstPlayerCard[1]);
		}
		
		if (secondPlayerCard[0].equalsIgnoreCase(cardType)) {
			if (new Integer(secondPlayerCard[1]) > max_value)
				max_value = new Integer(secondPlayerCard[1]);
		}
		
		if (thirdPlayerCard[0].equalsIgnoreCase(cardType)) {
			if (new Integer(thirdPlayerCard[1]) > max_value)
				max_value = new Integer(thirdPlayerCard[1]);
		}
		
		return max_value;
	}
	
	public void addToDiamonds(int card) {												// +++
		super.addToDiamonds(card);
		removeFromNotMyDiamonds(card);
	}
	public void addToHearts(int card) {													// +++
		super.addToHearts(card);
		removeFromNotMyHearts(card);
	}
	public void addToClubs(int card) {													// +++
		super.addToClubs(card);
		removeFromNotMyClubs(card);
	}
	public void addToSpades(int card) {													// +++
		super.addToSpades(card);
		removeFromNotMySpades(card);
	}
	
	public void addToNotMyDiamonds(int card) {											// +++
		notMyDiamonds.add(card);
	}
	public void addToNotMyHearts(int card) {											// +++
		notMyHearts.add(card);
	}
	public void addToNotMyClubs(int card) {												// +++
		notMyClubs.add(card);
	}
	public void addToNotMySpades(int card) {											// +++
		notMySpades.add(card);
	}
	
	public void removeFromNotMyDiamonds(int card) {										// +++
		notMyDiamonds.remove(new Integer(card));
	}
	public void removeFromNotMyHearts(int card) {										// +++
		notMyHearts.remove(new Integer(card));
	}
	public void removeFromNotMyClubs(int card) {										// +++
		notMyClubs.remove(new Integer(card));
	}
	public void removeFromNotMySpades(int card) {										// +++
		notMySpades.remove(new Integer(card));
	}
	
	public ArrayList<Integer> getNotMyDiamonds() {										// +++
		return notMyDiamonds;
	}
	public ArrayList<Integer> getNotMyHearts() {										// +++
		return notMyHearts;
	}
	public ArrayList<Integer> getNotMyClubs() {											// +++
		return notMyClubs;
	}
	public ArrayList<Integer> getNotMySpades() {										// +++
		return notMySpades;
	}
	
	public void addToDropDiamonds(int card) {											// +++
		dropDiamonds.add(card);
		removeFromNotMyDiamonds(card);
	}
	public void addToDropHearts(int card) {												// +++
		dropHearts.add(card);
		removeFromNotMyHearts(card);
	}
	public void addToDropClubs(int card) {												// +++
		dropClubs.add(card);
		removeFromNotMyClubs(card);
	}
	public void addToDropSpades(int card) {												// +++
		dropSpades.add(card);
		removeFromNotMySpades(card);
	}
	
	public ArrayList<Integer> getDropDiamonds() {										// +++
		return dropDiamonds;
	}
	public ArrayList<Integer> getDropHearts() {											// +++
		return dropHearts;
	}
	public ArrayList<Integer> getDropClubs() {											// +++
		return dropClubs;
	}
	public ArrayList<Integer> getDropSpades() {											// +++
		return dropSpades;
	}
	
}
