package lotto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * 
    Zaimportuj do projektu bibliotekę jsoup, możesz ją pobrać z adresu: https://jsoup.org/download.
    Wyszukaj w popularnych serwisach internetowych nagłówków artykułów, a następnie zapisz pojedyncze słowa 
    w nich występujące do pliku o nazwie popular_words.txt. Przykład pobrania tytułów z tagu html span z atrybutem class o wartości title

Connection connect = Jsoup.connect("http://www.onet.pl/");
try {
    Document document = connect.get();
    Elements links = document.select("span.title");
    for (Element elem : links) {
        System.out.println(elem.text());
    }
} catch (IOException e) {
    e.printStackTrace();
}

    Wywołaj pobieranie dla wybranych serwisów internetowych.
    Wczytaj utworzony plik popular_words.txt i na jego podstawie utwórz plik most_popular_words.txt, który zawierać będzie 10 najbardziej popularnych słów.
    Utwórz tablicę elementów wykluczonych np. i, lub , ewentualnie pomiń wszystkie elementy 3-znakowe.

 */
public class HW5 {

	public static void main(String[] args) {
		String storedWebsites = storeWebSites();
		storePopularWords(storedWebsites);
	}

	static String storeWebSites() {
		String fileName = "websites.txt";
		Path path = Paths.get(fileName);
		if (Files.exists(path)) {
			System.out.println("Plik już istnieje!");
			return fileName;
		}

		try (Scanner scan = new Scanner(System.in); FileWriter file = new FileWriter(fileName, true)) {
			System.out.println("Podaj link do portalu...");

			while (scan.hasNextLine()) {
				String website = scan.next();
				System.out.println("Podaj kolejny link...");
				if (website.equals("quit")) {
					System.out.println("Kończę wpisywanie!");
					break;
				} else {
					file.append(website).append("\n");
				}
			}
		} catch (IOException e) {
			System.out.println("Błąd zapisywania do pliku!");
			e.printStackTrace();
		}
		return fileName;
	}

	static String storePopularWords(String websitesFile) {
		String popularFile = "popular_words.txt";
		File file = new File(websitesFile);
		try (FileWriter popular = new FileWriter(popularFile, true); Scanner scan = new Scanner(file)) {

			ArrayList<String> storedWebsites = new ArrayList<>();
			while (scan.hasNextLine()) {
				storedWebsites.add(scan.nextLine());
				storedWebsites.add("\n");
			}

			// for(String website : storedWebsites) {
			// String website = "https://wp.pl";
			// System.out.println("Sprawdzenie: " + website);
			Connection connect = Jsoup.connect("https://www.onet.pl");
			System.out.println("połączono");
			Document document = connect.get();
			System.out.println("wykonano get");
			Elements links = document.select("span.title");
			System.out.println(links.text());
			for (Element elem : links) {
				System.out.println("Zapisuje słowa...");
				System.out.println((elem.text()));
				String sentence = elem.text();
				StringTokenizer sentToken = new StringTokenizer(sentence, "\n,.:\" #$%^&*()_+-][!?/");
				while (sentToken.hasMoreTokens()) {
					String token = sentToken.nextToken().toLowerCase();
					if (token.length() <= 3) {

					} else {
						popular.append(token);
						popular.append("\n");
					}
				}
				// String[] singleWord = elem.text().split(" ");
				// for (String s : singleWord) {
				// popular.append(s);
				// popular.append("\n");
				// }
				// popular.append(elem.text());
				// popular.append("\n");
			}
			// }
		} catch (FileNotFoundException e) {
			System.out.println("Nie odnaleziono pliku " + websitesFile);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Błąd wczytywania");
			e.printStackTrace();
		}
		return popularFile;
	}
}
