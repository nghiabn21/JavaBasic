package learn.entities;

public class LineItem { 
	private int orderID, quantity, productID; 
	private float price ;
	public LineItem(int orderID, int quantity, int productID, float price) {
		super();
		this.orderID = orderID;
		this.quantity = quantity;
		this.productID = productID;
		this.price = price;
	}
	public LineItem() {
		super();
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	} 
	 
	

}
