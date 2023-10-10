package BingoGame;

import java.util.ArrayList;

public class Person {

	private String name;
	private Card[] cards;

	public Person(String name, int nCards) {
		this.name = name;
		this.cards = new Card[nCards];
		ArrayList<Integer> numeriUtilizzati = new ArrayList<Integer>();
		for (int i = 0; i < nCards; i++) {
			cards[i] = new Card(numeriUtilizzati);
		}
	}

	public String getName() {
		return name;
	}

	public void checkNumber(int extracted) {
		for (Card c : cards) {
			c.checkNumber(extracted);
		}
	}

	public boolean checkWin() {
		for (Card c : cards) {
			if (c.checkWin())
				return true;
		}
		return false;
	}

}
