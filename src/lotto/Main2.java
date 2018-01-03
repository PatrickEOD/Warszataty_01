package lotto;
//zrobić to samodzielnie
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/*
 * Jak wszystkim wiadomo, LOTTO to gra liczbowa polegająca na losowaniu 6 liczb z zakresu 1-49. 
 * Zadaniem gracza jest poprawne wytypowanie losowanych liczb. Nagradzane jest trafienie 3, 4, 5 lub 6 poprawnych liczb.

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

Możesz również losować liczby z określonego zakresu (sprawdź w snippetach jak to wykonać) - 
jeżeli wybierzesz takie rozwiązanie, pamiętaj o sprawdzaniu czy dana wartość nie została wcześniej wylosowana.
 */
public class Main2 {
	
	public static void main(String[] args ) {
//		System.out.println("Twoje wytypowane liczby: " + Arrays.toString(choosenNumbers()));
//		System.out.println("Rozpoczynam losowanie");
//		draw();
		
		System.out.println("Podaj liczby");
		int[] numbers = getNumbers();
		System.out.println("Podane liczby");
		System.out.println(Arrays.toString(numbers));
		
		int[] generated = generateNumbers();
		System.out.println("Wylosowanie liczby: ");
		System.out.println(Arrays.toString(generated));
		
		checkScore(generated, numbers);
		
	}
	
//	static Integer[] draw() {
//		Integer[] arr = new Integer[49];
//		for(int i = 1; i <= arr.length; i++) {
//			arr[i] = i;
//		}
//		System.out.println("Arrays.toString(arr)");
//		Collections.shuffle(Arrays.asList(arr));
//		System.out.println("Arrays.toString(arr)");
//		return arr;
//	}
	
//	static int[] choosenNumbers() {
//		Scanner scan = new Scanner(System.in);
//		int[] types = new int[6];
//		for (int i = 1; i <= types.length; i++) {
//			System.out.println("Wprowadź wytypowaną liczbę");
//			types[i] = getNumber(scan);
//		}
//		Arrays.sort(types);
//		scan.close();
//		return types;
//	}
	
	static void checkScore(int[] generated, int[] choosen) {
		int counter = 0;
		for(int elem : generated) {
			if (contains(choosen, elem)) {
				counter++;
			}
		}
		switch(counter) {
		case 3:
			System.out.println("Trafieś 3");
			break;
		case 4:
			System.out.println("Trafiłeś 4");
			break;
		case 5: 
			System.out.println("Trafiłes 5");
			break;
		case 6:
			System.out.println("Trafiłeś 6");
			break;
		default:
			System.out.println("Nic nie trafieś");
		}
	}
	static int[] generateNumbers() {
		Random random = new Random();
		int[] numbers = new int[6];
		int index = 0;
		while(index < 6 ) {
			int num = random.nextInt(49)+1;
			if(!contains(numbers, num)) {
				numbers[index++] = num;
			}
		}
		Arrays.sort(numbers);
		return numbers;
	}
	static int[] getNumbers() {
		Scanner scan = new Scanner(System.in);
		int[] numbers = new int[6];
		int index = 0;
		while(index < 6) {
			System.out.println("Podaj liczbe na pozycji " + (index + 1));
			int num = getNumber(scan);
			if(num < 1 || num > 49) {
				System.out.println("Liczba nie jest z przedziału 1 do 49!");
			} else if (contains(numbers, num)) {
				System.out.println("liczba została juz podana!");
			} else {
				numbers[index++] = num;
			}
		}
		Arrays.sort(numbers);
		return numbers;
	}

	static int getNumber(Scanner scan) {
		while(!scan.hasNextInt()) {
			scan.next();
			System.out.println("Nieprawidłowy typ, wprowadź liczbę!");
		}
		int num = scan.nextInt();
//		while(num < 0 && num > 49 ) {
//			scan.nextLine();
//			System.out.println("Wprowadź liczbe z zakresu 1 do 49");
//		}
//		num = scan.nextInt();
		return num;
	}
	
	static boolean contains(int[] tab, int value) {
		for(int elem : tab) {
			if(elem == value) {
				return true;
			}
		}
		return false;
	}

}
