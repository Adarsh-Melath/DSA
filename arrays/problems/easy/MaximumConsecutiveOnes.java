
/**
 * MaximumConsecutiveOnes
 */
public class MaximumConsecutiveOnes {
  public static void main(String[] args) {
    int[] arr = { 1, 1, 0, 1, 1, 1, 0, 1 };
    System.out.println(bruteForceSolution(arr));
  }

  public static int bruteForceSolution(int[] arr) {
    int count = 0;
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 1) {
        count++;
        if (max < count) {
          max = count;
        }
      } else {
        count = 0;
      }
    }
    return max;
  }
}