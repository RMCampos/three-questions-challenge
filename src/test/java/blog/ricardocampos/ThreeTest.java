package blog.ricardocampos;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class ThreeTest {
    
    @Test
    public void closestPointPairTest() {
        Three three = new Three();

        int[][] p = new int[][]{{0, 11},{-7,1},{-5,-3}};
        assertEquals(new BigDecimal("4.472135955"), three.closestPointPair(p));
    }
}
