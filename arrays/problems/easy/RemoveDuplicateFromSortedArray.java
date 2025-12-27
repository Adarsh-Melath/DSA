import java.util.HashSet;
import java.util.Set;

/**
 * Demonstrates two approaches to remove duplicates from a sorted integer array.
 * <p>
 * The array is modified in-place, and the methods return the count of unique
 * elements.
 * </p>
 */
public class RemoveDuplicateFromSortedArray {

  /**
   * Entry point of the program.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };

    // Uncomment to test brute force solution
    // System.out.println(bruteForceSolution(arr));

    System.out.println(optimalSolution(arr));
  }

  /**
   * Removes duplicates from a sorted array using a brute-force approach.
   * <p>
   * This method uses a {@link HashSet} to store unique elements, then copies
   * them back into the original array.
   * </p>
   *
   * @param arr the input sorted array
   * @return the number of unique elements in the array
   *
   * @implNote
   *           Time Complexity: O(n)
   *           Space Complexity: O(n)
   */
  public static int bruteForceSolution(int[] arr) {
    Set<Integer> nums = new HashSet<>();

    for (int num : arr) {
      nums.add(num);
    }

    int index = 0;
    for (int num : nums) {
      arr[index++] = num;
    }

    return nums.size();
  }

  /**
   * Removes duplicates from a sorted array using an optimal two-pointer approach.
   * <p>
   * The method modifies the array in-place without using extra space.
   * Only the first {@code k} elements (where {@code k} is the return value)
   * will contain the unique values.
   * </p>
   *
   * @param arr the input sorted array
   * @return the number of unique elements in the array
   *
   * @implNote
   *           Time Complexity: O(n)
   *           Space Complexity: O(1)
   */
  public static int optimalSolution(int[] arr) {
    int i = 0;

    for (int j = 1; j < arr.length; j++) {
      if (arr[i] != arr[j]) {
        arr[i + 1] = arr[j];
        i++;
      }
    }

    return i + 1;
  }
}
