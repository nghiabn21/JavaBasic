package learn.streamfilterdemo;

import java.util.HashMap;
import java.util.Map;

/**
 * Examples of how to use filter map by values.
 *
 * @author hoabt2
 *
 */
public class FilterMapByValueExample {

	/**
	 * Filter map by values.
	 *
	 */
	public void filterMapByValues() {
		System.out.println("filterMapByValues() !!!");

		Map<String, String> mapCountries = new HashMap<>();

		mapCountries.put("de", "Germany");
		mapCountries.put("hu", "Hungary");
		mapCountries.put("sk", "Slovakia");
		mapCountries.put("si", "Slovenia");
		mapCountries.put("so", "Somalia");
		mapCountries.put("us", "United States");
		mapCountries.put("ru", "Russia");

		mapCountries.entrySet().stream()
				.filter(map -> map.getValue().equals("Slovakia") || map.getValue().equals("Slovenia"))
				.forEach(m -> System.out.println(m));
	}
}
