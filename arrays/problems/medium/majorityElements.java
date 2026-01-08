package arrays.problems.medium;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class provides three different approaches to find
 * the majority element in an array.
 *
 * A majority element is an element that appears more than
 * n / 2 times in the array, where n is the size of the array.
 *
 * Approaches implemented:
 * 1. Brute force solution using nested loops
 * 2. Better solution using HashMap for counting frequency
 * 3. Optimal solution using Moore's Voting Algorithm
 */
public class majorityElements {

    /**
     * Entry point of the program.
     *
     * Creates an input array, applies one of the majority
     * element solutions, and prints the result.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };

        // int result = bruteForceSolution(nums);
        // int result = betterSolution(nums);
        int result = optimalSolution(nums);

        System.out.println(result);
    }

    /**
     * Brute force solution to find the majority element.
     *
     * For each element, it counts how many times the element
     * appears in the array using a nested loop.
     *
     * Time Complexity:
     * O(n^2)
     *
     * Space Complexity:
     * O(1)
     *
     * @param nums input array of integers
     * @return the majority element
     */
    public static int bruteForceSolution(int[] nums) {
        int majorElement = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 1;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > nums.length / 2) {
                majorElement = nums[i];
            }
        }
        return majorElement;
    }

    /**
     * Better solution using a map to count frequency of elements.
     *
     * Iterates through the array and stores the count of each
     * element in a map. Once any element's count exceeds n / 2,
     * it is identified as the majority element.
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(n)
     *
     * @param nums input array of integers
     * @return the majority element
     */
    public static int betterSolution(int[] nums) {
        int n = nums.length / 2;
        int majorElement = 0;

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > n) {
                majorElement = num;
            }
        }
        return majorElement;
    }

    /**
     * Optimal solution using Moore's Voting Algorithm.
     *
     * The algorithm works in two steps:
     * 1. Find a candidate element by canceling out different elements.
     * 2. The candidate is guaranteed to be the majority element
     * because it appears more than n / 2 times.
     *
     * This solution assumes that a majority element always exists.
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(1)
     *
     * @param nums input array of integers
     * @return the majority element
     */
    public static int optimalSolution(int[] nums) {
        int count = 0;
        int element = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                element = nums[i];
            }

            if (element == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }
}
