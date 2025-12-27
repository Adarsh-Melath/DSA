/**
 * Demonstrates right rotation of an array by k positions
 * using both brute-force and optimal approaches.
 */
public class RightRotateArrayByK {

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

    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  /**
   * Rotates the array to the right by k positions using a brute-force approach.
   * The array is modified in-place.
   *
   * Example:
   * Input: [1, 2, 3, 4, 5], k = 2
   * Output: [4, 5, 1, 2, 3]
   *
   * @param arr the array to rotate
   * @param k   number of positions to rotate
   *
   *            Time Complexity: O(n × k)
   *            Space Complexity: O(1)
   */
  public static void bruteForceSolution(int[] arr, int k) {
    int n = arr.length;
    k = k % n;

    for (int i = 0; i < k; i++) {
      int last = arr[n - 1];

      for (int j = n - 1; j > 0; j--) {
        arr[j] = arr[j - 1];
      }

      arr[0] = last;
    }
  }

  /**
   * Rotates the array to the right by k positions using the optimal reversal
   * algorithm.
   * The array is modified in-place.
   *
   * Example:
   * Input: [1, 2, 3, 4, 5, 6, 7], k = 3
   * Output: [5, 6, 7, 1, 2, 3, 4]
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

    reverse(arr, 0, n - 1);
    reverse(arr, 0, k - 1);
    reverse(arr, k, n - 1);
  }

  /**
   * Reverses elements of the array between indices s and e.
   *
   * @param arr the array
   * @param s   starting index
   * @param e   ending index
   *
   *            Time Complexity: O(n)
   *            Space Complexity: O(1)
   */
  public static void reverse(int[] arr, int s, int e) {
    while (s <= e) {
      int temp = arr[s];
      arr[s] = arr[e];
      arr[e] = temp;
      s++;
      e--;
    }
  }
}
