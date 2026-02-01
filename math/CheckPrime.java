package math;

public class CheckPrime {
    public static void main(String[] args) {

        int n = 1;

        boolean isPrime = true;

        if (n < 2) {
            System.out.println("Not a Prime Number");
            return;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                isPrime = false;
            }
        }

        if (isPrime) {
            System.out.println("Prime Number");
        } else {
            System.out.println("Not a Prime Number");
        }
    }
}
