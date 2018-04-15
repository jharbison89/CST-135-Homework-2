
public class Chips extends Snack{
	
	private String cookStyle;
	private double netWt;
	
	public Chips() {
		cookStyle = "REGULAR";
		netWt = 1;
	}
	
	public Chips(String name, double price, int maxQuantity, int currentQuantity, String flavor, String cookStyle, double netWt) {
		setName(name);
		setPrice(price);
		setMaxQuantity(maxQuantity);
		setCurrentQuantity(currentQuantity);
		setFlavor(flavor);
		this.cookStyle = cookStyle;
		this.netWt = netWt;
	}
	
	public Chips(Chips chips) {
		setName(chips.getName());
		setPrice(chips.getPrice());
		setMaxQuantity(chips.getMaxQuantity());
		setCurrentQuantity(chips.getCurrentQuantity());
		setFlavor(chips.getFlavor());
		cookStyle = chips.cookStyle;
		netWt = chips.netWt;
	}
	
	public void setCookStyle(String cookStyle) {
		this.cookStyle = cookStyle;
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
		return "Product Name\t" + getName() + "\nPrice\t\t" + getPrice() + "\nMax Quantity\t" + getMaxQuantity() + 
				"\nCurrent Quantity\t" + getCurrentQuantity() + "\nFlavor\t\t" + getFlavor() + "\nCook Style\t" +
				cookStyle + "\nNet Wt\t\t" + netWt;
	}
}
