package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/meeting-rooms/
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

    public int solve(int[][] meetingSchedules){
        return new Solution().solve(meetingSchedules);
    }

    public static class Solution {
        public int solve(int[][] A) {


            Arrays.sort(A, Comparator.comparingInt(o -> o[0]));

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

            int roomsRequired = 1;
            priorityQueue.offer(A[0][1]);

            for (int i=1;i<A.length;i++){
                if (!priorityQueue.isEmpty() && priorityQueue.peek() > A[i][0]){
                    ++roomsRequired;
                }else{
                    priorityQueue.poll();
                }
                priorityQueue.offer(A[i][1]);
            }

           return roomsRequired;
        }
    }

}
