import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProbaTest {

	@Test
	public void shouldParseOnePair() {
		String[] tabs = { "3H", "3S", "5H", "2H", "7H" };
		Score3 result = Handparser3.parse3(tabs);
		assertEquals(Score3.PAIR, result);
	}

	@Test
	public void shouldParseTwoPairs() {
		String[] tabs = { "3H", "3S", "5H", "5H", "7H" };
		Score3 result = Handparser3.parse3(tabs);
		assertEquals(Score3.TWOPAIRS, result);
	}

	@Test
	public void shouldParseTriplet() {
		String[] tabs = { "KH", "KS", "KC", "3H", "4C" };
		Score3 result = Handparser3.parse3(tabs);
		assertEquals(Score3.THREEOFKIND, result);
	}

	@Test
	public void shouldParseFour() {
		String[] tabs = { "KH", "KH", "KC", "4C", "KH" };
		Score3 result = Handparser3.parse3(tabs);
		assertEquals(Score3.FOUROFKIND, result);
	}

	@Test
	public void shouldParseFull() {
		String[] tabs = { "KH", "KH", "2C", "2H", "2C" };
		Score3 result = Handparser3.parse3(tabs);
		assertEquals(Score3.FULL, result);
	}

	@Test
	public void shouldCalculateFlush() {
		String[] tabs = { "AH", "KH", "2H", "3H", "5H" };
		Hand3 hand = new Hand3(tabs);
		Score3 result = hand.getPoints();
		assertEquals(Score3.FLUSH, result);
	}

	@Test
	public void shouldCalculateSTRAIGHT() {
		String[] tabs = { "QH", "KS", "JH", "TH", "9H" };
		Hand3 hand = new Hand3(tabs);
		Score3 result = hand.getPoints();
		assertEquals(Score3.STRAIGHT, result);
	}

	@Test
	public void shouldCalculateSTRAIGHTFLUSH() {
		String[] tabs = { "QH", "KH", "JH", "TH", "9H" };
		Hand3 hand = new Hand3(tabs);
		Score3 result = hand.getPoints();
		assertEquals(Score3.STRAIGHTFLUSH, result);
	}

	@Test
	public void shouldCalculateROYALFLUSH() {
		String[] tabs = { "QH", "KH", "JH", "TH", "AH" };
		Hand3 hand = new Hand3(tabs);
		Score3 result = hand.getPoints();
		assertEquals(Score3.ROYALFLUSH, result);
	}

	@Test
	public void shouldCalculateHIGHCARD() {
		String[] tabs = { "2H", "KH", "JS", "TH", "3H" };
		Hand3 hand = new Hand3(tabs);
		Score3 result = hand.getPoints();
		assertEquals(Score3.HIGHCARD, result);
	}

	@Test
	public void Hand1ShuoldWin() {
		String[] tabs = { "2H", "KH", "JH", "TH", "3H" };
		String[] tabs2 = { "2H", "3H", "4S", "5H", "6H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(true, result);
	}

	@Test
	public void HighcardVSHighcard() {
		String[] tabs = { "2S", "4H", "6H", "7H", "AH" };
		String[] tabs2 = { "3S", "4H", "6S", "7H", "AH" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void HighcardVSPair() {
		String[] tabs = { "2S", "3H", "5H", "6H", "AH" };
		String[] tabs2 = { "3S", "2H", "3S", "4H", "7H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void HighcardVSTwoPairs() {
		String[] tabs = { "2S", "3H", "5H", "6H", "AH" };
		String[] tabs2 = { "3S", "3H", "2S", "2H", "7H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void HighcardVSThreeofKind() {
		String[] tabs = { "2S", "3H", "5H", "6H", "AH" };
		String[] tabs2 = { "3S", "3H", "3S", "2H", "7H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void HighcardVSStraight() {
		String[] tabs = { "2S", "3H", "5H", "6H", "AH" };
		String[] tabs2 = { "2S", "3H", "4S", "5H", "6H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void HighcardVSFlush() {
		String[] tabs = { "2S", "3H", "5H", "6H", "AH" };
		String[] tabs2 = { "2H", "3H", "4H", "5H", "6H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void HighcardVSFull() {
		String[] tabs = { "2S", "3H", "5H", "6H", "AH" };
		String[] tabs2 = { "2H", "2H", "4H", "4H", "4H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void HighcardVSFour() {
		String[] tabs = { "2S", "3H", "5H", "6H", "AH" };
		String[] tabs2 = { "2H", "4H", "4H", "4H", "4H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void HighcardVSStraightFlush() {
		String[] tabs = { "2S", "3H", "5H", "6H", "AH" };
		String[] tabs2 = { "2H", "3H", "4H", "5H", "6H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void HighcardVSRoyalFlush() {
		String[] tabs = { "2S", "3H", "5H", "6H", "AH" };
		String[] tabs2 = { "TH", "JH", "QH", "KH", "AH" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void PairVSPair() {
		String[] tabs = { "2S", "2H", "5H", "5H", "AH" };
		String[] tabs2 = { "2S", "2H", "5H", "5H", "KH" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(true, result);
	}

	@Test
	public void PairVSThree() {
		String[] tabs = { "2S", "2H", "5H", "5H", "AH" };
		String[] tabs2 = { "2H", "2H", "5H", "5H", "5H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void PairVSfour() {
		String[] tabs = { "2S", "3H", "5H", "AH", "AH" };
		String[] tabs2 = { "2H", "4H", "5H", "5H", "5H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void PairVStwopairs() {
		String[] tabs = { "2S", "3H", "5H", "AH", "AH" };
		String[] tabs2 = { "2H", "4H", "4H", "5H", "5H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void PairVSStraight() {
		String[] tabs = { "2S", "3H", "4H", "5H", "6H" };
		String[] tabs2 = { "AH", "AS", "4H", "3H", "5H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(true, result);
	}

	@Test
	public void PairVSFlush() {
		String[] tabs = { "AS", "AH", "4H", "5H", "6H" };
		String[] tabs2 = { "7H", "2H", "4H", "3H", "5H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void PairVSFull() {
		String[] tabs = { "AS", "AH", "4H", "5H", "6H" };
		String[] tabs2 = { "2H", "2S", "3H", "3S", "3H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void PairVSFOUR() {
		String[] tabs = { "AS", "AH", "2H", "4H", "6H" };
		String[] tabs2 = { "2H", "2S", "2H", "2S", "3H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void PairVSStraightFlush() {
		String[] tabs = { "AS", "AH", "4H", "3H", "6H" };
		String[] tabs2 = { "2H", "3H", "4H", "5H", "6H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void PairVSRoyalFlush() {
		String[] tabs = { "TH", "TS", "QH", "KH", "AH" };
		String[] tabs2 = { "TH", "JH", "QH", "KH", "AH" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void TwoPairsVSThree() {
		String[] tabs = { "TH", "TS", "QH", "QH", "AH" };
		String[] tabs2 = { "2H", "2H", "2H", "KH", "AH" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void TwoPairsVSStraight() {
		String[] tabs = { "TH", "TS", "QH", "QH", "AH" };
		String[] tabs2 = { "2H", "3S", "4H", "5H", "6H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void TwoPairsVSFLUSH() {
		String[] tabs = { "TH", "TH", "KH", "QH", "AH" };
		String[] tabs2 = { "2H", "2H", "4H", "4S", "6H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(true, result);
	}

	@Test
	public void TwoPairsVSStraightFlush() {
		String[] tabs = { "TH", "TS", "KH", "KH", "AH" };
		String[] tabs2 = { "2H", "3H", "4H", "5S", "6H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void ThreeVSThree() {
		String[] tabs = { "TH", "TS", "TH", "KH", "AH" };
		String[] tabs2 = { "2H", "2H", "2H", "3S", "AH" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(true, result);
	}

	@Test
	public void ThreeVSFour() {
		String[] tabs = { "TH", "TS", "TH", "KH", "AH" };
		String[] tabs2 = { "2H", "2H", "2H", "2S", "AH" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void ThreeVSFULL() {
		String[] tabs = { "2H", "2S", "2H", "3H", "3H" };
		String[] tabs2 = { "AH", "AH", "AH", "2S", "5H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(true, result);
	}

	@Test
	public void ThreeVSFLUSH() {
		String[] tabs = { "2H", "2H", "2H", "3H", "3H" };
		String[] tabs2 = { "AH", "AH", "AH", "2S", "5H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(true, result);
	}

	@Test
	public void ThreeVSStraight() {
		String[] tabs = { "2H", "3S", "4H", "5H", "6H" };
		String[] tabs2 = { "AH", "AH", "AH", "2S", "5H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(true, result);
	}

	@Test
	public void FOURVSFOUR() {
		String[] tabs = { "2H", "2S", "2H", "2H", "6H" };
		String[] tabs2 = { "AH", "AH", "AH", "AS", "5H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void FOURVSFULL() {
		String[] tabs = { "2H", "2S", "2H", "3H", "3H" };
		String[] tabs2 = { "AH", "AH", "AH", "AS", "5H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void FOURVSStraightL() {
		String[] tabs = { "2H", "2S", "2H", "3H", "3H" };
		String[] tabs2 = { "AH", "AH", "AH", "AS", "5H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void FOURVSFLUSH() {
		String[] tabs = { "2H", "2S", "2H", "2H", "3H" };
		String[] tabs2 = { "AH", "AH", "AH", "AH", "5H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(true, result);
	}

	@Test
	public void FULLVSFULL() {
		String[] tabs = { "2H", "2S", "3H", "3H", "3H" };
		String[] tabs2 = { "AH", "AH", "2H", "2S", "2H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(true, result);
	}

	@Test
	public void FULLVSFLUSH() {
		String[] tabs = { "2H", "2S", "3H", "3H", "3H" };
		String[] tabs2 = { "AH", "AH", "2H", "2H", "2H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(true, result);
	}

	@Test
	public void FULLVSSTRAIGHT() {
		String[] tabs = { "2H", "2S", "3H", "3H", "3H" };
		String[] tabs2 = { "2H", "3S", "4H", "5H", "6H" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(true, result);
	}

	@Test
	public void FLUSHVSFLUSH() {
		String[] tabs = { "2H", "2H", "3H", "3H", "3H" };
		String[] tabs2 = { "2S", "3S", "4S", "5S", "6S" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void STRAIGHFLUSHVSSTRAIGHTFLUSH() {
		String[] tabs = { "3H", "4H", "5H", "6H", "7H" };
		String[] tabs2 = { "2S", "3S", "4S", "5S", "6S" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(false, result);
	}

	@Test
	public void ROYALHFLUSHVSSTRAIGHTFLUSH() {
		String[] tabs = { "TH", "JH", "QH", "KH", "AH" };
		String[] tabs2 = { "2S", "3S", "4S", "5S", "6S" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(true, result);
	}

	@Test
	public void DRAWHighcard() {
		String[] tabs = { "TH", "JH", "QS", "KH", "AH" };
		String[] tabs2 = { "2S", "3S", "4H", "5S", "AS" };
		Hand3 hand1 = new Hand3(tabs);
		Hand3 hand2 = new Hand3(tabs2);
		PokerTable3 pt = new PokerTable3();
		boolean result = pt.hand1Won(hand1, hand2);
		assertEquals(true, result);
	}

	@Test
	public void DRAWFLUSH() {
		String[] tabs = { "TH", "JH", "QH", "KH", "3H" };
		String[] tabs2 = { "2S", "3S", "4S", "5S", "AS" };
		boolean result = Handparser3.checkDrawForHighcard(tabs, tabs2);
		assertEquals(false, result);
	}

	@Test
	public void FullGame() {
		PokerReader4 pr4 = new PokerReader4();
		pr4.read();
		int result = pr4.getCounter();
		assertEquals(376, result);
	}
}
