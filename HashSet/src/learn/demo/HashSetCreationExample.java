package learn.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * Examples of creating a HashSet
 *
 * @author hoabt2
 * 
 */
public class HashSetCreationExample {

	/**
	 * Create a HashSet
	 *
	 */
	public void createHashSet() {

		System.out.println("createHashSet() !!!");

		Set<String> brands = new HashSet<>();

		brands.add("Wilson");
		brands.add("Nike");
		brands.add("Volvo");
		brands.add("IBM");
		brands.add("IBM");

		int nOfElements = brands.size();

		System.out.format("The set contains %d elements%n", nOfElements);
		System.out.println(brands);
	}
}