package BingoGame;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int nPeople;
			boolean victory = false;

			System.out.print("Quante persone giocano: ");
			nPeople = scanner.nextInt();
			Bank bank = new Bank(nPeople);

			while (!victory) {
				int extracted = bank.extractNumber();
				System.out.println("E' stato estratto il numero: " + extracted);
				bank.checkNumber(extracted);
				if (bank.checkWin())
					victory = !victory;
			}
		}
	}

}
