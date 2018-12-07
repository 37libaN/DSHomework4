package finalProject.homepage;

import java.util.ArrayList;

public class Reviews {
private String review;
private int rating;
public Reviews(String review, int rating) {
	this.setReview(review);
	this.setRating(rating);
}
public String getReview() {
	return review;
}
public void setReview(String review) {
	this.review = review;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
}
