public class Butterfly {
    public static void main(String[] args) {
        int row = 5;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= 2 * row; j++) {
                if (j <= i || j >= 2 * row - i + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = row - 1;i>=1; i--) {
            for (int j = 1; j <= 2 * row; j++) {
                if (j <= i || j >= 2 * row - i + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
