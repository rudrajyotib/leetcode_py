package gfg;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingsInOneRoom {

    public static int maxMeetings(int[] start, int[] end, @SuppressWarnings("unused") int n)
    {

        int[][] meetings = new int[start.length][2];
        for (int i=0;i<start.length;i++){
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[1]));

        int count = 1;
        int lastMeetEndTime = meetings[0][1];
        for (int i=1;i<start.length;i++){
            if (meetings[i][0]>lastMeetEndTime ){
                ++count;
                lastMeetEndTime = meetings[i][1];
            }
        }

        return count;
        // add your code here
    }

}
