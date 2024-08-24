package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class KnapsackProblemTest {

    @Test
    public void testCase1(){
        assertEquals(20, KnapsackProblem.knapSack(4, new int[]{2 ,1 ,3 ,1 ,4 ,1 ,2 ,2 ,5 ,7}, new  int[]{6 ,3 ,8 ,6 ,9 ,8 ,2 ,4 ,10, 9}));
        assertEquals(3, KnapsackProblem.knapSack(4, new int[]{4,5,1}, new  int[]{1,2,3}));
        assertEquals(0, KnapsackProblem.knapSack(3, new int[]{4,5,6}, new  int[]{1,2,3}));
        assertEquals(6, KnapsackProblem.knapSack(10, new int[]{4,5,6}, new  int[]{1,5,3}));
    }

}