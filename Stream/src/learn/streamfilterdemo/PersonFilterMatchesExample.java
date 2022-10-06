package learn.streamfilterdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import learn.model.Person;

/**
 * Examples of how to use filter with matched patterns
 *
 * @author hoabt2
 *
 */
public class PersonFilterMatchesExample {

	/**
	 * Filter with matched patterns.
	 *
	 */
	public void filterWithMatchPattern() {
		System.out.println("filterWithMatchPattern() !!!");

		List<Person> personList = new ArrayList<>();
		Person person1 = new Person("Peter", 25, "peter13@gmail.com");
		Person person2 = new Person("Paul", 30, "paul1987@gmail.com");
		Person person3 = new Person("Tom", 70, "tom1234@gmail.com");
		Person person4 = new Person("Lion", 45, "lioncrone@gmail.com");
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);
   // chuyển thành stream -> cho vòng for lấy email rồi xác thực xem có đúng định dạng k rồi cho vào 1 collection
		List<Person> result = personList.stream().filter(person -> person.getEmail().matches(".*gmail\\.com"))
				.collect(Collectors.toList());

		result.forEach(p -> System.out.println(p.getName())); // vòng lặp for each in ra màn hình tên  
//		for(Person p : result) { 
//			System.out.println(p.getName());
//		}
	}
}