package learn.entities;

import java.util.List;

public class OnlineShop {
	private List<Product> listOfProducts;
	private Product product;

	public OnlineShop(List<Product> listOfProducts, Product product) {
		super();
		this.listOfProducts = listOfProducts;
		this.product = product;
	}

	public void order() {
		System.out.println(Thread.currentThread().getName() + " start order");
		synchronized (listOfProducts) {
			if (!listOfProducts.contains(product)) {
				try {
					System.out.println(product.getProductName() + " not exists!");
					System.out.println("List wait!");
					listOfProducts.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(product.getProductName() + " added!");
			}
		}

		/*
		 * Customer lock a select product
		 */
		synchronized (product) {
			System.out.println(Thread.currentThread().getName() + "ordering ");
			int index = 0, amount = 2;
			Product orderProduct = null;
			for (int i = 0; i < listOfProducts.size(); i++) {
				orderProduct = listOfProducts.get(i);
				if (orderProduct.equals(product)) {
					if (orderProduct.getQuantity() >= amount) {
						index = i;
						orderProduct.setQuantity(orderProduct.getQuantity() - amount);
						System.out.println(Thread.currentThread().getName() + " ordered");
						break;
					} else {
						System.out.println(Thread.currentThread().getName() + "- not enough");
					}
				}
			}
			listOfProducts.set(index, orderProduct);
		}
		for (Product product : listOfProducts) {
			System.out.println(product);
		}
	}

	/**
	 * Add a new product
	 */
	public void add() {
		System.out.println("[Admin] start work ");
		synchronized (listOfProducts) {
			System.out.println("[Admin] adding a new product");
			listOfProducts.add(product);
			listOfProducts.notifyAll();
		}
		System.out.println("[Admin] do other work");
	}

}