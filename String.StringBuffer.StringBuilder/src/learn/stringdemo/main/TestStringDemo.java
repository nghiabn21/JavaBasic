package learn.stringdemo.main;

import learn.stringdemo.demo.StringCountNumberOfWord;
import learn.stringdemo.demo.StringImmutableExample;
import learn.stringdemo.demo.StringMethodExample;

public class TestStringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		 StringImmutableExample stringImmutable = new StringImmutableExample(); 
		 
		 StringMethodExample stringMethod = new StringMethodExample(); 
		 
		 StringCountNumberOfWord countWord = new StringCountNumberOfWord(); 
		 
		 stringImmutable.demonstrateStringImmutable(); 
		 
		 stringMethod.demonstrateStringMethod(); 
		 
		 countWord.demonstrateCountWord();
		 }

	}


