public class InvertedLeftLadderAlphabet {
    public static void main(String[] args) {
        int row = 5;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row - i + 1; j++) {
                System.out.print((char) (64 + j) + " ");
            }
            System.out.println();
        }
    }
}
