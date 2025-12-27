import java.util.Arrays;

/**
 * Demonstrates how to left-rotate an integer array by one position.
 * <p>
 * After rotation, each element is shifted one index to the left,
 * and the first element is moved to the end of the array.
 * </p>
 */
public class LeftRotateArraybyOne {

  /**
   * Entry point of the program.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };

    f(arr);

    System.out.println(Arrays.toString(arr));
  }

  /**
   * Left-rotates the given array by one position in-place.
   * <p>
   * Example:
   * 
   * <pre>
   * Input:  [1, 2, 3, 4, 5]
   * Output: [2, 3, 4, 5, 1]
   * </pre>
   * </p>
   *
   * @param arr the array to be rotated
   *
   * @implNote
   *           Time Complexity: O(n)
   *           Space Complexity: O(1)
   */
  public static void f(int[] arr) {
    int temp = arr[0];
    int i;

    for (i = 1; i < arr.length; i++) {
      arr[i - 1] = arr[i];
    }

    arr[i - 1] = temp;
  }
}
