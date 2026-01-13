package arrays.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeTheArray {
    public static void main(String[] args) {
        int[] array = { 2, 4, 5, -1, -3, -4 };

        // bruteForceSolution(array);
        System.out.println(Arrays.toString(optimalSolution(array)));
        // for (int num : array) {
        //     System.out.print(num + " ");
        // }
    }

    public static void bruteForceSolution(int[] array) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int num : array) {
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i] = positive.remove(0);
            } else {
                array[i] = negative.remove(0);
            }
        }
    }

    public static int[] optimalSolution(int[] array) {
        int[] ans = new int[array.length];

        int positiveIndex = 0;
        int negativeIndex = 1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                ans[positiveIndex] = array[i];
                positiveIndex += 2;
            } else {
                ans[negativeIndex] = array[i];
                negativeIndex += 2;
            }
        }
        return ans;
    }
}
