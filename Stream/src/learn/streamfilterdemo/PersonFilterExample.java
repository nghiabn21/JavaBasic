package learn.streamfilterdemo;

import java.util.Arrays;
import java.util.List;

import learn.model.Person;

/**
 * Examples of how to use stream filter.
 *
 * @author hoabt2
 *
 */
public class PersonFilterExample {

	/**
	 * Find person by name (traditional way to iterate over a collection).
	 *
	 * @param personList the list of person
	 * @param name       the person name
	 * @return an instance of Person
	 */
	private static Person findPersonByName(List<Person> personList, String name) {
		Person result = null;
		for (Person person : personList) {
			if (name.equals(person.getName())) {
				result = person;
			}
		}
		return result;
	}

	/**
	 * Show person info
	 */
	public void showPerson() {
		System.out.println("Filter a collection using traditional method.");
		List<Person> personList = Arrays.asList(new Person("Peter", 30), new Person("Smith", 20),
				new Person("Mary", 40));

		Person result = findPersonByName(personList, "Peter");
		System.out.println(result);
	}

	/**
	 * Show person info using Stream Filter.
	 *
	 */
	public void showPersonWithStreamFilter() {
		System.out.println("showPersonWithStreamFilter.");

		List<Person> personList = Arrays.asList(new Person("Peter", 30), new Person("Smith", 20),
				new Person("Mary", 40));

		String name = "Peter";
		Person person1 = personList.stream() // Convert to steam
				.filter(x -> name.equals(x.getName())) // get "Peter" only
				.findAny() // If 'findAny' then return found  // theo ý hiểu thì nếu có thì trả về x
				.orElse(null); // If not found, return null    // k có thì trả về null

		System.out.println(person1);

		Person person2 = personList.stream().filter(x -> "Tom".equals(x.getName())).findAny().orElse(null);

		System.out.println(person2);
	}
}
