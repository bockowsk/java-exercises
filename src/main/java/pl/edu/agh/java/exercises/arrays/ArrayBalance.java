package pl.edu.agh.java.exercises.arrays;

import static java.lang.System.out;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.management.ImmutableDescriptor;

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

		//testy
		ArrayList<ArrayList<Integer>> nowa=new ArrayList<ArrayList<Integer>>();
		arrayPermutation(array, 0, nowa);
		for (ArrayList<Integer> a: nowa) {
			System.out.println(Arrays.toString(a.toArray()));
		}
		//testy
		int left = 0;
		int right = 0;

		if (array.length % 2 == 0) {
			// calculate
			for (int i = 0; i < array.length; i++) {
				if (i < (array.length / 2)) {
					left += array[i];
				} else {
					right += array[i];
				}
			}
			//out.println("LEFT: " + left);
			//out.println("RIGHT: " + right);
			if (left == right) {
				return true;
			} else {
				return false;
			}
		} else {
			for (int i = 0; i < array.length; i++) {
				if (i < (array.length / 2)) {
					left += array[i];
				} else {
					if (i != (array.length / 2 + 1)) {
						right += array[i];
					}
				}
			}
			//out.println("LEFT: " + left);
			//out.println("RIGHT: " + right);
			if (left == right) {
				return true;
			} else {
				return false;
			}

		}
	}
	
	public void arrayPermutation(int[] array,int stop,ArrayList<ArrayList<Integer>> nowa) {
		if (stop==array.length-1) {
			for (int i: array) {
				//System.out.println(i+",");
			}
			//System.out.println();
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			for (int a: array) {
				arrayList.add(a);
			}
			nowa.add(arrayList);
		}
		else {
			for (int j=stop;j<array.length;j++) {
				int first=array[stop];
				int second=array[j];
				array[stop]=second;
				array[j]=first;
				arrayPermutation(array,stop+1,nowa);
				array[stop]=first;
				array[j]=second;
			}
		}
	}
}
