package sorting;

import java.util.Arrays;

/**
 * BubbleSort class demonstrates the optimized Bubble Sort algorithm.
 *
 * This version uses a swap flag to stop the algorithm early
 * if the array becomes sorted before completing all passes.
 *
 * Time Complexity:
 * Best Case: O(n) when the array is already sorted
 * Average Case: O(n^2)
 * Worst Case: O(n^2) when the array is reverse sorted
 *
 * Space Complexity:
 * O(1) since sorting is performed in-place.
 */
public class BubbleSort {

  /**
   * The main method initializes an array, displays it before sorting,
   * applies the optimized bubble sort, and displays the sorted array.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {

    int[] nums = { 5, 4, 3, 2, 1 };

    System.out.println("Before sorting: " + Arrays.toString(nums));
    f(nums);
    System.out.println("After sorting: " + Arrays.toString(nums));
  }

  /**
   * Sorts the given array using the optimized Bubble Sort algorithm.
   *
   * The method compares adjacent elements and swaps them if they
   * are in the wrong order. If no swaps occur during a pass,
   * the algorithm terminates early.
   *
   * @param nums the array to be sorted
   */
  public static void f(int[] nums) {

    for (int i = 0; i < nums.length-1; i++) {
      boolean swapped = false;

      for (int j = 0; j < nums.length - 1 - i; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
          swapped = true;
        }
      }

      if (!swapped) {
        break;
      }
    }
  }
}
