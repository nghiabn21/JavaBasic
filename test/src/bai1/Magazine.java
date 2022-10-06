package bai1;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Magazine extends Publication{ 
	private String author ; // tên tác giả của cuốn tập chí 
	private int volumn ;   
	private int edition ; 
	
	

	public Magazine(int publicationYear, String publisher, Date publicationDate) {
		super(publicationYear, publisher, publicationDate);
	} 
	 
	public Magazine() { 
		super() ;
	}

	@Override
	public void display() { 
		
		System.out.println(super.toString() + " Author: "+ author + " Volumn: " + volumn + " Edition: " +  edition + " ");
		
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getVolumn() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public Magazine(int publicationYear,String publisher, String publicationDate, String author, int volumn, int edition) {
		super(publicationYear, publisher);
		this.author = author;
		this.volumn = volumn;
		this.edition = edition;
	}
  
	public void nhap() throws ParseException { 
		Scanner sc = new Scanner(System.in);  
		super.nhap();
		System.out.println("Nhập Author: "); 
		author = sc.nextLine() ; 
	//	sc.nextLine();  
		System.out.println("Nhập Volume: "); 
		volumn = sc.nextInt() ; 
	//	sc.nextLine();  
		System.out.println("Nhập edition: "); 
		edition = sc.nextInt() ; 
	//	sc.nextLine(); 
	}

	
}
