package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PairWithGivenDifferenceTest {

    @Test
    public void shouldFindPairOfDistantIndexWithPositiveDifference() {
        assertEquals(1,
                new PairWithGivenDifference().solve(
                        new ArrayList<>(List.of(1, 2, 20, 30, 3, 5, 8, 4)), 5
                ));
    }

    @Test
    public void shouldFindPairOfAdjacentIndexWithPositiveDifference() {
        assertEquals(1,
                new PairWithGivenDifference().solve(
                        new ArrayList<>(List.of(1, 2, 20, 30, 3, 5, 8, 4)), 12
                ));
    }

    @Test
    public void shouldFindPairOfDistantIndexWithNegativeWithPositiveDifference() {
        assertEquals(1,
                new PairWithGivenDifference().solve(
                        new ArrayList<>(List.of(1, 2, 20, 30, 3, 5, 8, 4,-30,-1,-4,-50,-98)), 29
                ));
    }


    @Test
    public void shouldFindPairOfDistantIndexWithOneNegativeAndOtherPositiveWithPositiveDifference() {
        assertEquals(1,
                new PairWithGivenDifference().solve(
                        new ArrayList<>(List.of(1, 2, 20, 30, 3, 5, 8, 4,-30,-1,-4,-50,-98)), 32
                ));
    }

    @Test
    public void shouldFindPairOfDistantIndexWithNegativeDifference() {
        assertEquals(1,
                new PairWithGivenDifference().solve(
                        new ArrayList<>(List.of(1, 2, 20, 30, 3, 5, 8, 4)), -5
                ));
    }

    @Test
    public void shouldFindPairOfAdjacentIndexWithNegativeDifference() {
        assertEquals(1,
                new PairWithGivenDifference().solve(
                        new ArrayList<>(List.of(1, 2, 20, 30, 3, 5, 8, 4)), -12
                ));
    }

    @Test
    public void shouldFindPairOfDistantIndexWithNegativeWithNegativeDifference() {
        assertEquals(1,
                new PairWithGivenDifference().solve(
                        new ArrayList<>(List.of(1, 2, 20, 30, 3, 5, 8, 4,-30,-1,-4,-50,-98)), -29
                ));
    }


    @Test
    public void shouldFindPairOfDistantIndexWithOneNegativeAndOtherNegativeWithPositiveDifference() {
        assertEquals(1,
                new PairWithGivenDifference().solve(
                        new ArrayList<>(List.of(1, 2, 20, 30, 3, 5, 8, 4,-30,-1,-4,-50,-98)), -32
                ));
    }


    @Test
    public void shouldIdentifyPairWithSameValues(){
        assertEquals(1, new PairWithGivenDifference().solve(
                new ArrayList<>(List.of(0,-2,20,15,18,15)),0
        ));
    }

    @Test
    public void shouldNotIdentifyPairWithPositiveDifference(){
        assertEquals(0, new PairWithGivenDifference().solve(
                new ArrayList<>(List.of(0,-2,20,15,18,15)),100
        ));
    }

    @Test
    public void shouldNotIdentifyPairWithNegativeDifference(){
        assertEquals(0, new PairWithGivenDifference().solve(
                new ArrayList<>(List.of(0,-2,20,15,18,15)),-100
        ));
    }

    @Test
    public void shouldNotIdentifyPairWithZeroDifference(){
        assertEquals(0, new PairWithGivenDifference().solve(
                new ArrayList<>(List.of(10, 20, 30, 40)), 0
        ));
    }
}