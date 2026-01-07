package arrays.problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides different approaches to solve the Two Sum problem.
 *
 * Problem statement:
 * Given an array of integers and a target value, return the indices of
 * the two numbers such that they add up to the target.
 *
 * Approaches included:
 * 1. Brute Force approach
 * 2. Better approach using HashMap
 * 3. Optimal approach using Two Pointer technique
 */
public class TwoSum {

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int[] nums = { 1, 6, 2, 10, 3 };
        int target = 7;

        // int[] result = bruteForceSolution(nums, target);
        // int[] result = betterSolution(nums, target);
        int[] result = optimalSolution(nums, target);

        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * Solves the Two Sum problem using brute force approach.
     *
     * This method checks all possible pairs in the array.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @param nums   input array of integers
     * @param target target sum
     * @return indices of the two elements whose sum equals target,
     *         or {-1, -1} if no solution exists
     */
    public static int[] bruteForceSolution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    /**
     * Solves the Two Sum problem using HashMap.
     *
     * This method stores previously visited elements and
     * checks whether the complement exists.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums   input array of integers
     * @param target target sum
     * @return indices of the two elements whose sum equals target,
     *         or {-1, -1} if no solution exists
     */
    public static int[] betterSolution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[] { i, map.get(diff) };
            }

            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    /**
     * Solves the Two Sum problem using Two Pointer technique.
     *
     * This method first sorts the array and then uses two pointers
     * to find the target sum.
     *
     * Note:
     * Sorting changes the original indices, so this approach does
     * NOT return the original indices of the array.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     *
     * @param nums   input array of integers
     * @param target target sum
     * @return indices of the two elements in the sorted array whose sum equals
     *         target,
     *         or {-1, -1} if no solution exists
     */
    public static int[] optimalSolution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        Arrays.sort(nums);

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[] { left, right };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { -1, -1 };
    }
}
