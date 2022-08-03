package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class BulbsTest {

    @Test
    public void shouldCalculateBulbsSwitchSet1(){
        assertEquals(4, new Bulbs().solve(
                new int[]{0,1,0,1}
        ));
    }

    @Test
    public void shouldCalculateBulbsSwitchSet2(){
        assertEquals(2, new Bulbs().solve(
                new int[]{1,1,0,1}
        ));
    }

}