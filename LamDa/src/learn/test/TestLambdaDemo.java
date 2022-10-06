package learn.test;

import learn.lambdademo.FunctionalInterfaceExample;
import learn.lambdademo.SortingLambdaExample;

/**
 * @author hoabt2
 *
 */
public class TestLambdaDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortingLambdaExample sortLambda = new SortingLambdaExample();
		FunctionalInterfaceExample funcInterface = new FunctionalInterfaceExample(); 
		
		sortLambda.showUserInfoSortByName();
		sortLambda.showUserInfoSortBySalary();
		sortLambda.showUserInfoSortBySalaryReverse();
		funcInterface.calculateSquare();
	}
}