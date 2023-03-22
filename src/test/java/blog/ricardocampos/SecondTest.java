package blog.ricardocampos;

import org.junit.Assert;
import org.junit.Test;

public class SecondTest {

  @Test
  public void successTest() {
    Assert.assertEquals(1, Second.stringsConstruction("ab", "abcbcb"));
    Assert.assertEquals(2, Second.stringsConstruction("abc", "abccba"));
  }

  @Test
  public void failTest() {
    Assert.assertEquals(0, Second.stringsConstruction("ab", "cdadrcb"));
    Assert.assertEquals(0, Second.stringsConstruction("abc", "abafdcca"));
  }
}
