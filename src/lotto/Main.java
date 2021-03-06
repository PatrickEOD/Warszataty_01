package lotto;

import java.util.Random;
import java.util.Scanner;

/*
 * Napisz prostą grę w zgadywanie liczb. Komputer musi wylosować liczbę w zakresie od 1 do 100. Następnie:

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
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = new Random().nextInt(100) + 1;
		System.out.println("Zgadnij liczbę");
		int num = 0;
		while (num != number) {
			num = getNumber(scan);
			if (num < number) {
				System.out.println("Za mało!");
			} else if (num > number) {
				System.out.println("Za dużo!");
			} else {
				System.out.println("Zgadłeś");
			}
		}
		scan.close();
	}

	static int getNumber(Scanner scan) {
		
		while (!scan.hasNextInt()) {
			scan.nextLine(); // samo next zdejmie tylke znaki do spacji
			System.out.println("To nie jest liczba");
		}
		int num = scan.nextInt();
		return num;
	}
}
