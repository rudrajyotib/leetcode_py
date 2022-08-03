package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestPermutationTest {

    @Test
    public void shouldPerformAllSwaps(){
        assertArrayEquals(new int[]{7,6,5,1,4,3,2},
                new LargestPermutation().solve(
                        new int[]{2,3,4,1,5,6,7},
                        3
                ));
    }

    @Test
    public void shouldNotPerformAllSwaps(){
        assertArrayEquals(new int[]{4,3,2,1},
                new LargestPermutation().solve(
                        new int[]{4,2,1,3},
                        3
                ));
    }

}