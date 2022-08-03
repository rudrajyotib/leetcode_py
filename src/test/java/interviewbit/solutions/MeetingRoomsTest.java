package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class MeetingRoomsTest {

    @Test
    public void shouldCalculateMeetingRoomsWithoutOverlap(){
        assertEquals(1, new MeetingRooms().solve(
                new int[][]{
                        new int[]{1,3},
                        new int[]{10,30},
                        new int[]{100,300},
                }
        ));
    }

    @Test
    public void shouldCalculateMeetingRoomsWithOverlapSet1(){
        assertEquals(3, new MeetingRooms().solve(
                new int[][]{
                        new int[]{1,30},
                        new int[]{2,8},
                        new int[]{3,17},
                }
        ));
    }


}