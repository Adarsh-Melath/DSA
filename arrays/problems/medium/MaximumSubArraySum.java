package arrays.problems.medium;

/**
 * This class provides solutions to find the maximum subarray sum
 * from a given integer array.
 *
 * It includes:
 * 1. A brute-force approach with higher time complexity.
 * 2. An optimal approach using Kadane's Algorithm.
 */
public class MaximumSubArraySum {

    /**
     * Entry point of the program.
     * Initializes the array and prints the maximum subarray sum
     * using the optimal solution.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        int[] array = { 2, 3, 5, -2, 7, -4 };

        // int maxSum = bruteForceSolution(array);
        int maxSum = optimalSolution(array);

        System.out.println(maxSum);
    }

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     *
     * This method checks all possible subarrays and calculates their sums.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @param array the input array of integers
     * @return the maximum subarray sum
     */
    public static int bruteForceSolution(int[] array) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i + 1; j < array.length; j++) {
                sum += array[i];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     *
     * The algorithm keeps track of the current subarray sum and
     * resets it when it becomes negative, ensuring optimal performance.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param array the input array of integers
     * @return the maximum subarray sum
     */
    public static int optimalSolution(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (sum > maxSum) {
                maxSum = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
