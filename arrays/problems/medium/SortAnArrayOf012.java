package arrays.problems.medium;

/**
 * This class demonstrates three different approaches to sort
 * an array containing only 0s, 1s, and 2s.
 *
 * The problem is a classic variant of the Dutch National Flag problem.
 *
 * Approaches covered:
 * 1. Brute force using selection sort
 * 2. Better approach using counting
 * 3. Optimal approach using three pointers
 *
 * Time and space complexities vary per approach and are documented
 * at the method level.
 */
public class SortAnArrayOf012 {

    /**
     * Entry point of the program.
     *
     * Creates an array containing 0s, 1s, and 2s,
     * applies the optimal sorting solution,
     * and prints the sorted array.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 0, 1, 2, 1, 0 };

        // bruteForceSolution(arr);
        // betterSolution(arr);
        optimalSolution(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /**
     * Brute force solution using selection sort.
     *
     * The array is sorted by repeatedly finding the minimum
     * element from the unsorted portion and swapping it.
     *
     * Time Complexity:
     * O(n^2)
     *
     * Space Complexity:
     * O(1)
     *
     * @param arr the input array containing 0s, 1s, and 2s
     */
    public static void bruteForceSolution(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * Better solution using counting technique.
     *
     * Counts the number of 0s, 1s, and 2s,
     * then overwrites the array in sorted order.
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(1)
     *
     * @param arr the input array containing 0s, 1s, and 2s
     */
    public static void betterSolution(int[] arr) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }

        for (int i = count0; i < count0 + count1; i++) {
            arr[i] = 1;
        }

        for (int i = count0 + count1; i < arr.length; i++) {
            arr[i] = 2;
        }
    }

    /**
     * Optimal solution using the Dutch National Flag algorithm.
     *
     * Uses three pointers:
     * low -> boundary for 0s
     * mid -> current element
     * high -> boundary for 2s
     *
     * The algorithm rearranges elements in a single pass.
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(1)
     *
     * @param arr the input array containing 0s, 1s, and 2s
     */
    public static void optimalSolution(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
