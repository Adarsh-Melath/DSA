package arrays.problems.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class MajorityElement {
    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 2, 2, 3, 3, 3 };
        System.out.println(bruteForce(nums));
        System.out.println(betterSolution(nums));
        System.out.println(optimalSolution(nums));
    }

    public static List<Integer> bruteForce(int nums[]) {
        List<Integer> majorityElements = new ArrayList<>();
        int n = (int) Math.floor(nums.length / 3);

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > n) {
                majorityElements.add(nums[i]);
            }
        }
        return majorityElements;
    }

    public static List<Integer> betterSolution(int[] nums) {
        List<Integer> majorityElements = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > Math.floor(nums.length / 3) && !majorityElements.contains(num)) {
                majorityElements.add(num);
            }

            if (majorityElements.size() == 2)
                break;
        }

        return majorityElements;
    }

    public static List<Integer> optimalSolution(int[] nums) {
        List<Integer> majorityElements = new ArrayList<>();
        int element1 = 0, element2 = 0, count1 = 0, count2 = 0;
        int n = (int) Math.floor(nums.length / 3);

        for (int num : nums) {
            if (count1 == 0 && num != element2) {
                count1++;
                element1 = num;
            } else if (count2 == 0 && num != element1) {
                count2++;
                element2 = num;
            } else if (element1 == num) {
                count1++;
            } else if (element2 == num) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {

            if (num == element1)
                count1++;
            else if (num == element2)
                count2++;
        }

        if (count1 >=n) {
            majorityElements.add(element1);
        }  if (count2 >=n) {
            majorityElements.add(element2);
        }

        return majorityElements;
    }
}