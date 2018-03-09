package pl.edu.agh.java.exercises.strings;

import static java.lang.System.out;

/**
 * Given a string, return the longest substring that appears at both the
 * beginning and end of the string without overlapping. For example,
 * sameEnds("abXab") is "ab".
 * <p>
 * Dla danego ciągu znaków zwróć najdłuższy podciąg, który występuje na początku
 * i na końcu, bez nachodzenia na siebie. Przykłądowo, sameEnds("abXab") to
 * "ab".
 *
 * @see http://codingbat.com/prob/p131516
 */
public class StringSameEnds {
	public String sameEnds(String string) {
		// juz mi mozg siadl, bo ostatnie zadanie wiec debug :)
		byte debug=0;
		if (debug ==1) out.println("caly string: " + string);
		String theLongest = "";
		// lecimy po wszystkich literach
		for (int i = 0; i < string.length(); i++) {
			// zaczynamy tworzyc substring
			String substring = Character.toString(string.charAt(i));
			if (debug ==1)  out.println("iteracja po wszystkim, pierwsza literka: " + substring);
			// jesli istnieje,
			int k = i + 1;
			while (substring.length() <= (string.length() / 2) && string.indexOf(substring, k) != -1) {
				if (debug ==1)  out.println("wygenerowany substring: " + substring);
				if (substring.length() > theLongest.length()) {
					theLongest = substring;
				}
				String letter = Character.toString(string.charAt(k));
				substring += letter;
				if (debug ==1)  out.println("wygenerowany substring: " + substring);
				k++;
			}
		}
		return theLongest;
	}
}
