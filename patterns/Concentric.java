public class Concentric {
    public static void main(String[] args) {
        int row = 5;
        for (int i = 1; i <= 2 * row - 1; i++) {
            for (int j = 1; j <= 2 * row - 1; j++) {
                int top = i;
                int left = j;
                int right = 2 * row - j;
                int bottom = 2 * row - i;

                System.out.print(row - Math.min(Math.min(top, bottom), Math.min(left, right))+1);
            }
            System.out.println();
        }
    }
}
