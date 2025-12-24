/**
 * Program to print numbers from N to 1 using forward recursion.
 *
 * Approach:
 * - Print the current number first.
 * - Recursively call the function with (n - 1).
 * - Stop when n becomes less than 1.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N) due to recursive call stack
 */
public class PrintNTo1UsingForwardRecursion {

  /**
   * Main method – program execution starts here.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    // Print numbers from 5 to 1
    f(5);
  }

  /**
   * Recursive function to print numbers from N to 1.
   *
   * @param n current number to be printed
   */
  public static void f(int n) {

    // Base condition to stop recursion
    if (n < 1) {
      return;
    }

    // Print current number
    System.out.println(n);

    // Recursive call with reduced value
    f(n - 1);
  }
}
