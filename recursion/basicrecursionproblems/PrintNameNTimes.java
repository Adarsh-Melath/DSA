/**
 * Problem: Print a name N times using recursion.
 *
 * This program demonstrates the use of recursion
 * to print a given name a specified number of times.
 * 
 * Time Complexity: O(N), we print our name exactly N times.
 * Space Complexity: O(N), stack space used for recursive calls.
 */
public class PrintNameNTimes {

  /**
   * Main method – program execution starts here.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    // Calling recursive function to print name
    f(1);
  }

  /**
   * Recursive function to print the name.
   *
   * @param n number of times the name should be printed
   */
  public static void f(int n) {

    // Base condition: stops recursion
    if (n < 1) {
      return;
    }

    // Print the name
    System.out.println("Adarsh");

    // Recursive call with reduced value
    f(n - 1);
  }
}
