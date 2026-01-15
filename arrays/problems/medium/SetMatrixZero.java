package arrays.problems.medium;

/**
 * This class provides three different approaches to solve
 * the Set Matrix Zero problem.
 *
 * Problem Statement:
 * Given a matrix, if an element is 0, set its entire row and column to 0.
 *
 * The modification must be done in-place.
 *
 * Example:
 * Input:
 * 1 1 1
 * 1 0 1
 * 1 1 1
 *
 * Output:
 * 1 0 1
 * 0 0 0
 * 1 0 1
 */
public class SetMatrixZero {

    /**
     * Main method to test different solutions.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

        // bruteForceSolution(matrix);
        // betterSolution(matrix);
        optimalSolution(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Optimal solution using the first row and first column as markers.
     *
     * A separate variable (col0) is used to track whether the first
     * column needs to be set to zero.
     *
     * This approach modifies the matrix in-place without using
     * extra space.
     *
     * @param matrix input 2D matrix
     *
     *               Time Complexity:
     *               O(n * m) — two passes over the matrix
     *
     *               Space Complexity:
     *               O(1) — constant extra space
     */
    public static void optimalSolution(int[][] matrix) {
        int col0 = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * Better solution using extra arrays to track rows and columns.
     *
     * Two auxiliary arrays are used:
     * - row[] to mark rows containing zero
     * - col[] to mark columns containing zero
     *
     * @param matrix input 2D matrix
     *
     *               Time Complexity:
     *               O(n * m)
     *
     *               Space Complexity:
     *               O(n + m) — extra arrays for rows and columns
     */
    public static void betterSolution(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Brute force solution using marking.
     *
     * When a zero is found, its entire row and column
     * are marked with -1 (temporary marker).
     * In the final pass, all -1 values are converted to 0.
     *
     * @param matrix input 2D matrix
     *
     *               Time Complexity:
     *               O((n * m) * (n + m)) — marking rows and columns repeatedly
     *
     *               Space Complexity:
     *               O(1) — no extra space used (modifies matrix in-place)
     */
    public static void bruteForceSolution(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, i);
                    markCol(matrix, j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Marks all non-zero elements in a given row as -1.
     *
     * @param matrix input matrix
     * @param i      row index to mark
     */
    public static void markRow(int[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    /**
     * Marks all non-zero elements in a given column as -1.
     *
     * @param matrix input matrix
     * @param j      column index to mark
     */
    public static void markCol(int[][] matrix, int j) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }
}
