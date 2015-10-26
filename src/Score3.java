
public enum Score3 {

	HIGHCARD(1, 1), PAIR(2, 1), TWOPAIRS(2, 2), THREEOFKIND(3, 1), STRAIGHT, FLUSH, FULL(3, 2), FOUROFKIND(4, 1), STRAIGHTFLUSH, ROYALFLUSH;

	int a, b;

	Score3(int a, int b) {
		this.a = a;
		this.b = b;

	}

	Score3() {
	}

	public static Score3 parse(int a, int b) {
		for (Score3 v : Score3.values()) {
			if ((v.a == a) && (v.b == b)) {
				return v;
			}

		}
		return null;
	}

}