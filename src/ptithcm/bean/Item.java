package ptithcm.bean;

import ptithcm.entity.Guitar;

public class Item {
	private Guitar product;
	private int quantity;
	
	
	
	public Item(Guitar product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public Guitar getProduct() {
		return product;
	}
	public void setProduct(Guitar product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
