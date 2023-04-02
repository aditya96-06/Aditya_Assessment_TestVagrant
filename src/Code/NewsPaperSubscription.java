package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewsPaperSubscription {

	public static void main(String[] args) {

		// the prices of newspapers in a 2 dimensional array
		double[][] prices = { { 3, 3, 3, 3, 3, 5, 6 }, // TOI
				{ 2.5, 2.5, 2.5, 2.5, 2.5, 4, 4 }, // Hindu
				{ 4, 4, 4, 4, 4, 4, 10 }, // ET
				{ 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5 }, // BM
				{ 2, 2, 2, 2, 2, 4, 4 } // HT
		};

		// Define the names of newspapers in an array
		String[] names = { "TOI", "Hindu", "ET", "BM", "HT" };

		// Get the weekly budget from the user
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your weekly budget: ");
		double budget = scanner.nextDouble();

		// Find all possible combinations of newspaper subscriptions
		List<List<String>> combinations = new ArrayList<>();
		generateCombinations(names, prices, budget, combinations, new ArrayList<String>(), 0);

		System.out.println("Possible combinations for a budget of " + budget + " rupees:");
		for (List<String> combination : combinations) {
			System.out.println(combination);
		}
	}

	private static void generateCombinations(String[] names, double[][] prices, double budget,
			List<List<String>> combinations, List<String> current, int index) {
		if (budget == 0) {
			combinations.add(new ArrayList<String>(current));
		} else if (budget > 0 && index < names.length) {
			for (int i = 0; i < prices[index].length; i++) {
				if (budget >= prices[index][i]) {
					current.add(names[index]);
					generateCombinations(names, prices, budget - prices[index][i], combinations, current, index + 1);
					current.remove(current.size() - 1);
				}
			}
			generateCombinations(names, prices, budget, combinations, current, index + 1);
		}
	}

}
