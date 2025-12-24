/**
 * Program to check if a given string is a valid palindrome.
 *
 * Problem Reference: LeetCode 125 - Valid Palindrome
 *
 * A valid palindrome considers only alphanumeric characters and ignores cases.
 *
 * Approach:
 * - Remove all non-alphanumeric characters and convert to lowercase.
 * - Use recursion to compare characters from both ends of the string.
 * - Stop when the start index crosses the middle.
 * - If any mismatch is found, return false.
 *
 * Time Complexity: O(N), where N is the length of the cleaned string
 * Space Complexity: O(N) due to recursion call stack
 */
public class ValidPalindrome {

  /**
   * Main method – program execution starts here.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {

    String string = "race a car";

    // Remove non-alphanumeric characters and convert to lowercase
    string = string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    // Check if the string is a valid palindrome
    System.out.println(f(string, 0));
  }

  /**
   * Recursive function to check if the string is a palindrome.
   *
   * @param string the cleaned string to be checked
   * @param i      current index from the start
   * @return true if the string is a palindrome, false otherwise
   */
  private static boolean f(String string, int i) {

    // Base condition: crossed the middle
    if (i > string.length() / 2) {
      return true;
    }

    // If characters at current positions do not match
    if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
      return false;
    }

    // Recursive call to check next pair
    return f(string, i + 1);
  }
}
