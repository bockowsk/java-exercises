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
		int maxSpan=0;
		for (int i = 0; i < array.length; i++) {
			int start = 0;
			int stop = 0;
			for (int index = 0; index < array.length; index++) {
				if (array[index] == array[i]) {
					start = index;
					break;
				}
			}
			if (start != 0 && start != array.length - 1) {
				for (int index = array.length - 1; index > start + 1; index--) {
					if (array[index] == array[i]) {
						stop = index;
						break;
					}
				}
			}
			if (start != 0 && stop != 0) {
				int span=stop - start + 1;
				if (span>maxSpan) maxSpan=span;
			} else if (start != 0) {
				if (1>=maxSpan) maxSpan=1;
			} else {
				;
			}
		}
		return maxSpan;

	}
}
