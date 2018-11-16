package finalProject.homepage;

public class FoodItem implements Comparable {
	private String name;
	private double cost;

	public FoodItem(String name, double cost) {
		this.setName(name);
		this.setCost(cost);
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int compareTo(Object toCompare) {
		if (Math.abs((this.getCost()) - (((FoodItem) toCompare).getCost())) <= 0.00001)
			return 0;
		if (this.getCost() < ((FoodItem) toCompare).getCost())
			return -1;
		return 1;
	}
}
