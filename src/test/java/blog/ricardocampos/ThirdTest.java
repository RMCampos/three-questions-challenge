package blog.ricardocampos;

import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThirdTest {

  @Test
  @DisplayName("closestPointPairTest")
  public void closestPointPairTest() {
    int[][] p = new int[][] {{0, 11}, {-7, 1}, {-5, -3}};
    Assertions.assertEquals(new BigDecimal("4.472135955"), Third.closestPointPair(p));
  }
}
