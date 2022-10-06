package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		String s ; 
		try {  
			FileReader r = new FileReader("myfile.txt"); 
			BufferedReader b = new BufferedReader(r); 
			while((s = b.readLine()) != null) { 
				System.out.println(s);
			}
			
		}catch (IOException e) {
			// TODO: handle exception 
			System.out.println("ok1");
		}

	}

}
