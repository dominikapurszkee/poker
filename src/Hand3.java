import java.util.LinkedList;
import java.util.List;

public class Hand3 implements Comparable<Hand3> {

	String[] cards = new String[5];
	private Score3 points;
	private Score3 score;

	public Hand3(String[] cards) {
		this.cards = cards;
		score = Handparser3.parse3(cards);
		points = calculatePoints();

	}

	public Score3 calculatePoints() {

		List<String> cardList = new LinkedList<String>();
		cardList = Handparser3.createCardList(cards);

		if (Handparser3.containsRoyalFlush(cards)) {
			return Score3.ROYALFLUSH;
		} else if ((Handparser3.containsStraight(cardList)) && (Handparser3.containsFlush(cards))) {
			return Score3.STRAIGHTFLUSH;
		} else if (Handparser3.containsFlush(cards)) {
			return Score3.FLUSH;
		} else if (Handparser3.containsStraight(cardList)) {
			return Score3.STRAIGHT;
		} else if (score != Score3.HIGHCARD) {
			return score;
		}

		return Score3.HIGHCARD;

	}

	String[] getCards() {
		return cards;
	}

	public Score3 getPoints() {
		return this.points;
	}

	public int compareTo(Hand3 o) {
		if (this.points.ordinal() < o.points.ordinal())
			return -1;
		if (this.points.ordinal() > o.points.ordinal())
			return 1;
		return 0;
	}

}
