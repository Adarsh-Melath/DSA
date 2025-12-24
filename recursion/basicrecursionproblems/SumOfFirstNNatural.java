/**
 * Program to calculate the sum of first N natural numbers
 * using recursion.
 *
 * Two approaches are demonstrated:
 * 1. Parameterized recursion
 * 2. Functional recursion
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N) due to recursive call stack
 */
public class SumOfFirstNNatural {

  /**
   * Main method – program execution starts here.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {

    // Parameterized recursion approach
    f1(5, 0);

    // Functional recursion approach
    System.out.println(f2(5));
  }

  /**
   * Recursive function to calculate sum of first N natural numbers
   * using parameterized recursion.
   *
   * @param n   current number
   * @param sum accumulated sum
   */
  public static void f1(int n, int sum) {

    // Base condition
    if (n < 1) {
      System.out.println(sum);
      return;
    }

    // Recursive call with updated parameters
    f1(n - 1, sum + n);
  }

  /**
   * Recursive function to calculate sum of first N natural numbers
   * using functional recursion.
   *
   * @param n current number
   * @return sum of first N natural numbers
   */
  public static int f2(int n) {

    // Base condition
    if (n == 1) {
      return 1;
    }

    // Recursive call
    return n + f2(n - 1);
  }
}
