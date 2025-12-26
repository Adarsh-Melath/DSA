package sorting.sorting_2;

import java.util.Arrays;

/**
 * RecursiveBubbleSort class demonstrates Bubble Sort implemented using
 * recursion.
 *
 * In each recursive call, the largest element of the unsorted portion of the
 * array
 * is moved to its correct position at the end. The recursion continues until
 * the entire array is sorted.
 *
 * Time Complexity:
 * Best Case: O(n^2)
 * Average Case: O(n^2)
 * Worst Case: O(n^2)
 *
 * Space Complexity:
 * O(n) due to recursive call stack.
 */
public class RecursiveBubbleSort {

  /**
   * The main method initializes an array, applies recursive bubble sort,
   * and prints the sorted array.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {

    int[] arr = { 5, 4, 3, 2, 1 };
    System.out.println("Before sorting: " + Arrays.toString(arr));
    f(arr, 0);
    System.out.println("Array after sorting: " + Arrays.toString(arr));
  }

  /**
   * Recursively sorts the given array using the Bubble Sort algorithm.
   *
   * Each call performs one pass over the unsorted portion of the array,
   * moving the largest element to its correct position, and then
   * recursively calls itself for the next pass.
   *
   * @param nums the array to be sorted
   * @param i    the current pass index
   */
  public static void f(int[] nums, int i) {

    if (i < nums.length - 1) {

      for (int j = 0; j < nums.length - i - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }

      f(nums, i + 1);
    }
  }
}
