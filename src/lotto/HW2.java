package lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
 * Warsztat: Symulator LOTTO.

Jak wszystkim wiadomo, LOTTO to gra liczbowa polegająca na losowaniu 6 liczb z zakresu 1-49. 
Zadaniem gracza jest poprawne wytypowanie losowanych liczb. Nagradzane jest trafienie 3, 4, 5 lub 6 poprawnych liczb.

Napisz program, który:

    zapyta o typowane liczby, przy okazji sprawdzi następujące warunki:
        czy wprowadzony ciąg znaków jest poprawną liczbą,
        czy użytkownik nie wpisał tej liczby już poprzednio,
        czy liczba należy do zakresu 1-49,
    po wprowadzeniu 6 liczb, posortuje je rosnąco i wyświetli na ekranie,
    wylosuje 6 liczb z zakresu i wyświetli je na ekranie,
    poinformuje gracza, czy trafił przynajmniej "trójkę".

Aby wylosować 6 liczb z zakresu 1-49 bez powtórzeń możemy utworzyć tablicę z wartościami 1-49, wymieszać jej zawartość i pobrać pierwsze 6 elementów.

Poniższy kod powinien Ci pomóc:

Integer[] arr = new Integer[49];
for (int i = 0; i < arr.length; i++) {
	arr[i] = i;
}
System.out.println(Arrays.toString(arr));
Collections.shuffle(Arrays.asList(arr));
System.out.println(Arrays.toString(arr));

Możesz również losować liczby z określonego zakresu (sprawdź w snippetach jak to wykonać) - jeżeli wybierzesz takie rozwiązanie, 
pamiętaj o sprawdzaniu czy dana wartość nie została wcześniej wylosowana.
 */
public class HW2 {

	public static void main(String[] args) {
		int[] type = typeNumbers();
		System.out.println("Wylosowane przez Ciebie liczby to: " + Arrays.toString(type));
		int[] draw = drawNumbers();
		System.out.println("Maszyna wylosowała liczby: " + Arrays.toString(draw));
		checkScore(type, draw);
	}
	
	static int[] typeNumbers() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Wylosuj liczby z zakresu 1 - 49");
		int[] type = new int[6];
		int index = 0;
		while(index < 6) {
			System.out.println("Wylosuj liczbę na pozycji: " + (index + 1));
			int temp = chkNumber(scan);
			if(temp < 1 || temp > 49) {
				System.out.println("Liczba nie jest z przedziału 1 - 49");
			} else if (contains(temp, type)) {
				System.out.println("Wybrałeś już tą liczbę, wybierz inną");
			} else {
				type[index++] = temp;
			}
		}
		Arrays.sort(type);
		return type;
	}
	
	static int[] drawNumbers() {
		try {
			System.out.println("W komorze losującej znajduje się 49 liczb.");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Nastęþuje zwolnienie blokady");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Maszyna losująca rozpoczyna losowanie...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("3");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("2");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("1");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Wystąpiło zakłócenie!");
			e.printStackTrace();
		}
		int[] draw = new int[6];
		for(int i = 0; i < draw.length; i++) {
			draw[i] = new Random().nextInt(49) + 1;
		}
		Arrays.sort(draw);
		return draw;
	}
	
	static void checkScore(int[] choosen, int[] draw) {
		int counter = 0;
		for(int i : choosen) {
			if(contains(i, draw))
				counter++;
		}
		switch(counter) {
		case 3:
			System.out.println("Trafiłeś/aś trójkę!");
			break;
		case 4:
			System.out.println("Trafiłeś/aś czwórkę!");
			break;
		case 5:
			System.out.println("Trafiłeś/aś piątkę!");
			break;
		case 6:
			System.out.println("Trafiłeś/aś szóstkę, jestes milionerem/milionerką!");
			break;
		default:
			System.out.println("Nic nie trafiłeś/aś.");
		}
	}
	
	static int chkNumber(Scanner scan) {
		int number = 0;
		while(!scan.hasNextInt()) {
			scan.next();
			System.out.println("Nieprawidłowe dane, wprowadź wybrana liczbę");
		}
		number = scan.nextInt();
		return number;
	}
	
	static boolean contains(int pickNumber, int[] arrayNumber) {
		for(int c : arrayNumber) {
			if(c == pickNumber) {
				return true;
			}
		}
		return false;
	}
}
