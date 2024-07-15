package gfg;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MeetingsInOneRoomTest {

    @Test
    public void testCase1(){
        assertEquals(4,  MeetingsInOneRoom.maxMeetings(
                new int[]{1,3,0,5,8,5},
                new int[]{2,4,6,7,9,9},
                6
        ));
    }

}