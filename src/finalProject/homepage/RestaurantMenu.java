package finalProject.homepage;

public class RestaurantMenu {
	private SortedLinkedListMenu<FoodItem> entrees, sides, appetizers, drinks;

	public RestaurantMenu(SortedLinkedListMenu<FoodItem> entrees, SortedLinkedListMenu<FoodItem> sides,
			SortedLinkedListMenu<FoodItem> appetizers, SortedLinkedListMenu<FoodItem> drinks) {
		this.entrees = entrees;
		this.sides = sides;
		this.appetizers = appetizers;
		this.drinks = drinks;
	}

}
