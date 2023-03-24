package blog.ricardocampos;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

  private static final int[] ARR = new int[] {10, 20, 30, 50, 60, 80, 110, 130, 140, 170};

  @Test
  public void findSuccessTest() {
    Assert.assertEquals(1, BinarySearch.find(ARR, 20));
    Assert.assertEquals(6, BinarySearch.find(ARR, 110));
    Assert.assertEquals(8, BinarySearch.find(ARR, 140));
  }

  @Test
  public void findGreaterTest() {
    Assert.assertEquals(-1, BinarySearch.find(ARR, 175));
    Assert.assertEquals(-1, BinarySearch.find(ARR, 355));
  }

  @Test
  public void findLowerTest() {
    Assert.assertEquals(-1, BinarySearch.find(ARR, 5));
    Assert.assertEquals(-1, BinarySearch.find(ARR, 1));
    Assert.assertEquals(-1, BinarySearch.find(ARR, -1));
  }
}
