package blog.ricardocampos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OneTest {
    
    @Test
    public void validBracketSequence() {
        One one = new One();

        assertEquals(true, one.validBracketSequence("{}"));
        assertEquals(true, one.validBracketSequence("[]"));
        assertEquals(true, one.validBracketSequence("()"));
        assertEquals(true, one.validBracketSequence("()[]{}"));
        assertEquals(true, one.validBracketSequence("{[]}"));
        assertEquals(false, one.validBracketSequence("]"));
        assertEquals(false, one.validBracketSequence("[)"));
    }
}
