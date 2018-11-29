package finalProject.homepage;

public class RestaurantMenu {
	private SortedLinkedList<FoodItem> entrees, sides, appetizers, drinks; 
	 
	public RestaurantMenu(SortedLinkedList<FoodItem> entrees, SortedLinkedList<FoodItem> sides, 
			SortedLinkedList<FoodItem> appetizers, SortedLinkedList<FoodItem> drinks) { 		this.entrees = entrees;
		this.sides = sides;
		this.appetizers = appetizers;
		this.drinks = drinks;
	}

}
