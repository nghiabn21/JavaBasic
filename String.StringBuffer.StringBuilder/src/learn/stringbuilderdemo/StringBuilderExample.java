package learn.stringbuilderdemo;

/**
 * Examples of StringBuilder
 *
 * @author hoabt2
 *
 */
public class StringBuilderExample {

	/**
	 * Demonstrate how to use StringBuilder
	 *
	 */
	public void demonstrateStringBuilder() {
		System.out.println("demonstrateStringBuilder() !!!"); 
		
		StringBuilder sb1 = new StringBuilder("Hello Java World");
		sb1.delete(4, 8); // xóa từ 4 - 7 vì end  - 1 
		System.out.println("Delete method demo: " + sb1); 
		
		StringBuilder sb2 = new StringBuilder("Hello Java World");
		sb2.insert(4, "abc"); // bắt đầu từ 1
		System.out.println("Inser Operation: " + sb2); 
		
		StringBuilder sb3 = new StringBuilder("fsoft.fpt.com");
		sb3.replace(1, 4, "Amit"); // thay thế từ 1 - 3 vì end - 1
		System.out.println("Replace Operation: " + sb3); 
		
		StringBuilder sb4 = new StringBuilder("ABCDE");
		System.out.println("Reverse of ABCDE: " + sb4.reverse()); // sắp xếp ngc lại 
		
		StringBuilder sb5 = new StringBuilder("ABCDEF");
		sb5.setCharAt(3, 'x');
		System.out.println("Replacing char at index 3: " + sb5);
	}

}
