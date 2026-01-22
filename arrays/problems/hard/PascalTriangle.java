package arrays.problems.hard;

public class PascalTriangle {

    public static void main(String[] args) {
        int r = 5;
        int c = 3;

        System.out.println(RCC(r, c));
    }

    public static int RCC(int r, int c) {

        int n = r - 1;
        int k = c - 1;

        int result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;

    }
}
