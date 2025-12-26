package sorting.sorting_2;

import java.util.Arrays;

/**
 * This class demonstrates Recursive Insertion Sort.
 * The array is sorted in ascending order using recursion
 * instead of the traditional iterative insertion sort.
 */
public class RecursiveInsertionSort {

  /**
   * The main method is the entry point of the program.
   * It initializes an array, sorts it using recursive insertion sort,
   * and prints the sorted result.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr = { 5, 4, 3, 2, 1 };

    f(arr, 0);
    System.out.println("After sorting: " + Arrays.toString(arr));
  }

  /**
   * Recursively sorts the array using the insertion sort technique.
   * At each recursive call, the element at index i is inserted
   * into its correct position in the already sorted left portion.
   *
   * @param arr the array to be sorted
   * @param i   the current index being processed
   */
  public static void f(int[] arr, int i) {

    /**
     * Base case:
     * If the index reaches the length of the array,
     * the array is fully sorted.
     */
    if (i > arr.length - 1) {
      return;
    }

    /**
     * j is used to shift the current element
     * leftward until it reaches its correct position.
     */
    int j = i;

    /**
     * Move the current element left while it is smaller
     * than the previous element.
     */
    while (j > 0 && arr[j - 1] > arr[j]) {
      int temp = arr[j];
      arr[j] = arr[j - 1];
      arr[j - 1] = temp;
      j--;
    }

    /**
     * Recursive call to sort the next index.
     */
    f(arr, i + 1);
  }
}
