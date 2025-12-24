/**
 * Program to calculate the factorial of a number using recursion.
 *
 * Approach:
 * - Factorial of n is defined as: n! = n × (n − 1)!
 * - Use recursion to multiply n with factorial of (n - 1).
 * - Stop recursion when n becomes 1 (base condition).
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N) due to recursive call stack
 */
public class Factorial {

  /**
   * Main method – program execution starts here.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {

    // Calculate factorial of 5
    int fact = f(5);

    // Print the result
    System.out.println(fact);
  }

  /**
   * Recursive function to calculate factorial of a number.
   *
   * @param n number whose factorial is to be calculated
   * @return factorial of the given number
   */
  public static int f(int n) {

    // Base condition
    if (n == 1) {
      return 1;
    }

    // Recursive call
    return n * f(n - 1);
  }
}
