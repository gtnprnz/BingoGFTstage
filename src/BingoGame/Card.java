package BingoGame;

import java.util.ArrayList;
import java.util.Random;

public class Card {
	private int[][] numbers;
	private static int cardNumber = 0;
	private static Random random = new Random();

	public Card(ArrayList<Integer> numeriUtilizzati) {
		numbers = new int[3][5];
		ArrayList<Integer> numeriEstratti = new ArrayList<Integer>();
		while (numeriEstratti.size() != 15) {
			int numeroSingolo = random.nextInt(1, 91);
			if (!numeriUtilizzati.contains(numeroSingolo)) {
				numeriEstratti.add(numeroSingolo);
				numeriUtilizzati.add(numeroSingolo);
			}
		}
		numeriEstratti.sort(null);
		int index = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				numbers[j][i] = numeriEstratti.get(index);
				index++;
			}
		}
		cardNumber++;
		printCard();
	}

	public boolean checkWin() {
		for (int i = 0; i < 3; i++) {
			int five = 0;
			for (int j = 0; j < 5; j++) {
				if (numbers[i][j] == 0)
					five++;
			}
			if (five == 5) {
				return true;
			}
		}
		return false;
	}

	public void checkNumber(int extracted) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				if (numbers[i][j] == extracted) {
					numbers[i][j] = 0;
					return;
				}
			}
		}
	}

	public void printCard() {
		System.out.println("--------- SCHEDA NUMERO " + cardNumber + " ---------");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(numbers[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

}
