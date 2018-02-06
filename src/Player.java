import java.util.ArrayList;

public class Player {

	private ArrayList<Integer> diamonds = new ArrayList<Integer>();
	private ArrayList<Integer> hearts = new ArrayList<Integer>();
	private ArrayList<Integer> clubs = new ArrayList<Integer>();
	private ArrayList<Integer> spades = new ArrayList<Integer>();
	
	
	public void addToDiamonds(int card) {
		diamonds.add(card);
	}
	public void addToHearts(int card) {
		hearts.add(card);
	}
	public void addToClubs(int card) {
		clubs.add(card);
	}
	public void addToSpades(int card) {
		spades.add(card);
	}
	
	public void removeFromDiamonds(int card) {
		diamonds.remove(new Integer(card));
	}
	public void removeFromHearts(int card) {
		hearts.remove(new Integer(card));
	}
	public void removeFromClubs(int card) {
		clubs.remove(new Integer(card));
	}
	public void removeFromSpades(int card) {
		spades.remove(new Integer(card));
	}
	
	public ArrayList<Integer> getDiamonds() {
		return diamonds;
	}
	public ArrayList<Integer> getHearts() {
		return hearts;
	}
	public ArrayList<Integer> getClubs() {
		return clubs;
	}
	public ArrayList<Integer> getSpades() {
		return spades;
	}
	
	
}
