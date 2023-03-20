package blog.ricardocampos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FirstTest {

  @Test
  public void validBracketSequencesTest() {
    assertTrue(First.validBracketSequence("{}"));
    assertTrue(First.validBracketSequence("[]"));
    assertTrue(First.validBracketSequence("()"));
    assertTrue(First.validBracketSequence("()[]{}"));
    assertTrue(First.validBracketSequence("{[]}"));
    assertTrue(First.validBracketSequence("[{{{([{}])}}}]"));
  }

  @Test
  public void invalidBracketSequencesTest() {
    assertFalse(First.validBracketSequence("]"));
    assertFalse(First.validBracketSequence("[)"));
    assertFalse(First.validBracketSequence("[{{{([{])}}}]"));
  }
}
