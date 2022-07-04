package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrderOfPeopleHeightsTest {

    @Test
    public void shouldArrangeSortedHeightQueue(){
        assertArrayEquals(new Integer[]{1,2,3,4,5},
                new OrderOfPeopleHeights().solve(
                        new ArrayList<>(List.of(5,2,3,1,4)),
                        new ArrayList<>(List.of(0,0,0,0,0))
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldArrangeReverseSortedHeightQueue(){
        assertArrayEquals(new Integer[]{5,4,3,2,1},
                new OrderOfPeopleHeights().solve(
                        new ArrayList<>(List.of(5,2,3,1,4)),
                        new ArrayList<>(List.of(0,3,2,4,1))
                ).toArray(new Integer[1]));
    }

    @Test
    public void shouldArrangeRandomQueueSet1(){
        assertArrayEquals(new Integer[]{49, 62,  21, 27, 92, 90, 59, 86 },
                new OrderOfPeopleHeights().solve(
                        new ArrayList<>(List.of(86, 92, 49, 21, 62, 27, 90, 59)),
                        new ArrayList<>(List.of(2, 0, 0, 2, 0, 2, 1, 3))
                ).toArray(new Integer[1]));
    }


}