package hackerrank;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MatrixCityAttackTest {

    @Test
    public void testCase1(){
        assertEquals(10, MatrixCityAttack.minTime(
                List.of(
                        List.of(2, 1, 8),
                        List.of(1,0,5),
                        List.of(2,4,5),
                        List.of(1,3,4)
                ), List.of(2, 4, 0)
        ));
    }

    @Test
    public void testCase2(){
        assertEquals(5, MatrixCityAttack.minTime(
                List.of(
                        List.of(0,4,2),
                        List.of(0,1,4),
                        List.of(1,3,7),
                        List.of(1,2,3)
                ), List.of(2, 4, 3)
        ));
    }


}