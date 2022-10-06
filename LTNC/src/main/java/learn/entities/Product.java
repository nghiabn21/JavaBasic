package learn.entities;

public class Product { 
	private int productID, listPrice ; 
	private String productName ;
	public Product(int productID, int listPrice, String productName) {
		super();
		this.productID = productID;
		this.listPrice = listPrice;
		this.productName = productName;
	}
	public Product() {
		super();
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getListPrice() {
		return listPrice;
	}
	public void setListPrice(int listPrice) {
		this.listPrice = listPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	} 
	 
	

}
