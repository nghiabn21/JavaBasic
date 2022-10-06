package learn.model;

/**
 * @author hoabt2
 *
 */
public class Employee {

	private Integer id;
	private String name;
	private String city;

	/**
	 * @param id
	 * @param name
	 * @param city
	 */
	public Employee(Integer id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee{" + "name='" + name + '\'' + ", city='" + city + '\'' + '}';
	}

}
