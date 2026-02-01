public class leftLadderAlpahbetIII {
    public static void main(String[] args) {
        int row = 5;
        // System.out.println((char) (64 + row));

        char ch = (char) (64 + row);
        for (int i = 1; i <= row; i++) {
            char ch2 = ch;
            for (int j = 1; j <= i; j++) {
                System.out.print(ch2++);
            }
            ch--;
            System.out.println();
        }
    }
}