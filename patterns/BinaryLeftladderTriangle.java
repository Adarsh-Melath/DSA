public class BinaryLeftladderTriangle {
    public static void main(String[] args) {
        int row = 5;

        int number = 1;
        for (int i = 1; i <= row; i++) {
            if (i % 2 == 0) {
                number = 0;
            } else {
                number = 1;
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(number);
                number = number == 1 ? 0 : 1;
            }
            System.out.println();
        }
    }
}
