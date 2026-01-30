import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithXorAsK {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        int k = 6;
        System.out.println(bruteForce(arr, k));
        System.out.println(optimalSolution(arr, k));
    }

    public static int optimalSolution(int[] arr, int k) {
        int count = 0;
        int xor = 0;

        Map<Integer, Integer> prefixXor = new HashMap<>();
        prefixXor.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            int remaining = xor ^ k;
            if (prefixXor.containsKey(remaining)) {
                count += prefixXor.get(remaining);
            }
            prefixXor.put(xor, prefixXor.getOrDefault(xor, 0) + 1);
        }

        return count;

    }

    public static int bruteForce(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
