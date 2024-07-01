package hackerrank;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class NonDivisibleSubsetTest {

    @Test
    public void testCase1(){
        assertEquals(3, NonDivisibleSubset.nonDivisibleSubset(
                4, List.of(19,10,12,10,24,25,22)
        ));
    }

}