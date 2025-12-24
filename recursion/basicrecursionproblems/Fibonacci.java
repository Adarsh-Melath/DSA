/**
 * Program to find the Nth Fibonacci number using recursion.
 *
 * Fibonacci Series:
 * 0, 1, 1, 2, 3, 5, 8, ...
 *
 * Approach:
 * - If n is 0 or 1, return n (base cases).
 * - Otherwise, recursively calculate:
 * f(n) = f(n - 1) + f(n - 2)
 *
 * Time Complexity: O(2^N) – exponential due to overlapping subproblems
 * Space Complexity: O(N) due to recursive call stack
 * Reference: LeetCode Problem 509 - Fibonacci Number
 */
public class Fibonacci {

  /**
   * Main method – program execution starts here.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    // Print the 4th Fibonacci number
    System.out.println(f(4));
  }

  /**
   * Recursive function to calculate the Nth Fibonacci number.
   *
   * @param n position in the Fibonacci series (0-indexed)
   * @return Nth Fibonacci number
   */
  public static int f(int n) {
    // Base cases
    if (n <= 1) {
      return n;
    }

    // Recursive calls
    return f(n - 1) + f(n - 2);
  }
}
