package math;

public class GCD {
    public static void main(String[] args) {
        int number1 = 12;
        int number2 = 18;

        System.out.println("GCD of " + number1 + " and " + number2 + " is: " + gcdBruteForce(number1, number2));
    }

    public static int gcdBruteForce(int number1, int number2) {
        int gcd = 1;
        for (int i = Math.min(number1, number2); i >= 1; i--) {
            if (number1 % i == 0 && number2 % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }
}
