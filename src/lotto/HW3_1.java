package lotto;

import java.util.Scanner;

/*
 * Warsztat: Gra w zgadywanie liczb 2

Odwróćmy teraz sytuację z warsztatu "Gra w zgadywanie liczb": to użytkownik pomyśli sobie liczbę z zakresu 1-1000, a komputer będzie zgadywał i zrobi to maksymalnie w 10 ruchach (pod warunkiem, że gracz nie będzie oszukiwał).

Zadaniem gracza będzie udzielanie odpowiedzi "więcej", "mniej", "trafiłeś".

Do tego warsztatu dołączony jest schemat blokowy algorytmu. Zaimplementuj go w Javie. 
 */
public class HW3_1 {

	public static void main(String[] args) {
		int choosen = chooseNumber();
		int min = 0;
		int max = 1000;
		String result = "";
		int count = 1;
		while (!(result.equals("Wygrałem!")) && count < 11) {
			int guess = computerDraw(min, max);
			System.out.println("Zgaduję..." + guess);
			if(guess > choosen) {
				System.out.println("Operacja nr" + count);
				System.out.println("Za dużo!");
				max = guess;
				count++;
			} else if (guess < choosen) {
				System.out.println("Operacja nr" + count);
				System.out.println("Za mało!");
				min = guess;
				count++;
			} else if (guess == choosen) {
				result = "Wygrałem!";
				System.out.println("Operacja nr " + count);
				System.out.println(result);
			}
		}
	}
	
	static int chooseNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Wybierz liczbę którą będzie probował zgadnąć komputer...");
		int choosenInt = chkInt(scan);
		while(choosenInt < 0 || choosenInt > 1000) {
			System.out.println("Wybierz liczbe z zakresu 0 do 1000");
			choosenInt = chkInt(scan);
		}
		return choosenInt;
	}
	
	static int chkInt(Scanner scan) {
		int number = 0;
		while(!scan.hasNextInt()) {
			scan.next();
			System.out.println("Nieprawidłowe dane, wprawdź liczbę");
		}
		number = scan.nextInt();
		return number;
	}
	
	static int computerDraw(int min, int max) {
		return ((max - min) / 2) + min;
		
	}
}
