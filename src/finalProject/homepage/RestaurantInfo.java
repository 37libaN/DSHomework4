package finalProject.homepage;

import java.util.ArrayList;

public class RestaurantInfo implements Comparable{
	private String name, address, phoneNo, email, cuisine, dineType, priceRange;
	private String[] hours;
	private LLStackReview reviews;
	private String avgRating;
	//private RestaurantMenu menu;
	private ArrayList<String> menu;

	public RestaurantInfo(String name, String address, String phoneNo, String email, String cuisine, String dineType,
			String priceRange, LLStackReview reviews, String[] hours, String rating, ArrayList<String> menu) {
		this.setName(name);
		this.setAddress(address);
		this.setPhoneNo(phoneNo);
		this.setEmail(email);
		this.setCuisine(cuisine);
		this.setDineType(dineType);
		this.setPriceRange(priceRange);
		this.setReviews(reviews);
		this.setHours(hours);
		this.setMenu(menu);
		this.setAvgRating(rating);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getDineType() {
		return dineType;
	}

	public void setDineType(String dineType) {
		this.dineType = dineType;
	}

	public String getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	public String[] getHours() {
		return hours;
	}

	public void setHours(String[] hours) {
		this.hours = hours;
	}

	public LLStackReview getReviews() {
		return reviews;
	}

	public void setReviews(LLStackReview reviews) {
		this.reviews = reviews;
	}

	public String getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(String avgRating) {
		this.avgRating = avgRating;
	}

	public ArrayList<String> getMenu() {
		return menu;
	}

	public void setMenu(ArrayList<String> menu) {
		this.menu = menu;
	}
	
	public String toString() {
		String toString = "";
		toString+=name+"\n";
		toString+=address+"\n";
		toString+=phoneNo+"\n";
		toString+=email+"\n";
		for(String h : hours) {
			toString += h;
		}
		toString+=cuisine+"\n";
		toString+=dineType+"\n";
		toString+=priceRange+"\n";
		toString+=avgRating+"\n";
		return toString;
	}

	
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if (this.name.compareTo(((RestaurantInfo) o).getName()) < 0) {
			return -1;
		}
		if (this.name.compareTo(((RestaurantInfo) o).getName()) > 0) {
			return 1;
		}
		return 0;
	}
}
