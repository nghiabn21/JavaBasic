package learn.sortingdemo;

import java.util.Arrays;
import java.util.Collections;

import learn.model.Fruit;

/**
 * Examples of how to sort object using Comparable
 *
 * @author hoabt2
 *
 */
public class SortingComparableExample {

	/**
	 * Sort data using Comparable
	 *
	 */
	public void sortElementWithComparable() {

		System.out.println("sortElementWithComparable() !!!");

		Fruit[] fruits = new Fruit[4];

		Fruit pineappale = new Fruit("Pineapple", "Pineapple description", 70);
		Fruit apple = new Fruit("Apple", "Apple description", 100);
		Fruit orange = new Fruit("Orange", "Orange description", 80);
		Fruit banana = new Fruit("Banana", "Banana description", 90);

		fruits[0] = pineappale;
		fruits[1] = apple;
		fruits[2] = orange;
		fruits[3] = banana;  
		
		Arrays.sort(fruits);

		int i = 0;
		for (Fruit temp : fruits) {
			System.out.println("fruits " + ++i + " : " + temp.getFruitName() + ", Quantity : " + temp.getQuantity());
		}
	}
}