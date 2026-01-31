import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeAllOverlappingIntervals {
    public static void main(String[] args) {
        int[][] arr = { { 1, 5 }, { 3, 6 }, { 8, 10 }, { 15, 18 } };

        // System.out.println(Arrays.deepToString(bruteForce(arr).toArray()));
        System.out.println(Arrays.deepToString(optimalSolution(arr).toArray()));
    }

    public static List<List<Integer>> optimalSolution(int[][] arr) {

        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                int last = ans.size()-1;
                int maxEnd = Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]);
                ans.get(last).set(1, maxEnd);
            }
        }
        return ans;
    }

    public static List<List<Integer>> bruteForce(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> (a[0] - b[0]));
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }

            ans.add(Arrays.asList(start, end));
        }

        return ans;
    }
}