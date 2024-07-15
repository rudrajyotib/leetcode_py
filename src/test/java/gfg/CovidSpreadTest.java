package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class CovidSpreadTest {

    @Test
    public void testCase1(){
        assertEquals(2,
                new CovidSpread().helpaterp(
                        new int[][]{
                                new int[]{2 ,1 ,0 ,2 ,1},
                                new int[]{1 ,0 ,1 ,2, 1},
                                new int[]{1 ,0 ,0 ,2 ,1 },
                        }
                ));
    }

    @Test
    public void testCase2(){
        assertEquals(-1,
                new CovidSpread().helpaterp(
                        new int[][]{
                                new int[]{2 ,1 ,0 ,2 ,1},
                                new int[]{0 ,0 ,1 ,2, 1},
                                new int[]{1 ,0 ,0 ,2 ,1 },
                        }
                ));
    }

}