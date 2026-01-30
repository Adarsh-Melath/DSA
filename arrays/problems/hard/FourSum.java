import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class FourSum {
    public static void main(String[] args) {
        int[] numbers = { 1, -2, 3, 5, 7, 9 };
        int target = 7;

        // System.out.println(Arrays.toString(bruteForce(numbers, target).toArray()));
        // System.out.println(Arrays.deepToString(betterSolution(numbers,
        // target).toArray()));
        System.out.println(Arrays.deepToString(optimalSolution(numbers, target).toArray()));
    }

    public static List<Integer> bruteForce(int[] numbers, int target) {
        List<Integer> elements = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    for (int l = k + 1; l < numbers.length; l++) {
                        if (numbers[i] + numbers[j] + numbers[k] + numbers[l] == target) {
                            elements.add(numbers[i]);
                            elements.add(numbers[j]);
                            elements.add(numbers[k]);
                            elements.add(numbers[l]);
                            return elements;
                        }
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    public static List<List<Integer>> betterSolution(int[] numbers, int target) {
        int n = numbers.length;
        List<List<Integer>> elements = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int fourth = target - numbers[i] - numbers[j] - numbers[k];
                    if (set.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(numbers[i]);
                        temp.add(numbers[j]);
                        temp.add(numbers[k]);
                        temp.add(fourth);

                        Collections.sort(temp);
                        elements.add(temp);
                    }
                    set.add(numbers[k]);
                }
            }
        }
        return elements;
    }

    public static List<List<Integer>> optimalSolution(int[] numbers, int target) {

        int n = numbers.length;
        List<List<Integer>> elements = new ArrayList<>();
        Arrays.sort(numbers);
        for (int i = 0; i < n; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1])
                    continue;
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    int sum = numbers[i] + numbers[j] + numbers[k] + numbers[l];

                    if (sum == target) {
                        elements.add(Arrays.asList(numbers[i], numbers[j], numbers[k], numbers[l]));
                        k++;
                        l++;
                        while (k < l && numbers[k] == numbers[k - 1])
                            k++;
                        while (k < l && numbers[l] == numbers[l + 1])
                            l--;
                    } else if (sum > target)
                        l--;
                    else
                        k++;
                }
            }
        }
        return elements;
    }
}