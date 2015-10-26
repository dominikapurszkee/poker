
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PokerReader4 {
	private int counter = 0;

	public int getCounter() {
		return counter;
	}

	public void read() {
		FileReader fr = null;
		String linia = "";

		try {
			fr = new FileReader("poker.txt");
		} catch (FileNotFoundException e) {
			System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
			System.exit(1);
		}

		BufferedReader bfr =

		new BufferedReader(fr);

		try {
			while ((linia = bfr.readLine()) != null) {

				String[] cards = linia.split(" ");
				String[] cards1 = new String[5];
				String[] cards2 = new String[5];
				for (int i = 0; i < 5; i++) {
					cards1[i] = cards[i];
				}

				for (int i = 5, k = 0; i < 10; i++, k++) {
					cards2[k] = cards[i];
				}

				Hand3 hand1 = new Hand3(cards1);
				Hand3 hand2 = new Hand3(cards2);
				PokerTable3 pt = new PokerTable3();
				if (pt.hand1Won(hand1, hand2)) {
					counter++;
				}

			}
		} catch (IOException e) {
			System.out.println("BŁĄD ODCZYTU Z PLIKU!");
			System.exit(2);
		}

		// ZAMYKANIE PLIKU
		try {
			fr.close();
		} catch (IOException e) {
			System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
			System.exit(3);
		}
	}

	public static void main(String[] args) {
		PokerReader4 pr4 = new PokerReader4();
		pr4.read();
		System.out.println(pr4.getCounter());
	}
}
