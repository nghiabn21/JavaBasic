package learn.sortingdemo;

import java.util.Arrays;

/**
 * Examples of how to sort an array.
 *
 * @author hoabt2
 *
 */
public class ArraySortingExample {

	/**
	 * Sort an array using Arrays.sort()
	 *
	 */
	public void sortArray() {

		System.out.println("sortArray() !!!");

		String[] fruits = new String[] { "Pineapple", "Apple", "Orange", "Banana" };

		Arrays.sort(fruits); // theo bảng chữ cái 

		int i = 0;
		for (String temp : fruits) {
			System.out.println("fruits " + ++i + " : " + temp);
		}
	}
}
