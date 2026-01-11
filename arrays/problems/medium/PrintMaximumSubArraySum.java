package arrays.problems.medium;

import java.util.Arrays;

public class PrintMaximumSubArraySum {
    public static void main(String[] args) {
        int[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        int[] indices = kadanesAlgorithum(array);

        for (int i = indices[0]; i < indices[1] + 1; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] kadanesAlgorithum(int[] array) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxSumStart = -1;
        int maxSumEnd = -1;
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum == 0) {
                start = i;
            }
            sum += array[i];

            if (sum > maxSum) {
                maxSum = sum;
                maxSumStart = start;
                maxSumEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return new int[] { maxSumStart, maxSumEnd };
    }
}
