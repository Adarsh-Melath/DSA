public class AlphabetPyramid {
    public static void main(String[] args) {
        int row = 5;
        for (int i = 1; i <= row; i++) {

            char ch = 'A';
            for (int j = 1; j <= row - i; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j < i) {

                    System.out.print(ch++ + " ");
                } else {
                    System.out.print(ch-- + " ");
                }
            }
            System.out.println();
        }
    }
}
