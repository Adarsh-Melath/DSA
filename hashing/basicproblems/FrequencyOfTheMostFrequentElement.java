package hashing.basicproblems;

import java.util.Arrays;

/**
 * LeetCode Problem: <b>1838. Frequency of the Most Frequent Element</b>
 * <p>
 * This class provides a brute-force solution to the LeetCode problem
 * "Frequency of the Most Frequent Element".
 * </p>
 *
 * <p>
 * Problem Description:
 * You are given an integer array {@code nums} and an integer {@code k}.
 * In one operation, you can increment any element of the array by 1.
 * Return the maximum possible frequency of an element after performing
 * at most {@code k} operations.
 * </p>
 *
 * <p>
 * Example:
 * 
 * <pre>
 * Input: nums = [1, 4, 8, 13], k = 5
 * Output: 2
 * </pre>
 * </p>
 *
 * <p>
 * Approach Used:
 * <ul>
 * <li>Sort the array</li>
 * <li>Fix each element as a target value</li>
 * <li>Try to make previous elements equal to it using available operations</li>
 * </ul>
 * </p>
 *
 * <p>
 * Time Complexity: O(n²)
 * <br>
 * Space Complexity: O(1) (excluding sorting space)
 * </p>
 */
public class FrequencyOfTheMostFrequentElement {

  /**
   * Entry point for testing the solution.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr = { 1, 4, 8, 13 };
    int k = 5;

    // Brute-force solution
    System.out.println(f(arr, k));
  }

  /**
   * Computes the maximum frequency of any element after at most {@code k}
   * increment operations.
   *
   * <p>
   * For each element in the sorted array, this method attempts to convert
   * all smaller elements before it into the current element by using
   * the available increment operations.
   * </p>
   *
   * @param arr the input array of integers
   * @param k   the maximum number of increment operations allowed
   * @return the maximum possible frequency of an element
   */
  public static int f(int[] arr, int k) {
    // Sort the array to allow efficient comparison
    Arrays.sort(arr);

    int maxCount = 1;

    // Treat each element as the target value
    for (int i = 0; i < arr.length; i++) {
      int currK = k;
      int count = 1;

      // Attempt to increase previous elements to match arr[i]
      for (int j = i - 1; j >= 0; j--) {
        int diff = arr[i] - arr[j];

        if (diff <= currK) {
          currK -= diff;
          count++;
        } else {
          break;
        }
      }

      // Update the maximum frequency found
      maxCount = Math.max(maxCount, count);
    }

    return maxCount;
  }
}
