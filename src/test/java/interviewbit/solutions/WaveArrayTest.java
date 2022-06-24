package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class WaveArrayTest {


    @Test
    public void shouldWaveSortEvenSizedArray(){
        assertArrayEquals(new Integer[]{2,1,4,3},
                new WaveArray().solve(
                        new ArrayList<>(List.of(1,4,3,2))
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldWaveSortOddSizedArray(){
        assertArrayEquals(new Integer[]{2,1,4,3, 5},
                new WaveArray().solve(
                        new ArrayList<>(List.of(1,4,3,2, 5))
                ).toArray(new Integer[1]));
    }



}