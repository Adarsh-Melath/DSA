package arrays.problems.medium;

/**
 * This class provides a solution to the Stock Buy and Sell problem.
 *
 * The goal is to find the maximum profit that can be achieved by
 * buying a stock on one day and selling it on a later day.
 */
public class StockBuyAnsSell {

    /**
     * Entry point of the program.
     * Initializes the stock prices array and prints the maximum profit.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        int[] cost = { 7, 1, 5, 3, 6, 4 };
        int maxProfit = f(cost);
        System.out.println(maxProfit);
    }

    /**
     * Calculates the maximum profit from a single buy and sell operation.
     *
     * The method keeps track of the minimum price encountered so far
     * and computes the profit for each day by selling at the current price.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param array the array representing stock prices on different days
     * @return the maximum profit achievable
     */
    public static int f(int[] array) {
        int min = array[0];
        int maxProfit = 0;

        for (int i = 1; i < array.length; i++) {
            int cost = array[i] - min;
            maxProfit = Math.max(maxProfit, cost);
            min = Math.min(min, array[i]);
        }
        return maxProfit;
    }
}
