package lotto;

import java.util.Scanner;

public class Main3 {
	
	public static void main(String[] args) {
		
		System.out.println("Pomyśl i podaj liczbe od 0 do 1000 ja ja zgadnę w max 10 próbach");
		int min = 0;
		int max = 1001;
		int steps = 0;
		Scanner scan = new Scanner(System.in);
		boolean found = false;
		
		while(!found) {
			int guess = (int) ((max - min) / 2) + min;
			System.out.println("Zgaduję " + guess);
			String answer = scan.nextLine();
			
			switch(answer) {
			case "zgadles" :
				System.out.println("Wygrałem w " + steps + " próbie");
				steps++;
				found = true;
				break;
			case "za duzo" :
				System.out.println("Nie zgadłeś w ruchu " + steps);
				steps++;
				max = guess;
				break;
			case "za malo" :
				System.out.println("Nie zadłeś w ruchu " + steps);
				steps++;
				min = guess;
				break;
			default:
				System.out.println("Nie oszukuj!");
			}
		}
		scan.close();
	}

}
