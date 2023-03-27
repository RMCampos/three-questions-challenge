package blog.ricardocampos;

import java.util.Arrays;import org.junit.jupiter.api.Assertions;import org.junit.jupiter.api.DisplayName;import org.junit.jupiter.api.Test;

class BubbleSortTest {

  @Test
  @DisplayName("sortTest")
  void sortTest() {
    int[] input = new int[]{5,1,4,2,8};
    int[] expected = new int[]{1,2,4,5,8};

    BubbleSort.sortArray(input);

    Assertions.assertArrayEquals(expected, input);
  }
}
