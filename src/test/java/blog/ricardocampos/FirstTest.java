package blog.ricardocampos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FirstTest {

  @Test
  @DisplayName("validBracketSequencesTest")
  void validBracketSequencesTest() {
    Assertions.assertTrue(First.validBracketSequence("{}"));
    Assertions.assertTrue(First.validBracketSequence("[]"));
    Assertions.assertTrue(First.validBracketSequence("()"));
    Assertions.assertTrue(First.validBracketSequence("()[]{}"));
    Assertions.assertTrue(First.validBracketSequence("{[]}"));
    Assertions.assertTrue(First.validBracketSequence("[{{{([{}])}}}]"));
  }

  @Test
  @DisplayName("invalidBracketSequencesTest")
  void invalidBracketSequencesTest() {
    Assertions.assertFalse(First.validBracketSequence("]"));
    Assertions.assertFalse(First.validBracketSequence("[)"));
    Assertions.assertFalse(First.validBracketSequence("[{{{([{])}}}]"));
  }
}
