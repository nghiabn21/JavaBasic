package learn.stringdemo.demo;

/**
 * Demonstrate to count number of words in a String.
 *
 * @author hoabt2
 *
 */
public class StringCountNumberOfWord {

	public void demonstrateCountWord() {
		System.out.println("demonstrateCountWord() !!!");

		countNumberOfWords("My name is Admin");
		countNumberOfWords("I love Java Programming");
		countNumberOfWords("This is not properly formatted data");
	}

	/**
	 * Count number of words in a String.
	 *
	 * @param str the input String
	 */
	private static void countNumberOfWords(String str) {
		String trimmedLine = str.trim(); //bỏ khoảng trắng 2 đầu 
		int count = trimmedLine.isEmpty() ? 0 : trimmedLine.split("\\s+").length; // split tách chuỗi dựa trên \\s+
		System.out.println(count);
	}

}
