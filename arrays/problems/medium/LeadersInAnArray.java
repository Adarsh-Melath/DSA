package arrays.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class provides solutions to find all the leaders in an array.
 *
 * A leader in an array is an element that is greater than or equal to
 * all the elements to its right side.
 *
 * Example:
 * Input: [1, 2, 5, 3, 1, 2]
 * Output: [5, 3, 2]
 */
public class LeadersInAnArray {

    /**
     * Main method to test brute force and optimal solutions.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 3, 1, 2 };

        System.out.println(Arrays.toString(bruteForceSolution(nums).toArray()));
        System.out.println(Arrays.toString(optimalSolution(nums).toArray()));
    }

    /**
     * Brute force approach to find leaders in the array.
     *
     * For each element, it checks all the elements to its right
     * to determine whether it is a leader.
     *
     * @param nums input array of integers
     * @return list of leader elements
     *
     *         Time Complexity:
     *         O(n^2) — for each element, all elements to the right are checked
     *
     *         Space Complexity:
     *         O(k) — to store the leaders (k = number of leaders)
     */
    public static List<Integer> bruteForceSolution(int[] nums) {
        List<Integer> leaders = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int isLeader = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    isLeader = 0;
                    break;
                }
            }
            if (isLeader == 1) {
                leaders.add(nums[i]);
            }
        }
        return leaders;
    }

    /**
     * Optimal approach to find leaders in the array.
     *
     * The array is traversed from right to left while keeping track
     * of the maximum element seen so far.
     *
     * An element is a leader if it is greater than the current maximum.
     *
     * @param nums input array of integers
     * @return list of leader elements in original order
     *
     *         Time Complexity:
     *         O(n) — single traversal of the array
     *
     *         Space Complexity:
     *         O(k) — to store the leaders (k = number of leaders)
     */
    public static List<Integer> optimalSolution(int[] nums) {
        List<Integer> leaders = new ArrayList<>();

        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                leaders.add(max);
            }
        }

        Collections.reverse(leaders);
        return leaders;
    }
}
