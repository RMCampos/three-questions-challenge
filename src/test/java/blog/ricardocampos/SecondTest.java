package blog.ricardocampos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SecondTest {

  @Test
  @DisplayName("successTest")
  void successTest() {
    Assertions.assertEquals(1, Second.stringsConstruction("ab", "abcbcb"));
    Assertions.assertEquals(2, Second.stringsConstruction("abc", "abccba"));
  }

  @Test
  @DisplayName("failTest")
  void failTest() {
    Assertions.assertEquals(0, Second.stringsConstruction("ab", "cdadrcb"));
    Assertions.assertEquals(0, Second.stringsConstruction("abc", "abafdcca"));
  }
}
