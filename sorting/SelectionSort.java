package sorting;

import java.util.Arrays;

/**
 * SelectionSort class demonstrates the Selection Sort algorithm.
 *
 * Selection Sort works by repeatedly finding the minimum element
 * from the unsorted portion of the array and swapping it with
 * the first element of the unsorted portion.
 *
 * Time Complexity:
 * Best Case: O(n^2)
 * Average Case: O(n^2)
 * Worst Case: O(n^2)
 *
 * Space Complexity:
 * O(1) since the sorting is done in-place.
 */
public class SelectionSort {

  /**
   * The main method initializes an array, displays it before sorting,
   * applies selection sort, and then displays the sorted array.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {

    int[] arr = { 13, 46, 24, 52, 20, 9 };

    System.out.println("Before sorting: " + Arrays.toString(arr));
    f(arr, arr.length);
    System.out.println("After sorting: " + Arrays.toString(arr));
  }

  /**
   * Sorts the given array using the Selection Sort algorithm.
   *
   * The method selects the smallest element from the unsorted
   * part of the array and swaps it with the element at the
   * current index.
   *
   * @param arr the array to be sorted
   * @param n   the number of elements in the array
   */
  public static void f(int[] arr, int n) {

    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;

      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }

      int temp = arr[i];
      arr[i] = arr[minIndex];
      arr[minIndex] = temp;
    }
  }
}
