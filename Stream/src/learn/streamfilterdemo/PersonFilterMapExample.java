package learn.streamfilterdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import learn.model.Person;

/**
 * Examples of how to use filter and map.
 *
 * @author hoabt2
 *
 */
public class PersonFilterMapExample {

	/**
	 * Streams filter() and map()
	 *
	 */
	public void filterAndMap() {

		System.out.println("filterAndMap() !!!");

		List<Person> personList = Arrays.asList(new Person("Peter", 30), new Person("Smith", 20),
				new Person("Mary", 40));
 
	//	String name1 = "Peter" ; 
		String name = personList.stream().filter(x -> "Peter".equals(x.getName())).map(Person::getName).findAny()
				.orElse("");

		System.out.println("Name : " + name);

		List<String> collect = personList.stream().map(Person::getName).collect(Collectors.toList()); // chuyển thành stream -> cho vào 1 khối lấy tên -> cho vào 1 bộ sưu tập

		collect.forEach(System.out::println); // như for each 
	}
}
