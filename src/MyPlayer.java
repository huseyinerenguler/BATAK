import java.util.ArrayList;

public class MyPlayer extends Player {

	private ArrayList<Integer> notMyDiamonds = new ArrayList<Integer>();
	private ArrayList<Integer> notMyHearts = new ArrayList<Integer>();
	private ArrayList<Integer> notMyClubs = new ArrayList<Integer>();
	private ArrayList<Integer> notMySpades = new ArrayList<Integer>();
	
	private ArrayList<Integer> dropDiamonds = new ArrayList<Integer>();
	private ArrayList<Integer> dropHearts = new ArrayList<Integer>();
	private ArrayList<Integer> dropClubs = new ArrayList<Integer>();
	private ArrayList<Integer> dropSpades = new ArrayList<Integer>();
	
	
	MyPlayer() {
		
		for (int x = 2; x < 15; x++) {
			this.addToNotMyDiamonds(x);
			this.addToNotMyHearts(x);
			this.addToNotMyClubs(x);
			this.addToNotMySpades(x);
		}
	}
	
	public boolean doIHaveThisCard (String cardType, int card) {
		
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
	
	public boolean doIHaveAnyCardInThisType (String cardType) {
		
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
	
	// bitti testleri yapýlacak
	public String[] whatIsMyCardAsLastCard (String trumpCard, String firstCardType, String[] firstPlayerCard, String[] secondPlayerCard, String[] thirdPlayerCard) {
		
		String[] myCard = new String[2];
		
		if (doIHaveAnyCardInThisType(firstCardType)) {
			
			if (secondPlayerCard[0] != trumpCard && thirdPlayerCard[0] != trumpCard) {
				
				int max_value = findMaxValueInAType(firstCardType, firstPlayerCard, secondPlayerCard, thirdPlayerCard);
				myCard = chooseSensibleCard(firstCardType, max_value);
				
				if (myCard == null)
					myCard = chooseSensibleCard(firstCardType, 1);
				
				return myCard;
			}
			
			else {
				myCard = chooseSensibleCard(firstCardType, 1);
				return myCard;
			}
		}
		
		else if (doIHaveAnyCardInThisType(trumpCard)) {
				
			int max_value = findMaxValueInAType(trumpCard, firstPlayerCard, secondPlayerCard, thirdPlayerCard);
			myCard = chooseSensibleCard(trumpCard, max_value);
				
			if (myCard == null)
				myCard = chooseSensibleCard(trumpCard, 1);
				
			return myCard;
		}
		
		else {
			// I know, this way is too bad, but it will change. 
			
			String cardType1 = "A";
			String cardType2 = "A";
			
			if (firstCardType != "D" && trumpCard != "D" && firstCardType != "H" && trumpCard != "H") {
				cardType1 = "D";
				cardType2 = "H";
			}
			else if (firstCardType != "D" && trumpCard != "D" && firstCardType != "C" && trumpCard != "C") {
				cardType1 = "D";
				cardType2 = "C";
			}
			else if (firstCardType != "D" && trumpCard != "D" && firstCardType != "S" && trumpCard != "S") {
				cardType1 = "D";
				cardType2 = "S";
			}
			else if (firstCardType != "H" && trumpCard != "H" && firstCardType != "C" && trumpCard != "C") {
				cardType1 = "H";
				cardType2 = "C";
			}
			else if (firstCardType != "H" && trumpCard != "H" && firstCardType != "S" && trumpCard != "S") {
				cardType1 = "H";
				cardType2 = "S";
			}
			else if (firstCardType != "C" && trumpCard != "C" && firstCardType != "S" && trumpCard != "S") {
				cardType1 = "C";
				cardType2 = "S";
			}
			
			for (int number = 2; number < 15; number++) {
				if (doIHaveThisCard(cardType1, number)) {
					myCard[0] = cardType1;
					myCard[1] = number + "";
					return myCard;
				}
				else if (doIHaveThisCard(cardType2, number)) {
					myCard[0] = cardType2;
					myCard[1] = number + "";
					return myCard;
				}
			}
		}
		
		return null;
	}
	
	// for big, 2. parameter -> max_value
	// for small, 2. parameter -> 1
	public String[] chooseSensibleCard (String cardType, int max_value) {
		
		for (int number = max_value+1; number < 15; number++) {
								
			if (doIHaveThisCard(cardType, number)) {
				String[] myCard = new String[2];
				myCard[0] = cardType;
				myCard[1] = number + "";
									
				return myCard;
			}
		}
		
		return null;
	}
	
	public int findMaxValueInAType (String cardType, String[] firstPlayerCard, String[] secondPlayerCard, String[] thirdPlayerCard) {
	
		int max_value = 1;
		
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
	
	
	public void addToDiamonds(int card) {
		super.addToDiamonds(card);
		removeFromNotMyDiamonds(card);
	}
	public void addToHearts(int card) {
		super.addToHearts(card);
		removeFromNotMyHearts(card);
	}
	public void addToClubs(int card) {
		super.addToClubs(card);
		removeFromNotMyClubs(card);
	}
	public void addToSpades(int card) {
		super.addToSpades(card);
		removeFromNotMySpades(card);
	}
	
	public void addToNotMyDiamonds(int card) {
		notMyDiamonds.add(card);
	}
	public void addToNotMyHearts(int card) {
		notMyHearts.add(card);
	}
	public void addToNotMyClubs(int card) {
		notMyClubs.add(card);
	}
	public void addToNotMySpades(int card) {
		notMySpades.add(card);
	}
	
	public void removeFromNotMyDiamonds(int card) {
		notMyDiamonds.remove(new Integer(card));
	}
	public void removeFromNotMyHearts(int card) {
		notMyHearts.remove(new Integer(card));
	}
	public void removeFromNotMyClubs(int card) {
		notMyClubs.remove(new Integer(card));
	}
	public void removeFromNotMySpades(int card) {
		notMySpades.remove(new Integer(card));
	}
	
	public ArrayList<Integer> getNotMyDiamonds() {
		return notMyDiamonds;
	}
	public ArrayList<Integer> getNotMyHearts() {
		return notMyHearts;
	}
	public ArrayList<Integer> getNotMyClubs() {
		return notMyClubs;
	}
	public ArrayList<Integer> getNotMySpades() {
		return notMySpades;
	}
	
	public void addToDropDiamonds(int card) {
		dropDiamonds.add(card);
		removeFromNotMyDiamonds(card);
	}
	public void addToDropHearts(int card) {
		dropHearts.add(card);
		removeFromNotMyHearts(card);
	}
	public void addToDropClubs(int card) {
		dropClubs.add(card);
		removeFromNotMyClubs(card);
	}
	public void addToDropSpades(int card) {
		dropSpades.add(card);
		removeFromNotMySpades(card);
	}
	
	public ArrayList<Integer> getDropDiamonds() {
		return dropDiamonds;
	}
	public ArrayList<Integer> getDropHearts() {
		return dropHearts;
	}
	public ArrayList<Integer> getDropClubs() {
		return dropClubs;
	}
	public ArrayList<Integer> getDropSpades() {
		return dropSpades;
	}
	
}
