package learn.test;

import learn.sortingdemo.ArrayListSortingExample;
import learn.sortingdemo.ArraySortingExample;
import learn.sortingdemo.SortingComparableExample;
import learn.sortingdemo.SortingComparatorExample;

public class TestSortingDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArraySortingExample arraySort = new ArraySortingExample();
		ArrayListSortingExample arrayListSort = new ArrayListSortingExample();
		SortingComparableExample comparableSort = new SortingComparableExample();
		SortingComparatorExample comparatorSort = new SortingComparatorExample(); 
		
		arraySort.sortArray();
		arrayListSort.sortArrayList();
		comparableSort.sortElementWithComparable();
		comparatorSort.sortElementComparator();
	}
}
