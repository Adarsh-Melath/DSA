package arrays.problems.easy;

/**
 * This class demonstrates different approaches
 * to find the second largest element in an array.
 *
 * Approaches used:
 * 1. Brute force using sorting
 * 2. Better approach using single traversal
 */
public class SecondLargest {

  /**
   * The main method is the entry point of the program.
   * It initializes an array and prints the second largest
   * element using different approaches.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr = { 5, 4, 3, 2, 1 };

    System.out.println(bruteForceSoultion(arr));
    System.out.println(betterSolution(arr));
  }

  /**
   * Brute force solution to find the second largest element.
   * The array is sorted using Bubble Sort and the
   * second last element is returned.
   *
   * Time Complexity:
   * Best Case: O(n^2)
   * Average Case: O(n^2)
   * Worst Case: O(n^2)
   * - Bubble sort is used regardless of initial order.
   *
   * Space Complexity:
   * O(1)
   * - Sorting is done in-place.
   *
   * Note:
   * This method modifies the original array.
   *
   * @param arr the input array
   * @return the second largest element
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

    return arr[arr.length - 2];
  }

  /**
   * Better solution to find the second largest element.
   * The array is traversed once while keeping track of
   * the largest and second largest elements.
   *
   * Time Complexity:
   * Best Case: O(n)
   * Average Case: O(n)
   * Worst Case: O(n)
   * - Each element is visited exactly once.
   *
   * Space Complexity:
   * O(1)
   * - Uses only two variables.
   *
   * Edge Case:
   * If the array has fewer than two distinct elements,
   * the result may not be valid.
   *
   * @param arr the input array
   * @return the second largest element
   */
  public static int betterSolution(int[] arr) {

    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > largest) {
        secondLargest = largest;
        largest = arr[i];
      } else if (arr[i] > secondLargest && arr[i] != largest) {
        secondLargest = arr[i];
      }
    }

    return secondLargest;
  }
}
