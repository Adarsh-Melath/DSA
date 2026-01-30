public class LargestSubArrayWithSum0 {
    public static void main(String[] args) {
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };

        System.out.println(bruteForce(arr));
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
