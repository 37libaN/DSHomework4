package finalProject.homepage;

public class RestaurantMenu {
private SortedLinkedListMenu<FoodItem> entrees, sides, appetizers, drinks;
public RestaurantMenu(){
	entrees = new SortedLinkedListMenu<FoodItem>();
	sides = new SortedLinkedListMenu<FoodItem>();
	appetizers = new SortedLinkedListMenu<FoodItem>();
	drinks = new SortedLinkedListMenu<FoodItem>();
}
}
