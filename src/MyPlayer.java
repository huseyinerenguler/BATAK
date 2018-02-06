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
	
	// kullanýlmama ihtimali var
	public boolean doIHaveThisCard (String type, int card) {
		
		if (type.equalsIgnoreCase("D")) {
			return getDiamonds().contains(new Integer(card));
		}
		else if (type.equalsIgnoreCase("H")) {
			return getHearts().contains(new Integer(card));
		}
		else if (type.equalsIgnoreCase("C")) {
			return getClubs().contains(new Integer(card));
		}
		else if (type.equalsIgnoreCase("S")) {
			return getSpades().contains(new Integer(card));
		}
		
		return false;
	}
	
	public boolean doIHaveCardInThisType (String cardType) {
		
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
	
	public String[] whatIsMyCardAsLastCard (String trumpCard, String firstCardType, String[] firstPlayerCard, String[] secondPlayerCard, String[] thirdPlayerCard) {
		
		if (doIHaveCardInThisType(firstCardType)) {
			int max_value = findMaxValueInAType(firstCardType, firstPlayerCard, secondPlayerCard, thirdPlayerCard);
			return choiceCard(firstCardType, max_value);
		}
		
		else {
		
			if (doIHaveCardInThisType(trumpCard)) {
				int max_value = findMaxValueInAType(trumpCard, firstPlayerCard, secondPlayerCard, thirdPlayerCard);
				return choiceCard(trumpCard, max_value);
			}
		}
		
		return null;
	}
	
	public String[] choiceCard (String cardType, int max_value) {
		
		// buyuk kart atýlacak
		for (int number = max_value+1; number < 15; number++) {
						
			if (doIHaveThisCard(cardType, number)) {
				String[] myCard = new String[2];
				myCard[0] = cardType;
				myCard[1] = number + "";
							
				return myCard;
			}
		}
					
		// buyuk kart yoksa en kucuk kart atilacak
		for (int number = 2; number < 15; number++) {
						
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
	
		int max_value = 0;
		
		if (firstPlayerCard[0] == cardType) {
			if (new Integer(firstPlayerCard[1]) > max_value)
			max_value = new Integer(firstPlayerCard[1]);
		}
		
		if (secondPlayerCard[0] == cardType) {
			if (new Integer(secondPlayerCard[1]) > max_value)
			max_value = new Integer(secondPlayerCard[1]);
		}
		
		if (thirdPlayerCard[0] == cardType) {
			if (new Integer(thirdPlayerCard[1]) > max_value)
			max_value = new Integer(thirdPlayerCard[1]);
		}
		
		return max_value;
	}
	
	
	/*
	// not finish lunge->card
	public int whatIsMyCardAsLastCard (String type, int firstEnemyCard, int secondEnemyL, int thirdEnemyLunge) {
		
		int max_value = firstEnemyLunge;
		if (secondEnemyLunge > max_value) max_value = secondEnemyLunge;
		if (thirdEnemyLunge > max_value) max_value = thirdEnemyLunge;
		
		if (type.equalsIgnoreCase("diamonds") && getDiamonds().size() > 0) {
			
			// if I have big card
			for (int x = 1; max_value+x < 15; x++) {
				if (doIHave("diamonds", max_value+x)) {
					removeFromDiamonds(max_value+x);
					addToDropDiamonds(max_value+x);
					return max_value+x;
				}
			}
			
			// if I have not big card
			for (int x = 2; x < 15; x++) {
				if (doIHave("diamonds", x)) {
					removeFromDiamonds(x);
					addToDropDiamonds(x);
					return x;
				}
			}
		}
		
		else if (type.equalsIgnoreCase("hearts") && getHearts().size() > 0) {
			
			// if I have big card
			for (int x = 1; max_value+x < 15; x++) {
				if (doIHave("hearts", max_value+x)) {
					removeFromHearts(max_value+x);
					addToDropHearts(max_value+x);
					return max_value+x;
				}
			}
			
			// if I have not big card
			for (int x = 2; x < 15; x++) {
				if (doIHave("hearts", x)) {
					removeFromDiamonds(x);
					addToDropDiamonds(x);
					return x;
				}
			}
		}
		
		
		
		return 0; // koz varsa koz atýlcak burda
		
		
	}*/
	
	
	
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
