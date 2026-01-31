import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeTwoArray {
    public static void main(String[] args) {
        int[] arr1 = { -5, -2, 4, 5 };
        int[] arr2 = { -3, 1, 8 };

        // bruteForce(arr1, arr2, arr1.length, arr2.length);
        optimalSolution(arr1, arr2, arr1.length, arr2.length);
    }

    public static void optimalSolution(int[] arr1, int[] arr2, int m, int n)
    {
        int endOfFirst = arr1.length-1;
        int startOfSecond = 0;

        while(endOfFirst>=0 && startOfSecond<arr2.length)
        {
            if(arr1[endOfFirst]>arr2[startOfSecond])
            {
                int temp = arr1[endOfFirst];
                arr1[endOfFirst] = arr2[startOfSecond];
                arr2[startOfSecond] = temp;

                endOfFirst--;
                startOfSecond++;
            }
            else {
                break;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void bruteForce(int[] arr1, int[] arr2, int m, int n) {
        int[] arr3 = new int[n + m];

        int left = 0;
        int right = 0;
        int index = 0;
        while (left < m && right < n) {
            if (arr1[left] <= arr2[right]) {
                arr3[index++] = arr1[left];
                left++;
            } else {
                arr3[index++] = arr2[right];
                right++;
            }
        }

        while (left < m) {
            arr3[index++] = arr1[left++];
        }

        while (right < n) {
            arr3[index++] = arr2[right++];
        }

        for (int i = 0; i < n + m; i++) {
            if (i < m) {
                arr1[i] = arr3[i];
            } else {
                arr2[i - m] = arr3[i];
            }
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
