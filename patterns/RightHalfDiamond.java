public class RightHalfDiamond {
    public static void main(String[] args) {
        int row = 5;
        for (int i = 0; i <= 2 * row - 1; i++) {
            int stars = i <= row ? i : 2 * row - i;
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
