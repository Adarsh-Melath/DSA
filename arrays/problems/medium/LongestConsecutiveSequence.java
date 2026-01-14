package arrays.problems.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides different approaches to solve the
 * Longest Consecutive Sequence problem.
 *
 * The problem is to find the length of the longest sequence
 * of consecutive integers present in an unsorted array.
 *
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive sequence is [1, 2, 3, 4]
 */
public class LongestConsecutiveSequence {

    /**
     * Main method to test all three solutions.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };

        System.out.println(bruteForceSolution(nums));
        System.out.println(betterSolution(nums));
        System.out.println(optimalSolution(nums));
    }

    /**
     * Brute force approach to find the longest consecutive sequence.
     *
     * For each element, it checks linearly whether the next
     * consecutive number exists in the array.
     *
     * @param nums input array of integers
     * @return length of the longest consecutive sequence
     *
     *         Time Complexity:
     *         O(n^2) — for each element, a linear search is performed
     *
     *         Space Complexity:
     *         O(1) — no extra space used apart from variables
     */
    public static int bruteForceSolution(int[] nums) {
        int maxCount = 1;

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int count = 1;

            while (linearSearch(nums, currentNumber + 1)) {
                currentNumber++;
                count++;
            }

            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

    /**
     * Helper method to perform linear search in the array.
     *
     * @param nums input array
     * @param num  number to be searched
     * @return true if number exists, otherwise false
     *
     *         Time Complexity:
     *         O(n)
     *
     *         Space Complexity:
     *         O(1)
     */
    public static boolean linearSearch(int[] nums, int num) {
        for (int n : nums) {
            if (num == n) {
                return true;
            }
        }
        return false;
    }

    /**
     * Better approach using sorting.
     *
     * The array is sorted, and consecutive elements are counted
     * while skipping duplicates.
     *
     * @param nums input array of integers
     * @return length of the longest consecutive sequence
     *
     *         Time Complexity:
     *         O(n log n) — due to sorting
     *
     *         Space Complexity:
     *         O(1) — ignoring sorting space (in-place sort)
     */
    public static int betterSolution(int[] nums) {
        int maxCount = 1;
        int lastSmaller = Integer.MIN_VALUE;
        int currentCount = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (lastSmaller == nums[i] - 1) {
                currentCount++;
                lastSmaller = nums[i];
            } else if (lastSmaller != nums[i]) {
                currentCount = 1;
                lastSmaller = nums[i];
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
        }
        return maxCount;
    }

    /**
     * Optimal approach using a HashSet.
     *
     * All elements are inserted into a set.
     * A sequence is started only if the current number
     * does not have a predecessor.
     *
     * @param nums input array of integers
     * @return length of the longest consecutive sequence
     *
     *         Time Complexity:
     *         O(n) — each element is processed at most twice
     *
     *         Space Complexity:
     *         O(n) — extra space used for the HashSet
     */
    public static int optimalSolution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxCount = 1;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int x = num;

                while (set.contains(x + 1)) {
                    count++;
                    x++;
                }

                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }
        return maxCount;
    }
}
