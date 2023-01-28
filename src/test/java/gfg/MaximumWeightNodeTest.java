package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumWeightNodeTest {

    @Test
    public void set1(){
        assertEquals(2, new MaximumWeightNode().solve(4, new int[]{2, 0, -1, 2}));
    }

    @Test
    public void set2(){
        assertEquals(4, new MaximumWeightNode().solve(8, new int[]{2, 0, -1, 2, -1, 4,4,4}));
    }


}