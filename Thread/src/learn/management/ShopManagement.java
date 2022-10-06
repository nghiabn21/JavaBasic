package learn.management;

import java.util.ArrayList;
import java.util.List;

import learn.entities.Product;
import learn.threads.Administrator;
import learn.threads.Customer;

public class ShopManagement {

	public static void main(String[] args) {
		List<Product> listOfProducts = new ArrayList<>();
		Product p1 = new Product("P001", "Laptop Dell 123", 3);
		Product p2 = new Product("P002", "Tivi LG 233", 5);
		Product p3 = new Product("P003", "Vina Milk 123", 2);

		listOfProducts.add(p1);
		listOfProducts.add(p2);

		Customer customer1 = new Customer(listOfProducts, p3);
		customer1.setName("[Customer 1]");
		Customer customer2 = new Customer(listOfProducts, p3);
		customer2.setName("[Customer 2]");

		Administrator administrator = new Administrator(listOfProducts, p3);

		customer1.setPriority(Thread.MAX_PRIORITY); 
		customer2.setPriority(Thread.MAX_PRIORITY);
		administrator.setPriority(Thread.MIN_PRIORITY);

		customer1.start();
		customer2.start();
		administrator.start();
	}

}