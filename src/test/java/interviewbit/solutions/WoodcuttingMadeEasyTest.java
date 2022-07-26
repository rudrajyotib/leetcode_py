package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class WoodcuttingMadeEasyTest {

    @Test
    public void shouldCutSingleTree(){
        assertEquals(42,
                new WoodcuttingMadeEasy().solve(new int[]{10,20,1,24,46},4));
    }

    @Test
    public void shouldCutAllTrees(){
        assertEquals(3,
                new WoodcuttingMadeEasy().solve(new int[]{4,6,8,12},18));
    }

    @Test
    public void shouldCutSomeTreesSet1(){
        assertEquals(5,
                new WoodcuttingMadeEasy().solve(new int[]{4,6,8,12},11));
    }

    @Test
    public void shouldCutSomeTreesSet2(){
        assertEquals(13,
                new WoodcuttingMadeEasy().solve(new int[]{10,30,50,70},110));
    }


}