
public class Candy extends Snack {
	
	/*
	 * Created by James Harbison and Chase Hausman
	 * This class extends the Snack class with items unique to Candy in a vending machine
	 */
	
	private boolean nuts;		// true contains nuts, false does not contain nuts 
	private boolean caramel;	// true contains caramel, false does not contain caramel
	private boolean chocolate;	// true contains chocolate, false does not contain chocolate
	private boolean bar;		// true is a candy bar, false is not a bar ie. Skittles or M&Ms
	private boolean kingSize;	// true is a king size, false is regular size
	
	// no arg constructor
	public Candy() {
		nuts = false;
		caramel = false;
		chocolate = false;
		bar = false;
		kingSize = false;
	}
	
	// overloaded constructor
	public Candy(String name, double price, int maxQuantity, int currentQuantity, String flavor, boolean nuts, boolean caramel, boolean chocolate, boolean bar, boolean kingSize) {
		setName(name);
		setPrice(price);
		setMaxQuantity(maxQuantity);
		setCurrentQuantity(currentQuantity);
		setFlavor(flavor);
		this.nuts = nuts;
		this.caramel = caramel;
		this.chocolate = chocolate;
		this.bar = bar;
		this.kingSize = kingSize;
	}
	
	// constructor that copies a current Candy
	public Candy(Candy candy) {
		setName(candy.getName());
		setPrice(candy.getPrice());
		setMaxQuantity(candy.getMaxQuantity());
		setCurrentQuantity(candy.getCurrentQuantity());
		setFlavor(candy.getFlavor());
		this.nuts = candy.nuts;
		this.caramel = candy.caramel;
		this.chocolate = candy.chocolate;
		this.bar = candy.bar;
		this.kingSize = candy.kingSize;
	}
	
	public void setNuts(boolean nuts) {
		this.nuts = nuts;
	}
	
	public boolean hasNuts() {
		return nuts;
	}
	
	public void setCaramel(boolean caramel) {
		this.caramel = caramel;
	}
	
	public boolean hasCaramel() {
		return caramel;
	}
	
	public void setChocolate(boolean chocolate) {
		this.chocolate = chocolate;
	}
	
	public boolean hasChocolate() {
		return chocolate;
	}
	
	public void setBar(boolean bar) {
		this.bar = bar;
	}
	
	public boolean isBar() {
		return bar;
	}
	
	public void setKingSize(boolean kingSize) {
		this.kingSize = kingSize;
	}
	
	public boolean isKingSize() {
		return kingSize;
	}

	@Override
	public String toString() {
		String string = "Product Name\t\t" + getName() + "\nPrice\t\t\t" + getPrice() + "\nMax Quantity\t\t" + getMaxQuantity() + 
				"\nCurrent Quantity\t" + getCurrentQuantity() + "\nFlavor\t\t\t" + getFlavor();
		
		if(kingSize) {
			string = string + "\nA King Size Candy ";
		}
		else {
			string = string + "\nA Regular Size Candy ";
		}
		
		if(bar) {
			string = string + "Bar ";	
		}
		
		if(nuts || caramel || chocolate) {
			string = string + "Containing: ";
		
			if(nuts) {
				string = string + "Nuts ";
			}
		
			if(caramel) {
				string = string + "Caramel ";
			}
		
			if(chocolate) {
				string = string + "Chocolate ";
			}
		}
		
		return string;
	}
}
