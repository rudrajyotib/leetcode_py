package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class SelectNodesTest {


    @Test
    public void set1(){
        assertEquals(2, new SelectNodes().solve(6, new int[][]{
                {1,2},
                {1,3},
                {2,4},
                {3,5},
                {3,6}
        }));
    }

    @Test
    public void set2(){
        assertEquals(3, new SelectNodes().solve(6, new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {4,5},
                {5,6}
        }));
    }

}