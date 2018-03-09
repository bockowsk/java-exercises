package pl.edu.agh.java.exercises.arrays;

import java.util.ArrayList;

/**
 * Given an array, return true if there is a place to split the array so that
 * the sum of the numbers on one side is equal to the sum of the numbers on the
 * other side.
 * 
 * Dla zadanej tablicy zwróć true, jeśli da się tak rozmieścić jej elementy, że
 * suma jej elementów w lewej i w prawej połowie będzie równa.
 * 
 * @see http://codingbat.com/prob/p158767
 */
public class ArrayBalance {
	public boolean canBalance(int[] array) {
		boolean canBalance = false;
		// dla pustych lub 1 elementowych zwraca true - mozna by to ladniej zrobic
		System.out.print("SisLeftAndRightEqual, size: " + array.length + "\n");
		if (array.length <= 1) {
			return true;
		}
		ArrayList<ArrayList<Integer>> nowa = new ArrayList<ArrayList<Integer>>();
		findAllCombinations(array, 0, nowa);
		for (ArrayList<Integer> a : nowa) {
			canBalance = isLeftAndRightEqual(a);
			// jak juz znajdzie, to nie robi dalej
			if (canBalance == true)
				break;
		}
		return canBalance;
	}

	// wykorzystuje permutacje, chodz kombinacja tez by przeszla
	void findAllCombinations(int[] array, int stop, ArrayList<ArrayList<Integer>> nowa) {
		if (stop == array.length - 1) {
			// test purpose
			/*
			 * for (int i : array) { System.out.println(i+","); } System.out.println();
			 */ ArrayList<Integer> arrayList = new ArrayList<Integer>();
			for (int a : array) {
				arrayList.add(a);
			}
			nowa.add(arrayList);
		} else {
			for (int j = stop; j < array.length; j++) {
				int first = array[stop];
				int second = array[j];
				array[stop] = second;
				array[j] = first;
				// kluczowe - rekurecja
				findAllCombinations(array, stop + 1, nowa);
				array[stop] = first;
				array[j] = second;
			}
		}
	}

	// dekompozycja metody canBalance, zeby nie bylo spaghetti
	boolean isLeftAndRightEqual(ArrayList<Integer> array) {
		int left = 0;
		int right = 0;

		if (array.size() % 2 == 0) {
			// calculate
			for (int i = 0; i < array.size(); i++) {
				if (i < (array.size() / 2)) {
					left += array.get(i);
				} else {
					right += array.get(i);
				}
			}
			// out.println("LEFT: " + left);
			// out.println("RIGHT: " + right);
			if (left == right) {
				return true;
			} else {
				return false;
			}
		} else {
			for (int i = 0; i < array.size(); i++) {
				if (i < (array.size() / 2)) {
					left += array.get(i);
				} else {
					if (i != (array.size() / 2 + 1)) {
						right += array.get(i);
					}
				}
			}
			// out.println("LEFT: " + left);
			// out.println("RIGHT: " + right);
			if (left == right) {
				return true;
			} else {
				return false;
			}

		}

	}
}
