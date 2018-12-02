package finalProject.homepage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer {
	private static PrintWriter reviewOutFile;

	public static void writeRestaurant(RestaurantInfo restaurant) throws IOException {//write current restaurant's info to file
		PrintWriter outFile = new PrintWriter(new FileWriter("C:/Users/liban/Desktop/singleRestaurantData.txt"));
		outFile.println(restaurant.getName());
		outFile.println(restaurant.getAddress());
		outFile.println(restaurant.getPhoneNo());
		outFile.println(restaurant.getEmail());
		String[] hours = restaurant.getHours();
		for (int i = 0; i < hours.length; i++) {
			outFile.println(hours[i]);
		}
		outFile.println(restaurant.getCuisine());
		outFile.println(restaurant.getDineType());
		outFile.println(restaurant.getPriceRange());
		outFile.println(restaurant.getAvgRating());
		ArrayList<String> restMenu = restaurant.getMenu();
		outFile.println("-");
		for (String r : restMenu) {
			outFile.println(r);
		}
		outFile.println("-");
		outFile.close();
	}

	public static void writeReview(String review, String rating) throws IOException {//writes reviews to file
		SortedLinkedList<RestaurantReviews> allReviews = RestaurantAdvisor.getInstance().getAllReviews();
		PrintWriter outFile = new PrintWriter(new FileWriter("C:/Users/liban/Desktop/reviewData.txt"));
		RestaurantInfo restaurant = RestaurantAdvisor.getInstance().getRestaurantInfo();
		if (allReviews.findReview(restaurant.getName())) {
			RestaurantReviews thisRestaurantReviews = allReviews.getFoundNode().getInfo();
			LLStackReview<Reviews> theseReviews = thisRestaurantReviews.getReviews();
			theseReviews.Push(new Reviews(review, rating));
			allReviews.getFoundNode().getInfo().setReviews(theseReviews);
		} else {
			LLStackReview<Reviews> reviews = new LLStackReview<Reviews>();
			reviews.Push(new Reviews(review, rating));
			allReviews.add(new RestaurantReviews(restaurant.getName(), reviews));
		}
		allReviews.reset();
		while (allReviews.getNode() != null) {
			RestaurantReviews currReviews = allReviews.getNode().getInfo();
			LLStackReview<Reviews> reviews = currReviews.getReviews();
			outFile.println("-----");
			outFile.println(currReviews.getName());
			while (!reviews.isEmpty()) {
				outFile.println("---");
				outFile.println(reviews.Top().getReview());
				outFile.println("-");
				outFile.println(reviews.Top().getRating());
				outFile.println("-");
				reviews.Pop();
			}
			allReviews.step();
		}
		outFile.close();
	}
}
