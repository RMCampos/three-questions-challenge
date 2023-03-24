package blog.ricardocampos;

public class BinarySearch {

  private static int findBinary(int[] arr, int x, int highestIdx, int lowestIdx) {
    int mid = (highestIdx + lowestIdx) / 2;
    if (x == arr[mid]) {
      return mid;
    }
    if (highestIdx == lowestIdx) {
      return -1;
    }
    return (x > arr[mid])
        ? findBinary(arr, x, highestIdx, mid + 1)
        : findBinary(arr, x, mid - 1, lowestIdx);
  }

  public static int find(int[] arr, int x) {
    int highest = arr.length - 1;
    int lowest = 0;
    return findBinary(arr, x, highest, lowest);
  }
}
