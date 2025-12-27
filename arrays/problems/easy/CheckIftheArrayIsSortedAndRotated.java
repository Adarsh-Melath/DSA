
/**
 * This class checks whether an array is sorted
 * in non-decreasing order and then rotated.
 *
 * This problem is commonly asked on LeetCode.
 *
 * The approach counts how many times the order
 * breaks in the array. If the count is more than 1,
 * the array is neither sorted nor sorted-rotated.
 */
public class CheckIftheArrayIsSortedAndRotated {

  /**
   * The main method is the entry point of the program.
   * It initializes an array and prints whether the array
   * is sorted and rotated.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr = { 0, 4, 5, 1, 2 };
    System.out.println(f(arr));
  }

  /**
   * Checks if the given array is sorted and rotated.
   *
   * Logic:
   * Count the number of places where the order breaks
   * (i.e., arr[i-1] > arr[i]).
   *
   * For a sorted and rotated array:
   * - There can be at most one such break.
   * - Additionally, the last element should not be
   * greater than the first element after rotation.
   *
   * Time Complexity:
   * O(n)
   * - The array is traversed once.
   *
   * Space Complexity:
   * O(1)
   * - Uses constant extra space.
   *
   * @param arr the input array
   * @return true if the array is sorted and rotated, otherwise false
   */
  public static boolean f(int[] arr) {

    int n = arr.length;
    int count = 0;

    /**
     * Count the number of order violations.
     */
    for (int i = 1; i < n; i++) {
      if (arr[i - 1] > arr[i]) {
        count++;
      }
    }

    /**
     * Check the rotation point between last and first element.
     */
    if (arr[n - 1] > arr[0]) {
      count++;
    }

    /**
     * Valid if there is at most one break.
     */
    return count <= 1;
  }
}
