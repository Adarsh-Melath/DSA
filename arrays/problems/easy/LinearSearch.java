/**
 * Demonstrates linear search on an integer array.
 * Linear search checks each element sequentially until the target is found.
 */
public class LinearSearch {

  /**
   * Entry point of the program.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr = { 2, 3, 4, 5, 3 };
    int target = 3;

    System.out.println(f(arr, target));
  }

  /**
   * Searches for a target element in the given array using linear search.
   *
   * Example:
   * Input: arr = [2, 3, 4, 5, 3], target = 3
   * Output: 1
   *
   * @param arr    the array to search in
   * @param target the value to search for
   * @return the index of the target element if found, otherwise -1
   *
   *         Time Complexity: O(n)
   *         Space Complexity: O(1)
   */
  public static int f(int[] arr, int target) {
    int pos = -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        pos = i;
        break;
      }
    }

    return pos;
  }
}
