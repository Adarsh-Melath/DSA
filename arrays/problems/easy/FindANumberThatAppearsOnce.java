import java.util.HashMap;
import java.util.Map;

/**
 * This class demonstrates three different approaches to find
 * the number that appears exactly once in an integer array
 * where all other numbers appear twice.
 */
public class FindANumberThatAppearsOnce {

  /**
   * Entry point of the program.
   * Tests all three approaches on a sample input array.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    int[] nums = { 1, 1, 2, 2, 3, 4, 4 };
    System.out.println(bruteForceSolution(nums));
    System.out.println(betterSolution(nums));
    System.out.println(optimalSolution(nums));
  }

  /**
   * Finds the unique element using a brute force approach.
   * For each element, it counts how many times it appears in the array.
   *
   * Time Complexity:
   * Best Case: O(n) when the unique element is found early
   * Average Case: O(n^2)
   * Worst Case: O(n^2)
   *
   * Space Complexity:
   * O(1)
   *
   * @param nums input array of integers
   * @return the element that appears only once
   */
  public static int bruteForceSolution(int[] nums) {
    int unique = 0;
    for (int i = 0; i < nums.length; i++) {
      int count = 1;
      for (int j = 0; j < nums.length; j++) {
        if (nums[i] == nums[j] && i != j) {
          count++;
        }
      }
      if (count == 1) {
        unique = nums[i];
        break;
      }
    }
    return unique;
  }

  /**
   * Finds the unique element using a HashMap to store frequencies.
   * Each number is mapped to the number of times it appears.
   *
   * Time Complexity:
   * Best Case: O(n)
   * Average Case: O(n)
   * Worst Case: O(n)
   *
   * Space Complexity:
   * O(n)
   *
   * @param nums input array of integers
   * @return the element that appears only once
   */
  public static int betterSolution(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    int unique = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        unique = entry.getKey();
        break;
      }
    }

    return unique;
  }

  /**
   * Finds the unique element using the XOR bitwise operation.
   * XOR of two equal numbers is 0, and XOR with 0 returns the number itself.
   *
   * Time Complexity:
   * Best Case: O(n)
   * Average Case: O(n)
   * Worst Case: O(n)
   *
   * Space Complexity:
   * O(1)
   *
   * @param nums input array of integers
   * @return the element that appears only once
   */
  public static int optimalSolution(int[] nums) {
    int xor = 0;
    for (int i = 0; i < nums.length; i++) {
      xor ^= nums[i];
    }
    return xor;
  }
}
