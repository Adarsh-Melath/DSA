public class Diamond {
    public static void main(String[] args) {
        int row = 5;

        for(int i=1;i<=2*row;i++)
        {
            int space = i <= row ? row - i + 1 : i - row;
            int stars = i <= row?2*i-1:2*(2*row-i)+1;

            for(int j=1;j<=space;j++)
            {
                System.out.print("  ");
            }

            for(int j=1;j<=stars;j++)
            {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
