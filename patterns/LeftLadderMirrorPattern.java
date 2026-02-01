public class LeftLadderMirrorPattern {
    public static void main(String[] args) {
        int row = 4;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= 2 * row; j++) {
                if (j <= i || j >= 2 * row - i + 1) {
                    if (j <= i) {
                        System.out.print(j + " ");
                    } else {
                        System.out.print(2*row-(j)+1+" ");
                    }
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
