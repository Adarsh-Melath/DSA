package math;

public class CheckPalindrome {
    public static void main(String[] args) {
        int number = 121;

        int reverse = 0;
        int n = number;
        while (number > 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number /= 10;
        }

        if (n == reverse) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
