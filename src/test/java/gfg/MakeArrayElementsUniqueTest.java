package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MakeArrayElementsUniqueTest {


    @Test
    public void set1(){
        assertEquals(3, new MakeArrayElementsUnique().solve(new int[]{1,1,2,3}));
        assertEquals(45, new MakeArrayElementsUnique().solve(new int[]{1,1,1,1,2,2,2,2,2,2,5,}));
        assertEquals(0, new MakeArrayElementsUnique().solve(new int[]{1,2,3}));
    }

}