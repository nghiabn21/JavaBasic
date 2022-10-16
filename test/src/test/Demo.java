package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate localDate1 = LocalDate.parse("01/02/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(localDate1); // 2020-05-12

	}

}
