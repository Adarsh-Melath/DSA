import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CountSubarraysWithGivenSum {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int k = 3;

        System.out.println(bruteForce(nums, k));
        System.out.println(optimalSolution(nums, k));
    }

    public static int bruteForce(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int optimalSolution(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> sums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                count++;
            }
            int remaining = sum - k;
            if (sums.containsKey(remaining)) {
                count++;
            }
            sums.put(sum, i);
        }
        return count;
    }

}
