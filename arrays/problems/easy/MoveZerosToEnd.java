import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates how to move all zeros in an array to the end
 * while maintaining the relative order of non-zero elements.
 */
public class MoveZerosToEnd {

  /**
   * Entry point of the program.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };

    // bruteForceSolution(arr);
    optimalSolution(arr);

    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  /**
   * Moves all zeros to the end of the array using a brute-force approach.
   * The relative order of non-zero elements is preserved.
   *
   * Example:
   * Input: [1, 0, 2, 3, 0, 4]
   * Output: [1, 2, 3, 4, 0, 0]
   *
   * @param arr the input array
   *
   *            Time Complexity: O(n)
   *            Space Complexity: O(n)
   */
  public static void bruteForceSolution(int[] arr) {
    List<Integer> nums = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        nums.add(arr[i]);
      }
    }

    for (int i = 0; i < nums.size(); i++) {
      arr[i] = nums.get(i);
    }

    for (int i = nums.size(); i < arr.length; i++) {
      arr[i] = 0;
    }
  }

  /**
   * Moves all zeros to the end of the array using an optimal two-pointer
   * approach.
   * The array is modified in-place and the relative order of non-zero elements is
   * preserved.
   *
   * Example:
   * Input: [1, 0, 2, 3, 0, 4]
   * Output: [1, 2, 3, 4, 0, 0]
   *
   * @param arr the input array
   *
   *            Time Complexity: O(n)
   *            Space Complexity: O(1)
   */
  public static void optimalSolution(int[] arr) {
    int j = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j++;
      }
    }
  }
}
