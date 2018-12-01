package finalProject.homepage;

public class RestaurantReviews implements Comparable{
	private String name;
	private LLStackReview<Reviews> reviews;
	public RestaurantReviews(String name, LLStackReview<Reviews> reviews) {
		this.setName(name);
		this.setReviews(reviews);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LLStackReview<Reviews> getReviews() {
		return reviews;
	}
	public void setReviews(LLStackReview<Reviews> reviews) {
		this.reviews = reviews;
	}
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if (this.name.compareTo(((RestaurantReviews) o).getName()) < 0) {
			return -1;
		}
		if (this.name.compareTo(((RestaurantReviews) o).getName()) > 0) {
			return 1;
		}
		return 0;
	}
}
