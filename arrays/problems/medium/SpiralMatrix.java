import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * This class demonstrates spiral traversal of a 2D matrix.
 * The matrix is traversed in clockwise spiral order starting
 * from the top-left corner and moving inward layer by layer.
 */
public class SpiralMatrix {

    /**
     * Entry point of the program.
     * Initializes a sample matrix and prints its spiral order traversal.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println(Arrays.toString(f(matrix).toArray()));
    }

    /**
     * Returns the spiral order traversal of the given matrix.
     *
     * The algorithm maintains four boundaries:
     * left, right, top, and bottom. In each iteration, it traverses:
     * 1. Top row from left to right
     * 2. Right column from top to bottom
     * 3. Bottom row from right to left (if applicable)
     * 4. Left column from bottom to top (if applicable)
     *
     * After each traversal, the corresponding boundary is adjusted
     * to move inward and avoid duplicate visits.
     *
     * @param matrix a 2D integer array to be traversed
     * @return a list containing elements in spiral order
     *
     *         Time Complexity: O(m × n), where m is the number of rows
     *         and n is the number of columns in the matrix.
     *
     *         Space Complexity: O(1) extra space, excluding the output list.
     */
    public static List<Integer> f(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0, right = col - 1;
        int top = 0, bottom = row - 1;

        List<Integer> ans = new ArrayList<>();

        while (left <= right && top <= bottom) {

            // Traverse top row
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // Traverse bottom row if still valid
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse left column if still valid
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}
