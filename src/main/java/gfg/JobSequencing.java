/*
https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
 */

package gfg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JobSequencing {

    int[] JobScheduling(Job[] arr, int n) {
        // Your code here
        Arrays.sort(arr, Comparator.comparingInt(o -> o.deadline));
        int maxDeadline = arr[n - 1].deadline;
        int arrayCounter = n - 1;
        int jobs = 0;
        int profit = 0;
        PriorityQueue<Job> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.profit, o1.profit));
        while (maxDeadline > 0) {
            while ((arrayCounter >= 0 && arr[arrayCounter].deadline >= maxDeadline)) {
                priorityQueue.offer(arr[arrayCounter]);
                --arrayCounter;
            }
            if (!priorityQueue.isEmpty()) {
                Job j = priorityQueue.remove();
                profit += j.profit;
                ++jobs;
            }
            --maxDeadline;
        }
        return new int[]{jobs, profit};
    }

    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
}
