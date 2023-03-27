package blog.ricardocampos;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

  private static final int[] ARR = new int[] {10, 20, 30, 50, 60, 80, 110, 130, 140, 170};

  @Test
  @DisplayName("findSuccessTest")
  void findSuccessTest() {
    Assertions.assertEquals(1, BinarySearch.find(ARR, 20));
    Assertions.assertEquals(6, BinarySearch.find(ARR, 110));
    Assertions.assertEquals(8, BinarySearch.find(ARR, 140));
  }

  @Test
  @DisplayName("findGreaterTest")
  public void findGreaterTest() {
    Assertions.assertEquals(-1, BinarySearch.find(ARR, 175));
    Assertions.assertEquals(-1, BinarySearch.find(ARR, 355));
  }

  @Test
  @DisplayName("")
  public void findLowerTest() {
    Assertions.assertEquals(-1, BinarySearch.find(ARR, 5));
    Assertions.assertEquals(-1, BinarySearch.find(ARR, 1));
    Assertions.assertEquals(-1, BinarySearch.find(ARR, -1));
  }
}
