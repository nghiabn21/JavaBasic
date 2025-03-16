package learn.sortingdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Examples of how to sort an ArrayList.
 *
 * @author hoabt2
 *
 */
public class ArrayListSortingExample {

	/**
	 * Sort an ArrayList using Collections.sort()
	 *
	 */
	public void sortArrayList() {
		System.out.println("sortArrayList() !!!");

		List<String> fruits = new ArrayList<String>();

		fruits.add("Pineapple");
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Banana");

		Collections.sort(fruits); // theo bảng chữ cái

		int i = 0;
		for (String temp : fruits) {
			System.out.println("fruits " + ++i + " : " + temp);
		}
	}
}
