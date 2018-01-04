package lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * W grach planszowych i papierowych RPG używa się wielu rodzajów kostek do gry, nie tylko tych dobrze znanych, sześciennych. Jedną z popularniejszych kości jest np. kostka dziesięciościenna, a nawet stuścienna! Jako że w grach kośćmi rzuca się często, pisanie za każdym razem np. "rzuć dwiema kostkami dziesięciościennymi, a do wyniku dodaj 20" byłoby nudne, trudne i marnowałoby ogromne ilości papieru. W takich sytuacjach używa się kodu "rzuć 2D10+20".

Kod takiej kostki wygląda następująco:
xDy+z

gdzie:

    y – rodzaj kostek, których należy użyć (np. D6, D10),
    x – liczba rzutów kośćmi; jeśli rzucamy raz, ten parametr jest pomijalny,
    z – liczba, którą należy dodać (lub odjąć) do wyniku rzutów (opcjonalnie).

Przykłady:

    2D10+10: 2 rzuty D10, do wyniku dodaj 10,
    D6: zwykły rzut kostką sześcienną,
    2D3: rzut dwiema kostkami trójściennymi,
    D12-1: rzut kością D12, od wyniku odejmij 1.

Napisz funkcję, która:

    przyjmie w parametrze taki kod w postaci String,
    rozpozna wszystkie dane wejściowe:
        rodzaj kostki,
        liczbę rzutów,
        modyfikator,
    wykona symulację rzutów i zwróci wynik.

Typy kostek występujące w grach: D3, D4, D6, D8, D10, D12, D20, D100.
 */
public class HW4 {

	public static void main(String[] args) {
		String[] cubes = { "2D10+10", "D6", "2D3", "D12-1", "5D8+2", "D12+1", "6D3+22" };
		sumCubeDraws(cubes);
	}

	static void sumCubeDraws(String[] cubes) {
		int[] cubesArray = new int[cubes.length];
		Pattern pattern = Pattern.compile("([1-9]{0,2})D(\\d+)([-+]?)(\\d{0,3})");
		for (int i = 0; i < cubes.length; i++) {
			// (\d*)D(\d+)([-+]*\d*)
			System.out.println("Wykonuję symulację dla: " + cubes[i]);
			String toRegex = cubes[i];
			Matcher matcher = pattern.matcher(toRegex);
			if (matcher.matches()) {
				int x = 0;
				if (matcher.group(1).equals("")) {
					x = 1;
				} else {
					x = Integer.parseInt(matcher.group(1));
				}

				int y = Integer.parseInt(matcher.group(2));
				String c = matcher.group(3);

				int z = 0;
				if (!matcher.group(4).equals("")) {
					z = Integer.parseInt(matcher.group(4));
				}

				for (int j = 0; j < x; j++) {
					int a = new Random().nextInt(y) + 1;
					cubesArray[i] += a;
				}

				if (c.equals("-")) {
					cubesArray[i] -= z;
				} else if (c.equals("+")) {
					cubesArray[i] += z;
				}
			}
		}
		System.out.println(Arrays.toString(cubesArray));
	}
}
