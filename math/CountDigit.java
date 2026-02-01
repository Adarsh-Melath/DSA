package math;

public class CountDigit {
    public static void main(String[] args) {
        int number = 1000;

        int count = 0;
        while (number > 0) {
            count++;
            number = number / 10;
        }

        System.out.println(count);
        number = 1000;
        System.out.println((int) Math.log10(number) + 1);
    }
}
