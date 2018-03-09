package pl.edu.agh.java.exercises.arrays;

/**
 * Consider the leftmost and righmost appearances of some value in an array.
 * We'll say that the "span" is the number of elements between the two
 * inclusive. A single value has a span of 1. Returns the largest span found in
 * the given array. (Efficiency is not a priority.)
 * 
 * Przyjmijmy, że odstęp "span" danej wartości w tablicy to liczba elementów
 * pomiędzy pierwszym i ostatniem jej wystąpieniem, włączając je same. Jeśli
 * wartość pojawia się w tablicy tylko raz, jej "span" jest równe 1. Metoda
 * maxSpan powinna zwracać największy istniejący odstęp w zadanej tablicy.
 * 
 * @see http://codingbat.com/prob/p189576
 */
public class ArraySpan {
	public int maxSpan(int[] array) {
		// globalnie dla metody, najwyzszy wynik
		int maxSpan = 0;
		// lecimy dla kazdego elementu (w sumie moze sie powtarzac)
		for (int i = 0; i < array.length; i++) {
			// temp variables dla sledzenia
			boolean exists1 = false;
			boolean exists2 = false;
			// indeksy
			int start = 0;
			int stop = 0;
			// troche redundantie, ze tu sprawdzamy, start przeciez wiadomy
			// ale to dlatego, ze zle zrozumialem zadanie na poczatku
			for (int index = 0; index < array.length; index++) {
				if (array[index] == array[i]) {
					exists1 = true;
					start = index;
					break;
				}
			}
			// sprawdzanie czy istnieje od konca
			if (exists1 && start != array.length - 1) {
				for (int index = array.length - 1; index > start + 1; index--) {
					if (array[index] == array[i]) {
						exists2 = true;
						stop = index;
						break;
					}
				}
			}
			// logika na update'owanie najlepszego wyniku = max span
			if (exists1 && exists2) {
				int span = stop - start + 1;
				if (span > maxSpan)
					maxSpan = span;
			} else if (exists1) {
				if (1 > maxSpan)
					maxSpan = 1;
			} else {
				;
			}
		}
		return maxSpan;

	}
}
