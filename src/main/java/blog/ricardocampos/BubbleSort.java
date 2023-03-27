package blog.ricardocampos;

import java.util.logging.Logger;

class BubbleSort {

  private static final Logger logger = Logger.getLogger(BubbleSort.class.getName());

  /**
   * Given an unsorted array, sort the array.
   *
   * @param arr array of integer values
   */
  public static void sortArray(int[] arr) {
    logger.info("Unsorted - " + printArray(arr));

    for (int i=0, len=arr.length; i<len-1; i++) {
      for (int j=0; j<len-i-1; j++) {
        if (arr[j] > arr[j+1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }

    logger.info("Sorted - " + printArray(arr));
  }

  private static String printArray(int[] arr) {
    StringBuilder builder = new StringBuilder("Array: [");
    for (int j : arr) {
      if (arr[0] != j) {
        builder.append(", ");
      }
      builder.append(j);
    }
    builder.append("]");
    return builder.toString();
  }
}
