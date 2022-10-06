package learn.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Examples of how to iterate a HashSet
 *
 * @author hoabt2
 *
 */
public class HashSetIterationExample {

	/**
	 * Go through a HashSet using Iterator
	 *
	 */
	public void hashSetIterator() {

		System.out.println("hashSetIterator() !!!");

		Set<String> brands = new HashSet<>();

		brands.add("Wilson");
		brands.add("Nike");
		brands.add("Volvo");
		brands.add("Kia");
		brands.add("Lenovo");

		Iterator<String> it = brands.iterator();

		while (it.hasNext()) {
 
			String element = it.next();

			System.out.println(element);
		}

	}

}
