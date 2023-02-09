package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumBipartiteMatchingTest {

    @Test
    public void set1(){
        assertEquals(3, new MaximumBipartiteMatching().solve(
                new int[][]{
                        new int[]{1,1,0,1,1},
                        new int[]{0,1,0,0,1},
                        new int[]{1,1,0,1,1}
                }
        ));
    }


}