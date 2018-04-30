import java.util.ArrayList;

/**
 * Program: CST-135-Homework
 * File: Cart.java
 * Summary:
 * Author: Chase Hausman
 * Date: April 29, 2018
 */
public class Cart {
	private Double total;
	private ArrayList<Product> items;

	public Cart() {
		this.total = 0.0;
		items = new ArrayList<Product>(0);
	}

	public void addItemToCart(Product product) {
		this.items.add(product);

		this.total = this.total + product.getPrice();
	}

	public double getTotal() {
		return total;
	}

	public int getNumberOfItems() {
		return this.items.size();
	}

	public ArrayList<Product> getItems() {
		return this.items;
	}
}
