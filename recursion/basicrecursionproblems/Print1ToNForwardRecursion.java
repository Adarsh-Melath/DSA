/**
 * Program to print numbers from 1 to N using recursion.
 *
 * Approach:
 * - Start from 1 and print the number.
 * - Recursively call the function by incrementing the value.
 * - Stop when the current number becomes greater than N.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N) due to recursive call stack
 */
public class Print1ToNForwardRecursion {

  /**
   * Main method – program execution starts here.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    // Call recursive function to print numbers from 1 to 5
    f(1, 5);
  }

  /**
   * Recursive function to print numbers from 1 to N.
   *
   * @param i current number to be printed
   * @param n the maximum number
   */
  public static void f(int i, int n) {

    // Base condition to stop recursion
    if (i > n) {
      return;
    }

    // Print current number
    System.out.println(i);

    // Recursive call with incremented value
    f(i + 1, n);
  }
}
