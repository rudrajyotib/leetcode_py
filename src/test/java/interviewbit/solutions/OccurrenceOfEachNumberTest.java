package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class OccurrenceOfEachNumberTest {

    @Test
    public void shouldFindNumbersListSet1(){
        assertArrayEquals(new int[]{2,1},
                new OccurrenceOfEachNumber().solve(new int[]{4,3,3}));
    }

    @Test
    public void shouldFindNumbersListSet2(){
        assertArrayEquals(new int[]{1,1,1},
                new OccurrenceOfEachNumber().solve(new int[]{4,5,3}));
    }


}