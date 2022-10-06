package bai1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Publication { 
	private int publicationYear ; 
	private String publisher ; 
	private Date publicationDate ; 
	 
	public abstract void display();

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Publication(String publisher) {
		super();
		this.publisher = publisher;
	}

	public Publication(int publicationYear, String publisher, Date publicationDate) {
		super();
		this.publicationYear = publicationYear;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
	}

	public Publication() {
		super();
	} 
	 
	public void nhap() throws ParseException { 
		Scanner sc = new Scanner(System.in);
        System.out.print("Nhập publicationYear:"); 
        publicationYear = sc.nextInt(); 
        sc.nextLine(); 
        System.out.print("Nhập publisher:"); 
        publisher = sc.nextLine(); 
        sc.nextLine(); 
        System.out.print("Nhập publicationDate:");        
        String date = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");   
        publicationDate = dateFormat.parse(date);
	}

	@Override
	public String toString() {
		return " [publicationYear=" + publicationYear + ", publisher=" + publisher + ", publicationDate="
				+ publicationDate + "] ";
	}

	public Publication(int publicationYear, String publisher) {
		super();
		this.publicationYear = publicationYear;
		this.publisher = publisher;
	} 
	
	 
	
	 
	

}
