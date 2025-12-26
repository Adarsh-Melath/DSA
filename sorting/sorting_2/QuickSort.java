package sorting.sorting_2;

import java.util.Arrays;

/**
 * This class demonstrates the Quick Sort algorithm.
 * Quick Sort is a divide-and-conquer sorting algorithm
 * that selects a pivot element and partitions the array
 * around the pivot.
 *
 * Time Complexity:
 * Best Case: O(n log n)
 * - Occurs when the pivot divides the array into two
 * nearly equal halves at every step.
 *
 * Average Case: O(n log n)
 * - Occurs for random distribution of elements.
 *
 * Worst Case: O(n^2)
 * - Occurs when the pivot is always the smallest or
 * largest element (e.g., already sorted or reverse
 * sorted array when using the first element as pivot).
 *
 * Space Complexity:
 * O(log n)
 * - Due to recursive call stack in best and average cases.
 *
 * Worst Case Space Complexity:
 * O(n)
 * - When recursion becomes skewed (worst-case partitioning).
 */
public class QuickSort {

  /**
   * The main method is the entry point of the program.
   * It initializes an array, sorts it using quick sort,
   * and prints the sorted array.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr = { 5, 4, 3, 2, 1 };

    f(arr, 0, arr.length - 1);
    System.out.println("After Sorting" + Arrays.toString(arr));
  }

  /**
   * Recursively applies quick sort to the array.
   * It partitions the array and sorts the left
   * and right subarrays.
   *
   * @param arr  the array to be sorted
   * @param low  starting index of the subarray
   * @param high ending index of the subarray
   */
  public static void f(int[] arr, int low, int high) {

    /**
     * Base condition:
     * Sort only when the subarray has more than one element.
     */
    if (low < high) {
      int partition = findPartition(arr, low, high);

      /**
       * Recursively sort elements before the pivot.
       */
      f(arr, low, partition - 1);

      /**
       * Recursively sort elements after the pivot.
       */
      f(arr, partition + 1, high);
    }
  }

  /**
   * Partitions the array using the first element as pivot.
   * Elements smaller than or equal to the pivot are placed
   * on the left, and larger elements on the right.
   *
   * @param arr  the array to be partitioned
   * @param low  starting index
   * @param high ending index
   * @return the final index position of the pivot
   */
  public static int findPartition(int[] arr, int low, int high) {

    /**
     * Choose the first element as pivot.
     */
    int pivot = arr[low];
    int i = low;
    int j = high;

    /**
     * Rearrange elements based on pivot comparison.
     */
    while (i < j) {

      while (arr[i] <= pivot && i <= high - 1) {
        i++;
      }

      while (arr[j] > pivot && j >= low + 1) {
        j--;
      }

      if (i < j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    /**
     * Place pivot in its correct sorted position.
     */
    int temp = arr[low];
    arr[low] = arr[j];
    arr[j] = temp;

    return j;
  }
}
