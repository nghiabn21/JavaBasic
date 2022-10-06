package learn.threads;

import java.util.List;

import learn.entities.OnlineShop;
import learn.entities.Product;

public class Customer extends Thread {

	private List<Product> listOfProducts;
	private Product product;

	public Customer(List<Product> listOfProducts, Product product) {
		super();
		this.listOfProducts = listOfProducts;
		this.product = product;
	}

	@Override
	public void run() {
		OnlineShop onlineShop = new OnlineShop(listOfProducts, product);
		onlineShop.order();
	}

}