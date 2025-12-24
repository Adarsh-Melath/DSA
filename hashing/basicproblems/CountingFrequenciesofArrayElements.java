package hashing.basicproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class counts the frequency of each element in an integer array.
 *
 * <p>
 * It uses a HashMap to store array elements as keys and
 * their corresponding frequencies as values.
 * </p>
 *
 * <p>
 * The result is returned as a list of lists, where each inner list
 * contains two integers: [element, frequency].
 * </p>
 */
public class CountingFrequenciesofArrayElements {

  /**
   * The main method is the entry point of the program.
   *
   * <p>
   * It initializes an array, calls the frequency-counting method,
   * and prints the result.
   * </p>
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {

    // Input array
    int[] arr = { 10, 5, 10, 15, 10, 5 };

    // Call method to count frequencies
    List<List<Integer>> result = f(arr);

    // Print the result
    System.out.println(result);
  }

  /**
   * Counts the frequency of each element in the given array.
   *
   * <p>
   * Each unique element and its frequency are stored as a pair
   * inside a list, and all such pairs are returned as a list.
   * </p>
   *
   * <p>
   * Example output format:
   * [[10, 3], [5, 2], [15, 1]]
   * </p>
   *
   * @param arr the input integer array
   * @return a list of lists where each inner list contains
   *         an element and its frequency
   */
  public static List<List<Integer>> f(int[] arr) {

    // HashMap to store element -> frequency
    Map<Integer, Integer> map = new HashMap<>();

    // Count frequency of each element
    for (int num : arr) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    // List to store the result pairs
    List<List<Integer>> result = new ArrayList<>();

    // Convert map entries to list of pairs
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

      List<Integer> pair = new ArrayList<>();

      int key = entry.getKey(); // array element
      int value = entry.getValue(); // frequency

      pair.add(key);
      pair.add(value);

      result.add(pair);
    }

    // Return the frequency list
    return result;
  }
}
