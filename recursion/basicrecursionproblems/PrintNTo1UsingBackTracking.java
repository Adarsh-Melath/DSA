/**
 * Program to print numbers from N to 1 using recursion with backtracking.
 *
 * Approach:
 * - Start recursion from 1 and go till N.
 * - Do not print before the recursive call.
 * - Print the value while returning (backtracking phase).
 * - This results in numbers being printed from N to 1.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N) due to recursive call stack
 */
public class PrintNTo1UsingBackTracking {

  /**
   * Main method – program execution starts here.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    // Print numbers from 5 to 1 using backtracking
    f(1, 5);
  }

  /**
   * Recursive function to print numbers from N to 1 using backtracking.
   *
   * @param i current number
   * @param n maximum number
   */
  public static void f(int i, int n) {

    // Base condition
    if (i > n) {
      return;
    }

    // Recursive call
    f(i + 1, n);

    // Print during backtracking
    System.out.println(i);
  }
}
