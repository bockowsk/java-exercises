package pl.edu.agh.java.exercises.arrays;

/**
 * Given n>=0, create an array length n*n with the following pattern, shown here
 * and in the unit tests: for n=3 : {0, 0, 1, 0, 2, 1, 3, 2, 1}
 * 
 * Dla zadanego n>=0 zwróć tablicę o długości n*n utworzoną wg wzoru podanego
 * tutaj oraz w testach jednostkowych: dla n=3: {0, 0, 1, 0, 2, 1, 3, 2, 1}
 * 
 *
 * @see http://codingbat.com/prob/p155405
 */
public class ArraySquareUp {
	public int[] squareUp(int n) {
		int[] array = new int[n * n];
		for (int i = 1; i <= n; i++) {
			for (int j = n * i - 1, k = 1; j > n * (i - 1) - 1; j--) {
				if (k > i) {
					array[j] = 0;
				} else {
					array[j] = k;
				}
				k++;
			}
		}
		// throw new UnsupportedOperationException();
		for (int i : array) {
			System.out.print("element: " + i + ", ");
		}
		System.out.println("stop");
		return array;
	}
}

/*
 * NOTKI: logika dla 3, mamy od 0 do 2 (3 * 1 -1 ) , 3 do 5 (3 * 2 -1) i 6 - 8
 * (3 * 3 -1) dla pierwszego mamy od tylu n i co krok n-1 (jak ujemny to 0) dla
 * drugiego mamy od tylu n i co krok n-1 (jak ujemny to 0) dla trzeciego mamy od
 * tylu n i co krok n-1 (jak ujemny to 0)
 * 
 * 
 */
