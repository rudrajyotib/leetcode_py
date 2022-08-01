package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class KnightOnChessBoardTest {


    @Test
    public void shouldFindMinimumStepsSet1(){
        assertEquals(6, new KnightOnChessBoard().solve(
                8, 8, 1,1,8,8
        ));
    }

    @Test
    public void shouldFindMinimumStepsSet2(){
        assertEquals(3, new KnightOnChessBoard().solve(
                4, 3, 3,2,3,1
        ));
    }

    @Test
    public void shouldNotFindSet1(){
        assertEquals(-1, new KnightOnChessBoard().solve(
                2,20,1,18,1,5)
        );
    }
}