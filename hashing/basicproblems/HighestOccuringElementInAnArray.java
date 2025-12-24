package hashing.basicproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * This class finds the highest occurring (most frequent) element
 * in an integer array using HashMap.
 *
 * <p>
 * HashMap is used to store each element as a key and
 * its frequency as the value.
 * </p>
 */
public class HighestOccuringElementInAnArray {

  /**
   * The main method is the entry point of the program.
   *
   * <p>
   * It creates an array, calls the function to find
   * the highest occurring element, and prints the result.
   * </p>
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {

    // Sample input array
    int[] arr = { 1, 2, 2, 3, 3, 3 };

    // Call function to find highest occurring element
    int max = f(arr);

    // Print the result
    System.out.println(max);
  }

  /**
   * Finds the element that occurs the maximum number of times
   * in the given integer array.
   *
   * <p>
   * If multiple elements have the same highest frequency,
   * the element that reaches the maximum count first is returned.
   * </p>
   *
   * @param arr the input array of integers
   * @return the element with the highest frequency
   */
  public static int f(int[] arr) {

    // Stores the highest frequency found so far
    int count = 0;

    // Stores the element with the highest frequency
    int max = Integer.MIN_VALUE;

    // HashMap to store element -> frequency
    Map<Integer, Integer> map = new HashMap<>();

    // Iterate through the array
    for (int num : arr) {

      // Update frequency of the current element
      map.put(num, map.getOrDefault(num, 0) + 1);

      // Check if current element has higher frequency
      if (map.get(num) > max) {
        // count = map.get(num);
        max = num;
      }
    }

    // Return the highest occurring element
    return max;
  }
}
