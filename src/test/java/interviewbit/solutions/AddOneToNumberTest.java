package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddOneToNumberTest {

    @Test
    public void shouldAddOneToNumberSet1(){
        assertArrayEquals(new int[]{1,0,0},
                new AddOneToNumber().solve(new int[]{0,0,0,0,9,9}));
    }

    @Test
    public void shouldAddOneToNumberSet2(){
        assertArrayEquals(new int[]{1,0,1},
                new AddOneToNumber().solve(new int[]{0,0,0,0,1,0,0}));
    }

    @Test
    public void shouldAddOneToNumberSet3(){
        assertArrayEquals(new int[]{1,0,1},
                new AddOneToNumber().solve(new int[]{1,0,0}));
    }

    @Test
    public void shouldAddOneToNumberSet4(){
        assertArrayEquals(new int[]{1,1,0},
                new AddOneToNumber().solve(new int[]{1,0,9}));
    }

    @Test
    public void shouldAddOneToNumberSet5(){
        assertArrayEquals(new int[]{1,0},
                new AddOneToNumber().solve(new int[]{9}));
    }

    @Test
    public void shouldAddOneToNumberSet6(){
        assertArrayEquals(new int[]{5,0,0,0},
                new AddOneToNumber().solve(new int[]{4,9,9,9}));
    }


}