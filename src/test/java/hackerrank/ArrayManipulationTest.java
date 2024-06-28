package hackerrank;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ArrayManipulationTest {

    @Test
    public void testCase1(){
        assertEquals(10, ArrayManipulation.arrayManipulation(
                10,
                List.of(
                        List.of(1,5,3),
                        List.of(4,8,7),
                        List.of(6,9,1)
                )
        ));
    }

}