import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates multiple approaches to find
 * the missing number in a sorted array containing
 * numbers from 1 to N with exactly one number missing.
 *
 * Example:
 * Input: {1, 2, 3, 5}
 * Output: 4
 */
public class MissingNumberInTheArray {

  /**
   * Entry point of the program.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 5 };

    System.out.println(bruteForceSolution(arr));
    betterSolution(arr);
    optimalSolution1(arr);
    optimalSolution2(arr);
  }

  /**
   * Brute force approach to find the missing number.
   * <p>
   * For each number from 1 to N, the method checks
   * whether it exists in the array.
   *
   * Time Complexity: O(N²)
   * Space Complexity: O(1)
   *
   * @param arr sorted array containing numbers from 1 to N with one missing
   * @return the missing number
   */
  public static int bruteForceSolution(int[] arr) {
    int n = arr[arr.length - 1];

    for (int i = 1; i <= n; i++) {
      int flag = 0;

      for (int j = 0; j < n - 1; j++) {
        if (arr[j] == i) {
          flag = 1;
          break;
        }
      }

      if (flag == 0) {
        return i;
      }
    }
    return 0;
  }

  /**
   * Better approach using a hash (frequency) array.
   * <p>
   * Marks all existing numbers and identifies
   * the one that is missing.
   *
   * Time Complexity: O(N)
   * Space Complexity: O(N)
   *
   * @param arr sorted array containing numbers from 1 to N with one missing
   */
  public static void betterSolution(int[] arr) {
    int n = arr[arr.length - 1];
    int[] hash = new int[n + 1];

    for (int i = 0; i < arr.length; i++) {
      hash[arr[i]] = 1;
    }

    for (int i = 1; i <= n; i++) {
      if (hash[i] == 0) {
        System.out.println(i);
      }
    }
  }

  /**
   * Optimal approach using the sum formula.
   * <p>
   * Uses the formula N*(N+1)/2 and subtracts
   * the sum of array elements.
   *
   * Time Complexity: O(N)
   * Space Complexity: O(1)
   *
   * @param arr sorted array containing numbers from 1 to N with one missing
   */
  public static void optimalSolution1(int[] arr) {
    int n = arr[arr.length - 1];
    int sum = n * (n + 1) / 2;
    int arrSum = 0;

    for (int i = 0; i < arr.length; i++) {
      arrSum += arr[i];
    }

    System.out.println(sum - arrSum);
  }

  /**
   * Optimal approach using XOR operation.
   * <p>
   * XOR of numbers from 1 to N and XOR of array elements
   * cancels out all duplicates, leaving the missing number.
   *
   * Time Complexity: O(N)
   * Space Complexity: O(1)
   *
   * @param arr sorted array containing numbers from 1 to N with one missing
   */
  public static void optimalSolution2(int[] arr) {
    int n = arr[arr.length - 1];

    int xor1 = 0;
    for (int i = 1; i <= n; i++) {
      xor1 = xor1 ^ i;
    }

    int xor2 = 0;
    for (int i = 0; i < arr.length; i++) {
      xor2 = xor2 ^ arr[i];
    }

    System.out.println(xor1 ^ xor2);
  }
}
