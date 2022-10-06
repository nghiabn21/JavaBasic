package bai1;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LibraryManagement {
	ArrayList<Book> listBook = new ArrayList<>(); 
	ArrayList<Magazine> listMaga = new ArrayList<>(); 

	public void main() throws ParseException { 
		Magazine m1 = new Magazine(2021, "Huyen","01/02/2021", "Huyen", 2, 2); 
		Magazine m2 = new Magazine(2021, "Huyen","01/02/2021", "Huyen", 3, 3); 
		Magazine m3 = new Magazine(2021, "Huyen","01/02/2021", "Huyen", 4, 4); 
		Magazine m4 = new Magazine(2021, "Huyen","01/02/2021", "Huyen", 5, 5); 
		Magazine m5 = new Magazine(2021, "Huyen","01/02/2021", "Huyen", 6, 6); 
		Magazine m6 = new Magazine(2021, "Huyen","01/02/2021", "Huyen", 7, 7); 
		listMaga.add(m1); 
		listMaga.add(m2); 
		listMaga.add(m3); 
		listMaga.add(m4); 
		listMaga.add(m5); 
		listMaga.add(m6);
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Menu");
			System.out.println("====== LIBRARY MANAGEMENT SYSTEM =====");
			System.out.println("1. Add a book");
			System.out.println("2. Add a magazine");
			System.out.println("3. Display books and magazines");
			System.out.println("4. Add author to book");
			System.out.println("5. Display top 10 of magazines by volume");
			System.out.println("6. Search book by(isbn, author, publisher)");
			System.out.println("Please choose function you'd like to do:");
			int sc1 = sc.nextInt();
			switch (sc1) {
			case 1:
				Book b = new Book();
				b.nhap();
				listBook.add(b);
				break;
			case 2:
				Magazine m = new Magazine();
				m.nhap();
				listMaga.add(m); 
				break;
			case 3:
                xuatThongTin() ;
				break;
			case 4:
              addAuthorToBook();
				break;
			case 5:
                 topTen();
				break;
			case 6:
                 searchByIsBn();
				break;
			default: 
				System.out.println("Lỗi!!!");
				break;
			}

		} while (true);

	} 
	 

	private void xuatThongTin() { 
		System.out.println("Books and Magazines"); 
		for(Book b : listBook) { 
			b.display();
		} 
		for(Magazine b : listMaga) { 
			b.display();
		}
	   
	} 
	 
	public void topTen() { 
		Collections.sort(listMaga, new Comparator<Magazine>() {
			@Override
			public int compare(Magazine o1, Magazine o2) {
				
				return (o1.getVolumn() - o2.getVolumn()); //sắp xếp theo thứ tự tăng dần
			}
		});  
		for(int i = 0; i< 3; i++) { 
			listMaga.get(listMaga.size() -  i - 1).display();
		}
		
	} 
	 
	public void searchByIsBn() { 
		Scanner sc = new Scanner(System.in);  
		System.out.println("Nhập (IsBn, Publisher, Author) cần tìm: ");
	    String  is = sc.nextLine();  
		Book b = null ; 
		for(Book k : listBook) {  
			if(k.getIsbn().equals(is)|| k.getPublisher().equals(is) || k.getAuthor().contains(is)  ) {  
//				|| k.getPublisher().equals(is) || k.getAuthor().contains(is)
				b = k ;  
				break ;
		} 	
	} 
		if( b != null) { 
			b.display();
		}else { 
			System.out.println("Không tìm thấy sách");
		}	
	}
	 
	public void addAuthorToBook() {  
		Scanner sc = new Scanner(System.in);   
		System.out.println("Nhập isbn: "); 
		String is = sc.nextLine() ;  
		for(Book k : listBook) { 
			if(k.getIsbn().equals(is)) { 
				System.out.println("Nhập tên tác giả: "); 
				String au = sc.nextLine(); 	
				if(k.getIsbn().equals(is) && k.getAuthor().contains(null)){  
					k.getAuthor().remove(null);
					k.getAuthor().add(au);  
					System.out.println("Add successfully");
				}else { 
					System.out.println("Add do not successfully");
				}
			}
		}
		
	} 

}
