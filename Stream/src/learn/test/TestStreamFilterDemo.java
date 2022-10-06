package learn.test;

import learn.streamfilterdemo.FilterMapByKeyExample;
import learn.streamfilterdemo.FilterMapByValueExample;
import learn.streamfilterdemo.PersonFilterExample;
import learn.streamfilterdemo.PersonFilterMapExample;
import learn.streamfilterdemo.PersonFilterMatchesExample;
import learn.streamfilterdemo.PersonFilterMultipleConditionExample;

/**
 * @author hoabt2
 *
 */
public class TestStreamFilterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PersonFilterExample personFilter = new PersonFilterExample();
		PersonFilterMultipleConditionExample filterMultipleCondition = new PersonFilterMultipleConditionExample();
		PersonFilterMapExample filterMap = new PersonFilterMapExample();
		PersonFilterMatchesExample filterMatched = new PersonFilterMatchesExample();
		FilterMapByKeyExample filterMapByKey = new FilterMapByKeyExample();
		FilterMapByValueExample filterMapByValue = new FilterMapByValueExample(); 
		
		personFilter.showPerson();
		personFilter.showPersonWithStreamFilter();
		filterMultipleCondition.filterMultipleCondition();
		filterMap.filterAndMap();
		filterMatched.filterWithMatchPattern();
		filterMapByKey.filterMapByKey();
		filterMapByValue.filterMapByValues();
	}
}
