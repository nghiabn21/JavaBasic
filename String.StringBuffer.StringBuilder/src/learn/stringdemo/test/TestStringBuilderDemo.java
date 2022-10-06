package learn.stringdemo.test;

import learn.stringbufferdemo.StringBufferExample;
import learn.stringbuilderdemo.StringBuilderExample;

/**
 * @author hoabt2
 *
 */
public class TestStringBuilderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilderExample stringBuilder = new StringBuilderExample();
		StringBufferExample stringBuffer = new StringBufferExample();
		stringBuilder.demonstrateStringBuilder();
		stringBuffer.demonstrateStringBuffer();
	}

}
