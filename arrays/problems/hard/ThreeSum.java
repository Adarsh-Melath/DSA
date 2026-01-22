package arrays.problems.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { 2, -2, 0, 3, -3, 5 };

        System.out.println(Arrays.deepToString(bruteForce(nums).toArray()));
        System.out.println(Arrays.deepToString(betterSolution(nums).toArray()));
        System.out.println(Arrays.deepToString(optimalSolution(nums).toArray()));
    }

    public static List<List<Integer>> bruteForce(int[] nums) {
        int n = nums.length;
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i]
                            + nums[j]
                            + nums[k] == 0) {
                        triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return triplets;
    }

    public static Set<List<Integer>> betterSolution(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> triplets = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (set.contains(third)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp);
                    triplets.add(temp);
                }
                set.add(nums[j]);
            }
        }
        return triplets;
    }

    public static List<List<Integer>> optimalSolution(int nums[]) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return triplets;
    }
}
