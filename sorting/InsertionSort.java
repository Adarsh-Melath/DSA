package sorting;

import java.util.Arrays;

/**
 * InsertionSort class demonstrates the Insertion Sort algorithm.
 *
 * Insertion Sort works by building a sorted portion of the array
 * one element at a time by inserting each element into its
 * correct position in the already sorted part.
 *
 * Time Complexity:
 * Best Case: O(n) when the array is already sorted
 * Average Case: O(n^2)
 * Worst Case: O(n^2) when the array is reverse sorted
 *
 * Space Complexity:
 * O(1) since sorting is done in-place.
 */
public class InsertionSort {

  /**
   * The main method initializes an array, displays it before sorting,
   * applies insertion sort, and displays the sorted array.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {

    int[] arr = { 5, 4, 3, 2, 1 };

    System.out.println("Before sorting: " + Arrays.toString(arr));
    f(arr);
    System.out.println("After sorting: " + Arrays.toString(arr));
  }

  /**
   * Sorts the given array using the Insertion Sort algorithm.
   *
   * The method repeatedly compares the current element with
   * the elements before it and shifts larger elements one
   * position to the right until the correct position is found.
   *
   * @param nums the array to be sorted
   */
  public static void f(int[] nums) {

    for (int i = 0; i < nums.length; i++) {
      int j = i;

      while (j > 0 && nums[j - 1] > nums[j]) {
        int temp = nums[j - 1];
        nums[j - 1] = nums[j];
        nums[j] = temp;
        j--;
      }
    }
  }
}
