import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithSum0 {
    public static void main(String[] args) {
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };

        System.out.println(bruteForce(arr));
        System.out.println(optimalSolution(arr));
    }

    public static int optimalSolution(int[] arr) {
        int length = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                length = Math.max(length, i + 1);
            }
            int remaining = sum - 0;
            if (prefixSum.containsKey(remaining)) {
                int prefixIndex = prefixSum.get(remaining);
                length = Math.max(length, i - prefixIndex);
            }
            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
        }

        return length;
    }

    public static int bruteForce(int[] arr) {
        int length = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == 0) {
                    length = Math.max(length, j - i + 1);
                }
            }
        }

        return length;
    }
}
