package finalProject.homepage;

import java.util.ArrayList;

public class Reviews {
private String review;
private String rating;
public Reviews(String review, String rating) {
	this.setReview(review);
	this.setRating(rating);
}
public String getReview() {
	return review;
}
public void setReview(String review) {
	this.review = review;
}
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}
}
