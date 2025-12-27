
/**
 * This class demonstrates different approaches
 * to find the largest element in an array.
 *
 * Approaches used:
 * 1. Brute force using sorting
 * 2. Better approach using linear traversal
 */
public class LargestElement {

  /**
   * The main method is the entry point of the program.
   * It initializes an array and prints the largest element
   * using different approaches.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    // Sorting-based solution
    System.out.println(bruteForceSoultion(arr));

    // Linear traversal solution
    System.out.println(betterSolution(arr));
  }

  /**
   * Brute force solution to find the largest element.
   * The array is sorted using Bubble Sort and the
   * last element is returned as the largest.
   *
   * Time Complexity:
   * Best Case: O(n^2)
   * Average Case: O(n^2)
   * Worst Case: O(n^2)
   * - Bubble sort is used regardless of initial order.
   *
   * Space Complexity:
   * O(1)
   * - Sorting is done in-place without extra memory.
   *
   * Note:
   * This method modifies the original array.
   *
   * @param arr the input array
   * @return the largest element in the array
   */
  public static int bruteForceSoultion(int[] arr) {

    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }

    return arr[arr.length - 1];
  }

  /**
   * Better solution to find the largest element.
   * The array is traversed once while keeping
   * track of the maximum value found.
   *
   * Time Complexity:
   * Best Case: O(n)
   * Average Case: O(n)
   * Worst Case: O(n)
   * - Each element is visited exactly once.
   *
   * Space Complexity:
   * O(1)
   * - Uses a single variable to store the maximum value.
   *
   * @param arr the input array
   * @return the largest element in the array
   */
  public static int betterSolution(int[] arr) {

    int largest = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > largest) {
        largest = arr[i];
      }
    }

    return largest;
  }
}
