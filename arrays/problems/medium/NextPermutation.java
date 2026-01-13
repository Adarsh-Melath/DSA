package arrays.problems.medium;

import java.util.Arrays;

/**
 * Provides an implementation to compute the next
 * lexicographical permutation of an integer array.
 */
public class NextPermutation {

    /**
     * Entry point of the program.
     * Initializes an array, computes its next permutation,
     * and prints the result.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };

        int[] nxtPermutation = nextPermutation(arr);
        System.out.println(Arrays.toString(nxtPermutation));
    }

    /**
     * Generates the next lexicographical permutation
     * of the given array.
     *
     * If the array is in descending order, the method
     * reverses it to return the smallest permutation.
     *
     * Steps involved:
     * 1. Find the first index from the right where
     * arr[i] is smaller than arr[i + 1].
     * 2. If no such index exists, reverse the entire array.
     * 3. Find the smallest element greater than arr[index]
     * on the right side and swap them.
     * 4. Reverse the subarray after the index to get
     * the next permutation.
     *
     * @param arr the input array of integers
     * @return the next lexicographical permutation
     */
    public static int[] nextPermutation(int[] arr) {
        int n = arr.length;
        int index = -1;

        // Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                index = i;
                break;
            }
        }

        // If the array is in descending order
        if (index == -1) {
            reverse(arr, 0, n - 1);
            return arr;
        }

        // Find the next greater element and swap
        for (int i = n - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }

        // Reverse the elements after the index
        reverse(arr, index + 1, n - 1);

        return arr;
    }

    /**
     * Reverses the elements of the array
     * between the specified start and end indices.
     *
     * @param arr   the array to be reversed
     * @param start the starting index
     * @param end   the ending index
     */
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
