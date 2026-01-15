/**
 * This class provides solutions to rotate a square matrix
 * by 90 degrees clockwise.
 *
 * Example:
 * Input:
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * Output:
 * 7 4 1
 * 8 5 2
 * 9 6 3
 */
class RotateTheArrayBy90Degree {

    /**
     * Main method to test matrix rotation.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // int[][] ans = bruteForce(arr);
        int[][] ans = optimal(arr);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Brute force approach to rotate the matrix by 90 degrees clockwise.
     *
     * A new matrix is created and elements are placed
     * at their rotated positions.
     *
     * @param arr input square matrix
     * @return new rotated matrix
     *
     *         Time Complexity:
     *         O(n^2) — each element is visited once
     *
     *         Space Complexity:
     *         O(n^2) — extra matrix is used
     */
    public static int[][] bruteForce(int[][] arr) {
        int[][] ans = new int[arr.length][arr[0].length];
        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[j][row - i - 1] = arr[i][j];
            }
        }

        return ans;
    }

    /**
     * Optimal approach to rotate the matrix by 90 degrees clockwise.
     *
     * Step 1: Transpose the matrix (swap elements across the diagonal).
     * Step 2: Reverse each row of the transposed matrix.
     *
     * The rotation is done in-place without using extra space.
     *
     * @param arr input square matrix
     * @return rotated matrix
     *
     *         Time Complexity:
     *         O(n^2) — transpose + row reversal
     *
     *         Space Complexity:
     *         O(1) — in-place modification
     */
    public static int[][] optimal(int[][] arr) {

        // Transpose the matrix
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr.length - 1 - j];
                arr[i][arr.length - 1 - j] = temp;
            }
        }

        return arr;
    }
}
