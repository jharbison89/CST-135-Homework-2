
public class Chips extends Snack{
	
	/*
	 * Created by James Harbison and Chase Hausman
	 * This class extends the Snack class with items unique to chips in a vending machine
	 */
	
	
	private String cookStyle;	// indicates cook style such as regular, kettle, or baked
	private double netWt;		// indicates net weight in ounces
	
	// no arg constructor
	public Chips() {
		cookStyle = "REGULAR";
		netWt = 1;
	}
	
	// overloaded constructor
	public Chips(String name, double price, int maxQuantity, int currentQuantity, String flavor, String cookStyle, double netWt) {
		setName(name);
		setPrice(price);
		setMaxQuantity(maxQuantity);
		setCurrentQuantity(currentQuantity);
		setFlavor(flavor);
		this.cookStyle = cookStyle.toUpperCase();
		this.netWt = netWt;
	}
	
	// constructor that copies an existing Chips
	public Chips(Chips chips) {
		setName(chips.getName());
		setPrice(chips.getPrice());
		setMaxQuantity(chips.getMaxQuantity());
		setCurrentQuantity(chips.getCurrentQuantity());
		setFlavor(chips.getFlavor());
		cookStyle = chips.cookStyle.toUpperCase();
		netWt = chips.netWt;
	}
	
	public void setCookStyle(String cookStyle) {
		this.cookStyle = cookStyle.toUpperCase();
	}
	
	public String getCookStyle() {
		return cookStyle;
	}
	
	public void setNetWt(double netWt) {
		this.netWt = netWt;
	}
	
	public double getNetWt() {
		return netWt;
	}

	@Override
	public String toString() {
		return "Product Name\t\t" + getName() + "\nPrice\t\t\t" + getPrice() + "\nMax Quantity\t\t" + getMaxQuantity() + 
				"\nCurrent Quantity\t" + getCurrentQuantity() + "\nFlavor\t\t\t" + getFlavor() + "\nCook Style\t\t" +
				cookStyle + "\nNet Wt\t\t\t" + netWt;
	}
}
