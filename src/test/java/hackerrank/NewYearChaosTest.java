package hackerrank;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class NewYearChaosTest {

    @Test
    public void testCase1(){
        assertEquals(1, NewYearChaos.minimumBribes(List.of(1,2,3,5,4,6,7,8)));
        assertEquals(4, NewYearChaos.minimumBribes(List.of(3,2,1,5,4)));
        assertEquals(7, NewYearChaos.minimumBribes(List.of(1, 2 ,5 ,3 ,7, 8, 6, 4)));
        assertEquals(7, NewYearChaos.minimumBribes(List.of(3,2,1 ,6,7,4,5,8)));
        assertEquals(-1, NewYearChaos.minimumBribes(List.of(3,2,1 ,4,8,5,6,7)));
    }

}