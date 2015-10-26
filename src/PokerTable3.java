
public class PokerTable3 {

	public boolean hand1Won(Hand3 hand1, Hand3 hand2) {

		if (hand1.compareTo(hand2) == 1)
			return true;
		else if (hand1.compareTo(hand2) == -1)
			return false;
		else {
			if ((hand1.getPoints() == Score3.HIGHCARD) || (hand1.getPoints() == Score3.FLUSH)) {
				if (Handparser3.checkDrawForHighcard(hand1.getCards(), hand2.getCards())) {
					return true;
				} else
					return false;
			}

			else {

				if (Handparser3.checkDraw(hand1.getCards(), hand2.getCards())) {
					return true;
				}
				if ((hand1.getPoints() == Score3.TWOPAIRS) && (Handparser3.checkTwoPairs(hand1.getCards(), hand2.getCards()))) {
					return true;
				}
			}
			return false;
		}
	}
}