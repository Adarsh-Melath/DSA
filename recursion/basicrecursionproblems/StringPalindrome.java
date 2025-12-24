/**
 * Program to check if a given string is a palindrome using recursion.
 *
 * A palindrome is a string that reads the same forwards and backwards.
 *
 * Approach:
 * - Compare the characters at start and end indices.
 * - If they are equal, recursively check the next inner pair.
 * - Stop when the start index crosses the middle.
 * - If any pair does not match, return false.
 *
 * Time Complexity: O(N), where N is the length of the string
 * Space Complexity: O(N) due to recursive call stack
 */
public class StringPalindrome {

  /**
   * Main method – program execution starts here.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {

    String string = "adarsh";

    // Check if the string is a palindrome
    System.out.println(f(string, 0, string.length()));
  }

  /**
   * Recursive function to check if a string is a palindrome.
   *
   * @param string the string to be checked
   * @param i      current starting index
   * @param n      length of the string
   * @return true if the string is a palindrome, false otherwise
   */
  public static boolean f(String string, int i, int n) {

    // Base condition: crossed the middle
    if (i > n / 2) {
      return true;
    }

    // If characters at current positions do not match
    if (string.charAt(i) != string.charAt(n - i - 1)) {
      return false;
    }

    // Recursive call to check next pair
    return f(string, i + 1, n);
  }
}
