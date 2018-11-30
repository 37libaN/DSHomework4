package finalProject.homepage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer {
	public static void writeRestaurant(RestaurantInfo restaurant) throws IOException {
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
		for(String r : restMenu) {
			outFile.println(r);
		}
		outFile.println("-");
		outFile.close();
	}
}
