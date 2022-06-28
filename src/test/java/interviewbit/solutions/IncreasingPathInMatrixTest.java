package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IncreasingPathInMatrixTest {


    @Test
    public void shouldFindPath(){
        assertEquals(7, new IncreasingPathInMatrix().solve(
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(1,2,3,4)),
                        new ArrayList<>(List.of(2,2,3,4)),
                        new ArrayList<>(List.of(3,2,3,4)),
                        new ArrayList<>(List.of(4,5,6,7))
                ))
        ));
    }

    @Test
    public void shouldNotFindPath(){
        assertEquals(-1, new IncreasingPathInMatrix().solve(
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(1,2,3,4)),
                        new ArrayList<>(List.of(2,2,3,4)),
                        new ArrayList<>(List.of(3,2,3,4)),
                        new ArrayList<>(List.of(4,5,6,2))
                ))
        ));
    }

    @Test
    public void shouldFindPathInSingeRowMatrix(){
        assertEquals(4, new IncreasingPathInMatrix().solve(
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(1,2,3,4))
                ))
        ));
    }

    @Test
    public void shouldNotFindPathInSingeRowMatrix(){
        assertEquals(-1, new IncreasingPathInMatrix().solve(
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(1,2,3,2))
                ))
        ));
    }

    @Test
    public void shouldFindPathInSingleColumnMatrix(){
        assertEquals(4, new IncreasingPathInMatrix().solve(
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(1)),
                        new ArrayList<>(List.of(2)),
                        new ArrayList<>(List.of(3)),
                        new ArrayList<>(List.of(4))
                ))
        ));
    }

    @Test
    public void shouldNotFindPathInSingleColumnMatrix(){
        assertEquals(-1, new IncreasingPathInMatrix().solve(
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(1)),
                        new ArrayList<>(List.of(2)),
                        new ArrayList<>(List.of(3)),
                        new ArrayList<>(List.of(1))
                ))
        ));
    }

    @Test
    public void shouldNotFindPathInSingleCellMatrix(){
        assertEquals(1, new IncreasingPathInMatrix().solve(
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(1))
                ))
        ));
    }

    @Test
    public void shoulNotdFindPathIfLongestChainDoesNotStartFromTopLeft(){
        assertEquals(-1, new IncreasingPathInMatrix().solve(
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(2,2,3,4)),
                        new ArrayList<>(List.of(2,2,3,4)),
                        new ArrayList<>(List.of(3,3,3,4)),
                        new ArrayList<>(List.of(4,5,6,7))
                ))
        ));
    }



}