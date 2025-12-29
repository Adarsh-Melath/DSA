import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

/**
 * FindUnion demonstrates two approaches to find the union of two sorted arrays.
 * The union contains unique elements while preserving sorted order.
 */
public class FindUnion {

  /**
   * Entry point of the program.
   *
   * Creates two sorted arrays and prints their union using the optimal approach.
   *
   * Time Complexity:
   * Best Case: O(n1 + n2)
   * Average Case: O(n1 + n2)
   * Worst Case: O(n1 + n2)
   *
   * Space Complexity:
   * O(n1 + n2) for storing the union
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr1 = { 1, 2, 3, 4, 5, 6 };
    int[] arr2 = { 2, 3, 4, 4, 5, 11, 12 };

    // System.out.println(Arrays.toString(bruteForceSolution(arr1, arr2)));
    System.out.println(Arrays.toString(optimalSolution(arr1, arr2)));
  }

  /**
   * Finds the union of two arrays using a brute-force approach with a
   * LinkedHashSet.
   * Maintains insertion order and removes duplicates automatically.
   *
   * Time Complexity:
   * Best Case: O(n1 + n2)
   * Average Case: O(n1 + n2)
   * Worst Case: O(n1 + n2)
   *
   * Space Complexity:
   * O(n1 + n2) due to the set and result array
   *
   * @param arr1 first input array
   * @param arr2 second input array
   * @return an array containing the union of arr1 and arr2
   */
  public static int[] bruteForceSolution(int[] arr1, int[] arr2) {
    Set<Integer> set = new LinkedHashSet<>();

    for (int i : arr1) {
      set.add(i);
    }

    for (int i : arr2) {
      set.add(i);
    }

    int index = 0;
    int[] union = new int[set.size()];
    for (int i : set) {
      union[index++] = i;
    }

    return union;
  }

  /**
   * Finds the union of two sorted arrays using the two-pointer technique.
   * Avoids extra data structures for duplicate checking.
   *
   * Assumption:
   * Both input arrays are sorted.
   *
   * Time Complexity:
   * Best Case: O(n1 + n2)
   * Average Case: O(n1 + n2)
   * Worst Case: O(n1 + n2)
   *
   * Space Complexity:
   * O(n1 + n2) for the result list
   *
   * @param arr1 first sorted input array
   * @param arr2 second sorted input array
   * @return an Object array containing the union of arr1 and arr2
   */
  public static Object[] optimalSolution(int[] arr1, int[] arr2) {
    int n1 = arr1.length;
    int n2 = arr2.length;
    int i = 0;
    int j = 0;

    List<Integer> union = new ArrayList<>();

    while (i < n1 && j < n2) {
      if (arr1[i] < arr2[j]) {
        if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
          union.add(arr1[i]);
        }
        i++;
      } else {
        if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
          union.add(arr2[j]);
        }
        j++;
      }
    }

    while (i < n1) {
      if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
        union.add(arr1[i]);
      }
      i++;
    }

    while (j < n2) {
      if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
        union.add(arr2[j]);
      }
      j++;
    }

    return union.toArray();
  }
}
