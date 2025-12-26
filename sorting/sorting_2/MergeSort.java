package sorting.sorting_2;

import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates the Merge Sort algorithm.
 * Merge Sort is a divide-and-conquer based sorting algorithm
 * that recursively divides the array and merges sorted halves.
 *
 * Time Complexity:
 * Best Case: O(n log n)
 * - Occurs when the array is already sorted.
 * - The array is still divided and merged at every level.
 *
 * Average Case: O(n log n)
 * - Occurs for random ordering of elements.
 *
 * Worst Case: O(n log n)
 * - Occurs when the array is sorted in reverse order.
 *
 * Space Complexity:
 * O(n)
 * - Extra space is required to store temporary arrays
 * during the merge process.
 * - Additionally, recursion uses O(log n) stack space.
 */
public class MergeSort {

  /**
   * The main method is the entry point of the program.
   * It initializes an array, sorts it using merge sort,
   * and prints the sorted array.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr = { 5, 4, 3, 2, 1 };
    f(arr, 0, arr.length - 1);
    System.out.println("After sorting: " + java.util.Arrays.toString(arr));
  }

  /**
   * Recursively divides the array into smaller subarrays
   * and sorts them using merge sort.
   *
   * @param arr  the array to be sorted
   * @param low  the starting index of the subarray
   * @param high the ending index of the subarray
   */
  public static void f(int[] arr, int low, int high) {

    /**
     * Base case:
     * When the subarray has one or zero elements,
     * it is already sorted.
     */
    if (low >= high) {
      return;
    }

    /**
     * Find the middle index to divide the array.
     */
    int mid = (low + high) / 2;

    /**
     * Recursively sort the left half.
     */
    f(arr, low, mid);

    /**
     * Recursively sort the right half.
     */
    f(arr, mid + 1, high);

    /**
     * Merge the two sorted halves.
     */
    merge(arr, low, mid, high);
  }

  /**
   * Merges two sorted subarrays into a single sorted range.
   * The first subarray is arr[low..mid]
   * The second subarray is arr[mid+1..high]
   *
   * @param arr  the original array
   * @param low  starting index of the first subarray
   * @param mid  ending index of the first subarray
   * @param high ending index of the second subarray
   */
  public static void merge(int[] arr, int low, int mid, int high) {

    /**
     * Temporary list to store merged elements.
     */
    List<Integer> list = new ArrayList<>();

    int left = low;
    int right = mid + 1;

    /**
     * Compare elements from both subarrays
     * and add the smaller one to the list.
     */
    while (left <= mid && right <= high) {
      if (arr[left] < arr[right]) {
        list.add(arr[left++]);
      } else {
        list.add(arr[right++]);
      }
    }

    /**
     * Add remaining elements from the left subarray.
     */
    while (left <= mid) {
      list.add(arr[left++]);
    }

    /**
     * Add remaining elements from the right subarray.
     */
    while (right <= high) {
      list.add(arr[right++]);
    }

    /**
     * Copy the merged elements back into the original array.
     */
    for (int i = low; i <= high; i++) {
      arr[i] = list.get(i - low);
    }
  }
}
