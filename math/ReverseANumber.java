package math;

public class ReverseANumber {
    public static void main(String[] args) {
        int number = 123;

        int reverse = 0;
        while (number > 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number /= 10;
        }

        System.out.println(reverse);
    }
}
