import java.util.Arrays;

public class ReverseAnArray {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };
    f(arr, 0);
    System.out.println(Arrays.toString(arr));
  }

  public static void f(int[] arr, int i) {
    int n = arr.length;
    if (i > n / 2) {
      return;
    }
    int temp = arr[i];
    arr[i] = arr[n - i - 1];
    arr[n - i - 1] = temp;
    f(arr, i + 1);
  }
}
