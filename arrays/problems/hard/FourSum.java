import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] numbers = { 7, -7, 1, 2, 14, 3 };
        int target = 9;

        System.out.println(Arrays.toString(bruteForce(numbers, target).toArray()));
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
}