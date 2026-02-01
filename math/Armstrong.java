package math;

public class Armstrong {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(checkArmstrong(n));
    }

    public static boolean checkArmstrong(int n) {

        int numberOfDigits = (int) Math.log10(n) + 1;
        int sum = 0;
        int number = n;
        while (number > 0) {
            int remainder = number % 10;
            sum += (int) Math.pow(remainder, numberOfDigits);
            number /= 10;
        }
        if (n == sum) {
            return true;
        }
        return false;
    }
}
