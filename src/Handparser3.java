import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Handparser3 {

	static Score3 parse3(String[] cards) {

		Map<String, Integer> cardMap = new HashMap<String, Integer>();
		cardMap = createCardMap(cards);

		List<Integer> cardList = new ArrayList<Integer>();

		for (Map.Entry<String, Integer> entry : cardMap.entrySet()) {
			cardList.add(entry.getValue());
		}
		Collections.sort(cardList, Collections.reverseOrder());
		return Score3.parse(cardList.get(0), cardList.get(1));

	}

	private static Map<String, Integer> createCardMap(String[] cards) {
		Map<String, Integer> cardMap = new HashMap<String, Integer>();
		for (int i = 0; i < cards.length; i++) {
			String key = cards[i].substring(0, 1);
			if (cardMap.containsKey(key)) {
				cardMap.put(key, cardMap.get(key) + 1);
			} else {
				cardMap.put(key, 1);
			}
		}
		return cardMap;
	}

	public static Value3 enumConverter(String card) {
		return Value3.parse(card);

	}

	public static boolean containsStraight(List<String> cardList) {
		List<Value3> enumList = new ArrayList<Value3>();
		enumList = makeSortedListofEnumKeys(cardList);
		List<Value3> lista = makeSortedListofEnumKeys(cardList);
		Set<Value3> set = new HashSet<Value3>();
		set.addAll(lista);
		int result = 0;
		result = enumList.get(4).getValue() - enumList.get(0).getValue();
		if ((result == 4) && (set.size() == 5)) {
			return true;
		}

		return false;
	}

	public static boolean containsFlush(String[] cards) {
		Set<String> colourSet = new HashSet<String>();
		for (int i = 0; i < cards.length; i++) {
			String card = cards[i].substring(1, 2);
			colourSet.add(card);
		}
		if (colourSet.size() == 1) {
			return true;
		}
		return false;
	}

	public static boolean containsRoyalFlush(String[] cards) {
		List<String> cardList = createCardList(cards);
		List<Value3> enumList = new ArrayList<Value3>();
		enumList = makeSortedListofEnumKeys(cardList);
		if ((enumList.get(0) == Value3.TEN) && (containsFlush(cards)) && (containsStraight(cardList))) {
			return true;
		}
		return false;
	}

	public static List<Value3> makeSortedListofEnumKeys(List<String> cardList) {
		List<Value3> enumList = new ArrayList<Value3>();
		for (String card : cardList) {
			enumList.add(enumConverter(card));
		}
		Comparator<Value3> ValueComparator = new Comparator<Value3>() {

			public int compare(Value3 o1, Value3 o2) {
				return o1.value - o2.value;
			}
		};
		Collections.sort(enumList, ValueComparator);
		return enumList;
	}

	private static Value3 getHighestCard(List<String> cardList) {
		List<Value3> enumList = new ArrayList<Value3>();
		enumList = makeSortedListofEnumKeys(cardList);
		return enumList.get(enumList.size() - 1);
	}

	private static Integer getHighestValue(String[] cards) {
		List<Integer> valueList = new LinkedList<Integer>();
		valueList = makeSortedListofValues(cards);
		return valueList.get(valueList.size() - 1);
	}

	private static List<Integer> makeSortedListofValues(String[] cards) {
		List<Integer> valueList = new LinkedList<Integer>();
		Map<String, Integer> cardMap = new HashMap<String, Integer>();
		cardMap = createCardMap(cards);
		for (Map.Entry<String, Integer> entry : cardMap.entrySet()) {
			Integer v = entry.getValue();
			valueList.add(v);
		}
		Collections.sort(valueList);
		return valueList;
	}

	public static boolean checkDrawForHighcard(String[] cards1, String[] cards2) {

		List<String> Cardlist1 = createCardList(cards1);
		List<String> Cardlist2 = createCardList(cards2);
		List<Value3> Keylist1 = makeSortedListofEnumKeys(Cardlist1);
		List<Value3> Keylist2 = makeSortedListofEnumKeys(Cardlist2);
		// Value3 card1 = Keylist1.get(Keylist1.size() - 1);
		// Value3 card2 = Keylist2.get(Keylist2.size() - 1);
		int i = Keylist1.size() - 1;

		while (i > -1) {
			Value3 card1 = Keylist1.get(i);
			Value3 card2 = Keylist2.get(i);
			if (card1.ordinal() > card2.ordinal()) {
				return true;
			} else if (card1.ordinal() < card2.ordinal()) {
				return false;
			} else {
				i--;
			}

		}
		return false;

	}

	public static boolean checkDraw(String[] cards1, String[] cards2) {

		Map<String, Integer> cardMap1 = createCardMap(cards1);
		Map<String, Integer> cardMap2 = createCardMap(cards2);
		List<Integer> list = new LinkedList<Integer>();
		list = makeSortedListofValues(cards1);
		while (!list.isEmpty()) {
			Integer value = getHighestValue(cards1);
			String val1 = getKeyforValue(value, cardMap1);
			String val2 = getKeyforValue(value, cardMap2);
			if (Value3.parse(val1).ordinal() > Value3.parse(val2).ordinal()) {
				return true;
			} else
				list.remove(list.size() - 1);
		}
		return false;
	}

	public static boolean checkTwoPairs(String[] cards1, String[] cards2) {

		Map<String, Integer> cardMap1 = createCardMap(cards1);
		Map<String, Integer> cardMap2 = createCardMap(cards2);
		List<String> cardList1 = createCardList(cards1);
		List<String> cardList2 = createCardList(cards2);
		List<String> listPairs1 = new LinkedList<String>();
		List<String> listPairs2 = new LinkedList<String>();

		for (Map.Entry<String, Integer> entry : cardMap1.entrySet()) {
			Integer v = entry.getValue();
			if (v == 2) {
				String key = entry.getKey();
				listPairs1.add(key);
			}
		}
		for (Map.Entry<String, Integer> entry : cardMap2.entrySet()) {
			Integer v = entry.getValue();
			if (v == 2) {
				String key = entry.getKey();
				listPairs2.add(key);
			}
		}

		List<Value3> enumList1 = makeSortedListofEnumKeys(listPairs1);
		List<Value3> enumList2 = makeSortedListofEnumKeys(listPairs2);

		if (enumList1.get(1).ordinal() > enumList2.get(1).ordinal()) {
			return true;
		}
		if (enumList1.get(1).ordinal() < enumList2.get(1).ordinal()) {
			return false;
		}
		if (enumList1.get(0).ordinal() > enumList2.get(0).ordinal()) {
			return true;
		}
		if (enumList1.get(0).ordinal() < enumList2.get(0).ordinal()) {
			return false;
		}
		if (getHighestCard(cardList1).ordinal() > getHighestCard(cardList2).ordinal()) {
			return true;
		}

		return false;
	}

	public static List<String> createCardList(String[] cards) {
		List<String> cardList = new LinkedList<String>();
		for (int i = 0; i < cards.length; i++) {
			String key = cards[i].substring(0, 1);
			cardList.add(key);
		}

		return cardList;
	}

	private static String getKeyforValue(Integer value, Map<String, Integer> cardMap) {

		for (Map.Entry<String, Integer> entry : cardMap.entrySet()) {
			Integer v = entry.getValue();
			if (v == value) {
				return entry.getKey();
			}
		}
		return null;
	}

}
