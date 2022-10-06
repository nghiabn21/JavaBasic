package learn.hashmapdemo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Examples of how to obtain entrySet, keySet, values from HashMap
 *
 * @author hoabt2
 *
 */
public class HashMapObtainKeySetExample {

	/**
	 * Get entry set, key set and values from HashMap
	 *
	 */
	public void obtainEntryKeySetValues() {

		System.out.println("obtainEntryKeySetValues() !!!");

		Map<String, String> countryISOCodeMapping = new HashMap<>();

		countryISOCodeMapping.put("India", "IN");
		countryISOCodeMapping.put("United States of America", "US");
		countryISOCodeMapping.put("Russia", "RU");
		countryISOCodeMapping.put("Japan", "JP");
		countryISOCodeMapping.put("China", "CN");

		// HashMap's entry set
		Set<Map.Entry<String, String>> countryISOCodeEntries = countryISOCodeMapping.entrySet();
		System.out.println("countryISOCode entries : " + countryISOCodeEntries);

		// HashMap's key set
		Set<String> countries = countryISOCodeMapping.keySet(); // khóa
		System.out.println("countries : " + countries);

		// HashMap's values
		Collection<String> isoCodes = countryISOCodeMapping.values();
		System.out.println("isoCodes : " + isoCodes); // giá trị
	}
}
