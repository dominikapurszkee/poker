
public enum Value3 implements Comparable<Value3> {
	TWO(0, "2"), THREE(1, "3"), FOUR(2, "4"), FIVE(3, "5"), SIX(4, "6"), SEVEN(5, "7"), EIGHT(6, "8"), NINE(7, "9"), TEN(8, "T"), JACK(9,
			"J"), QUEEN(10, "Q"), KING(11, "K"), ACE(12, "A");

	int value;
	String shortname;

	Value3(int value, String shortname) {
		this.value = value;
		this.shortname = shortname;

	}

	Value3() {
	}

	public int getValue() {
		return value;
	}

	public static Value3 parse(String val) {
		for (Value3 v : Value3.values()) {
			if (v.shortname.equalsIgnoreCase(val))
				return v;
		}

		return null;
	}
}