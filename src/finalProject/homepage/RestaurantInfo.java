package finalProject.homepage;

public class RestaurantInfo {
private String name, address, phoneNo, cuisine, dineType, priceRange;
private String[] hours;
private LLStackReview reviews;
private int avgRating;
private RestaurantMenu menu;
public RestaurantInfo(String name, String address, String phoneNo, String cuisine, String dineType, String priceRange, LLStackReview reviews, String[] hours, int rating, RestaurantMenu menu) {
	this.name = name;
	this.address = address;
	this.phoneNo = phoneNo;
	this.cuisine = cuisine;
	this.dineType = dineType;
	this.priceRange = priceRange;
	this.reviews = reviews;
	this.hours = hours;
	this.menu = menu;
}
}
