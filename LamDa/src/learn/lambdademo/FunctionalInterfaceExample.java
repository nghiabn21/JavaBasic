package learn.lambdademo;

/**
 * Examples of how to use functional interface
 *
 * @author hoabt2
 *
 */
public class FunctionalInterfaceExample {

	/**
	*
	*/
	public void calculateSquare() {
		System.out.println("Calculate Square, Functional Interface !!!");
		int a = 10;
		// lambda expression to define the calculate method
		Square s = (int x) -> x * x;

		// parameter passed and return type must be
		// same as defined in the prototype
		int result = s.calculate(a);
		System.out.println(result);
	}
}

// define a functional interface
@FunctionalInterface
interface Square {
	int calculate(int x);
}
