package arrays.problems.easy;
import java.util.HashMap;
import java.util.Map;

/**
 * This class demonstrates different approaches to find the length of the
 * longest subarray whose sum is equal to a given value K.
 *
 * Approaches included:
 * 1. Brute Force approach
 * 2. Better approach using Prefix Sum and HashMap
 * 3. Optimal approach using Sliding Window technique
 */
public class LongestSubArrayWithGivenSumK {

  /**
   * Entry point of the program.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    int[] arr = { 10, 5, 2, 7, 1, 9 };
    int k = 15;

    System.out.println(bruteForceSolution(arr, k));
    System.out.println(betterSolution(arr, k));
    System.out.println(optimalSolution(arr, k));
  }

  /**
   * Finds the longest subarray with sum equal to K using brute force approach.
   *
   * Time Complexity: O(n^2)
   * Space Complexity: O(1)
   *
   * @param arr input array of integers
   * @param k   target sum
   * @return length of the longest subarray with sum equal to k
   */
  public static int bruteForceSolution(int[] arr, int k) {
    int length = 0;

    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[i];
        if (sum == k) {
          length = Math.max(length, j - i + 2);
        }
      }
    }
    return length;
  }

  /**
   * Finds the longest subarray with sum equal to K using prefix sum and HashMap.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   *
   * @param nums input array of integers
   * @param k    target sum
   * @return length of the longest subarray with sum equal to k
   */
  public static int betterSolution(int[] nums, int k) {
    int sum = 0;
    int maxLength = 0;

    Map<Integer, Integer> prefixSumMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      if (sum == k) {
        maxLength = Math.max(maxLength, i + 1);
      }

      int remaining = sum - k;
      if (prefixSumMap.containsKey(remaining)) {
        int prevIndex = prefixSumMap.get(remaining);
        maxLength = Math.max(maxLength, i - prevIndex);
      }

      prefixSumMap.put(sum, i);
    }
    return maxLength;
  }

  /**
   * Finds the longest subarray with sum equal to K using sliding window approach.
   *
   * This approach works only when all array elements are non-negative.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   *
   * @param arr input array containing non-negative integers
   * @param k   target sum
   * @return length of the longest subarray with sum equal to k
   */
  public static int optimalSolution(int[] arr, int k) {
    int left = 0;
    int right = 0;
    int sum = 0;
    int maxLen = 0;

    while (right < arr.length) {

      while (sum > k) {
        sum -= arr[left++];
      }

      if (sum == k) {
        maxLen = Math.max(maxLen, right - left);
      }

      sum += arr[right++];
    }
    return maxLen;
  }
}
