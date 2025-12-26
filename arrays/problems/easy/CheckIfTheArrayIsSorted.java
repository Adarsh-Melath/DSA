package arrays.problems.easy;

public class CheckIfTheArrayIsSorted {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };
    System.out.println(f(arr));
  }

  public static boolean f(int[] arr) {

    for (int i = 1; i <= arr.length - 1; i++) {
      if (!(arr[i] > arr[i - 1])) {
        return false;
      }
    }
    return true;
  }
}
