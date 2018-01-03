package lotto;

import java.util.Random;
import java.util.Scanner;

/*
 * Warsztat: Gra w zgadywanie liczb.

Napisz prostą grę w zgadywanie liczb. Komputer musi wylosować liczbę w zakresie od 1 do 100. Następnie:

    Zadać pytanie: "Zgadnij liczbę" i pobrać liczbę z klawiatury.
    Sprawdzić, czy wprowadzony napis, to rzeczywiście liczba i w razie błędu wyświetlić komunikat "To nie jest liczba", po czym wrócić do pkt. 1
    Jeśli liczba podana przez użytkownika jest mniejsza niż wylosowana, wyświetlić komunikat "Za mało!", po czym wrócić do pkt. 1.
    Jeśli liczba podana przez użytkownika jest większa niż wylosowana, wyświetlić komunikat "Za dużo!", po czym wrócić do pkt. 1.
    Jeśli liczba podana przez użytkownika jest równa wylosowanej, wyświetlić komunikat "Zgadłeś!", po czym zakończyć działanie programu.

Przykład:

Zgadnij liczbę: cześć
To nie jest liczba.
Zgadnij liczbę: 50
Za mało!
Zgadnij liczbę: 75
Za dużo!
Zgadnij liczbę: 63
Zgadłeś!

 */
public class HW1 {

	public static void main(String[] args) {
		drawNumber();
	}
	
	static void drawNumber() {
		int targetNumber = new Random().nextInt(100 - 1) + 1;
		System.out.println("Komputer wylosował liczbę " + targetNumber);
		Scanner scan = new Scanner(System.in);
		System.out.println("Zgadnij liczbę: ");
		int pickNumber =  0;
		while(pickNumber != targetNumber) {
			pickNumber = chkInt(scan);
			if(pickNumber > targetNumber) {
				System.out.println("Za dużo");
			} else if (pickNumber < targetNumber) {
				System.out.println("Za mało");
			} else {
				System.out.println("Zgadłeś!");
				break;
			}
		}
		scan.close();
	}
	
	static int chkInt(Scanner scan) {
		int result = 0;
		while(!scan.hasNextInt()) {
			scan.next();
			System.out.println("To nie liczba!");
		}
		result = scan.nextInt();
		while(result <= 0) {
			System.out.println("Wybierz liczbę z zakresu 1 do 100");
			result = scan.nextInt();
		}
		return result;
	}
}
