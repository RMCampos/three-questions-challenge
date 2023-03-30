package blog.ricardocampos;

import java.util.Arrays;
import java.util.Random;

/*
Evenly distribute the incoming stream of users with a probability of
  80% - 0,
  10% - 1,
  10% - 2 and issue the corresponding index.
*/

public class ABTest {

  public static void main(String[] args) {
    int[] arr = {0, 0, 0};
    for (int i = 0; i < 100000; i++) {
      arr[getFeature()]++;
    }
    System.out.println(Arrays.toString(arr));
  }

  public static int getFeature() {
    // get the next randomly
    int multiplier = 1000000;
    int nextPosition = new Random().nextInt(0, 99 * multiplier);

    // The next element to return
    int nextElement = 0;
    if (nextPosition > 80 * multiplier && nextPosition <= 90 * multiplier) {
      nextElement = 1;
    } else if (nextPosition > 90 * multiplier) {
      nextElement = 2;
    }

    return nextElement;
  }
}
