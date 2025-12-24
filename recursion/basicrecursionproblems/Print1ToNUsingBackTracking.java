/**
 * Program to print numbers from 1 to N using recursion with backtracking.
 *
 * Approach:
 * - Recursively call the function by decreasing N.
 * - Do not print before the recursive call.
 * - Print the number while returning (backtracking phase).
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N) due to recursive call stack
 */
public class Print1ToNUsingBackTracking {

  /**
   * Main method – program execution starts here.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    // Print numbers from 1 to 5 using backtracking
    f(5);
  }

  /**
   * Recursive function to print numbers from 1 to N using backtracking.
   *
   * @param n the current number
   */
  public static void f(int n) {

    // Base condition
    if (n == 0) {
      return;
    }

    // Recursive call
    f(n - 1);

    // Print during backtracking
    System.out.println(n);
  }
}
