/**
 * Demonstrates left rotation of an array by k positions
 * using both brute-force and optimal approaches.
 */
public class LeftRotateanArrayByKPlace {

  /**
   * Entry point of the program.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
    int k = 3;

    // bruteForceSolution(arr, k);
    optimalSolution(arr, k);

    System.out.println("After rotating the array: ");
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  /**
   * Rotates the array to the left by k positions using a brute-force approach.
   * The array is modified in-place.
   *
   * Example:
   * Input: [1, 2, 3, 4, 5], k = 2
   * Output: [3, 4, 5, 1, 2]
   *
   * @param arr the array to rotate
   * @param k   number of positions to rotate
   *
   *            Time Complexity: O(n × k)
   *            Space Complexity: O(1)
   */
  public static void bruteForceSolution(int[] arr, int k) {
    for (int i = 0; i < k; i++) {
      int temp = arr[0];

      for (int j = 1; j < arr.length; j++) {
        arr[j - 1] = arr[j];
      }

      arr[arr.length - 1] = temp;
    }
  }

  /**
   * Rotates the array to the left by k positions using the optimal reversal
   * algorithm.
   * The array is modified in-place.
   *
   * Example:
   * Input: [1, 2, 3, 4, 5, 6, 7], k = 3
   * Output: [4, 5, 6, 7, 1, 2, 3]
   *
   * @param arr the array to rotate
   * @param k   number of positions to rotate
   *
   *            Time Complexity: O(n)
   *            Space Complexity: O(1)
   */
  public static void optimalSolution(int[] arr, int k) {
    int n = arr.length;
    k = k % n;

    reverse(arr, 0, k - 1);
    reverse(arr, k, n - 1);
    reverse(arr, 0, n - 1);
  }

  /**
   * Reverses elements of the array between the given indices.
   *
   * @param arr   the array
   * @param start starting index
   * @param end   ending index
   *
   *              Time Complexity: O(n)
   *              Space Complexity: O(1)
   */
  public static void reverse(int[] arr, int start, int end) {
    while (start <= end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
}
