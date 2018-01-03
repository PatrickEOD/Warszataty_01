package lotto;

import java.util.Scanner;

public class HW3 {
	
	public static void main(String[] args) {
		int min = 0;
		int max = 1000;
		int guess = guessNumber(min, max);
		int pick = pickNumber();
		int count = 0;
		while(!contains(guess, pick) && count <= 10) {
			guess = guessNumber(min, max);
			if(guess > pick) {
				System.out.println("Za dużo");
				max = guess;
				count++;
			} else if(guess < pick) {
				System.out.println("Za mało");
				min = guess;
				count++;
			} 
		}
		if(count <= 10) {
			System.out.println("Wygrałem w " + count + " ruchu! *");
		} else {
			System.out.println("Przegałem");
		}
	}
	
	static int guessNumber(int min, int max) {
		return ((max - min) / 2) + min;
		
	}
	
	static int pickNumber() {
		System.out.println("Pomyśl i podaj liczbe od 0 do 1000 ja ja zgadnę w max 10 próbach");
		Scanner scan = new Scanner(System.in);
		int pick = scan.nextInt();
		scan.close();
		return pick;
	}
	
	static boolean contains(int guess, int pick) {
		if(guess == pick) {
			return true;
		}
		return false;
	}
}
