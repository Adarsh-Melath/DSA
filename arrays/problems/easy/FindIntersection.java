import java.util.Arrays;
import java.util.List;

/**
 * FindIntersection demonstrates two approaches to find the intersection
 * of two sorted arrays.
 *
 * The intersection contains elements that appear in both arrays.
 */
public class FindIntersection {

  /**
   * Entry point of the program.
   *
   * Creates two sorted arrays and prints their intersection
   * using the brute-force approach.
   *
   * Time Complexity:
   * Best Case: O(n1)
   * Average Case: O(n1 * n2)
   * Worst Case: O(n1 * n2)
   *
   * Space Complexity:
   * O(n2) for the visited array and O(k) for the intersection list
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] arr1 = { 1, 2, 3, 4, 5, 6 };
    int[] arr2 = { 3, 4, 5, 6, 7 };

    System.out.println(Arrays.toString(bruteForceSolution(arr1, arr2).toArray()));
    // System.out.println(Arrays.toString(optimalSolution(arr1, arr2).toArray()));
  }

  /**
   * Finds the intersection of two sorted arrays using a brute-force approach.
   *
   * Uses an auxiliary visited array to ensure elements from the second array
   * are not reused.
   *
   * Assumption:
   * Both input arrays are sorted.
   *
   * Time Complexity:
   * Best Case: O(n1) when early breaks occur
   * Average Case: O(n1 * n2)
   * Worst Case: O(n1 * n2)
   *
   * Space Complexity:
   * O(n2) for the visited array and O(k) for the result list
   *
   * @param arr1 first sorted input array
   * @param arr2 second sorted input array
   * @return a list containing the intersection of arr1 and arr2
   */
  public static List<Integer> bruteForceSolution(int[] arr1, int[] arr2) {
    int n1 = arr1.length;
    int n2 = arr2.length;

    int[] visited = new int[n2];
    List<Integer> intersection = new java.util.ArrayList<>();

    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < n2; j++) {
        if (arr1[i] == arr2[j] && visited[j] == 0) {
          intersection.add(arr1[i]);
          visited[j] = 1;
          break;
        }
        if (arr1[i] < arr2[j]) {
          break;
        }
      }
    }
    return intersection;
  }

  /**
   * Finds the intersection of two sorted arrays using the two-pointer technique.
   *
   * Traverses both arrays simultaneously to identify common elements.
   *
   * Assumption:
   * Both input arrays are sorted.
   *
   * Time Complexity:
   * Best Case: O(min(n1, n2))
   * Average Case: O(n1 + n2)
   * Worst Case: O(n1 + n2)
   *
   * Space Complexity:
   * O(k) where k is the number of intersecting elements
   *
   * @param arr1 first sorted input array
   * @param arr2 second sorted input array
   * @return a list containing the intersection of arr1 and arr2
   */
  public static List<Integer> optimalSolution(int[] arr1, int[] arr2) {
    List<Integer> intersection = new java.util.ArrayList<>();

    int i = 0;
    int j = 0;

    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] < arr2[j]) {
        i++;
      } else if (arr1[i] < arr2[j]) {
        j++;
      } else {
        intersection.add(arr1[i]);
        i++;
        j++;
      }
    }
    return intersection;
  }
}
