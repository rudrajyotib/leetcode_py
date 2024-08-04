/*
https://leetcode.com/problems/task-scheduler-ii
 */

package leet.solutions;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler2 {

    public long solve(int[] tasks, int gap) {
        return new Solution().taskSchedulerII(tasks, gap);
    }

    static class Solution {
        public long taskSchedulerII(int[] tasks, int space) {
            Map<Integer, Long> taskToLastComplete = new HashMap<>();
            long days = 0L;
            for (int task : tasks) {
                ++days;
                if (!taskToLastComplete.containsKey(task)) {
                    taskToLastComplete.put(task, days);
                } else {
                    long lastDone = taskToLastComplete.get(task);
                    long coolDown = lastDone + space;
                    if (coolDown >= days) {
                        days = coolDown + 1;
                    }
                    taskToLastComplete.put(task, days);
                }
            }
            return days;
        }
    }
}
