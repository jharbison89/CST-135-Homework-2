
public class Candy extends Snack {
	
	private boolean nuts;
	private boolean caramel;
	private boolean chocolate;
	private boolean bar;
	private boolean kingSize;
	
	public Candy() {
		nuts = false;
		caramel = false;
		chocolate = false;
		bar = false;
		kingSize = false;
	}
	
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
		String string = "Product Name\t" + getName() + "\nPrice\t\t" + getPrice() + "\nMax Quantity\t" + getMaxQuantity() + 
				"\nCurrent Quantity\t" + getCurrentQuantity() + "\nFlavor\t\t" + getFlavor();
		
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
