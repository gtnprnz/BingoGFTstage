package BingoGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bank {
	private Person[] people;
	private static ArrayList<Integer> extractedNumbers = new ArrayList<>();
	
	public Bank(int nPeople) {
		people = new Person[nPeople];
		for(int i = 0; i < nPeople; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Inserisci nome giocatore: ");
			String name = sc.nextLine();
			boolean check = false;
			int nCards = 0;
			while(!check) {
				System.out.print("Inserisci tessere giocatore: ");
				nCards = sc.nextInt();
				if(nCards >= 1 && nCards <= 6) check = !check;
			}
			people[i] = new Person(name, nCards);
		}
	}
	
	public void checkNumber(int checked) {
		for(Person p: people) {
			p.checkNumber(checked);
		}
	}
	
	public boolean checkWin() {
		for(Person p: people) {
			if(p.checkWin()) {
				System.out.println("HA VINTO " + p.getName());
				return true;
			}
		}
		return false;
	}
	
	public int extractNumber() {
		boolean ok = false;
		int extract = 0;
		while(!ok) {
			extract = new Random().nextInt(1,91);
			if(!extractedNumbers.contains(extract)) {
				extractedNumbers.add(extract);
				ok = !ok;
			}
		}
		return extract;
	}
}
