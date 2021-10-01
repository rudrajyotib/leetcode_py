package leet.solutions;

/*
https://leetcode.com/problems/course-schedule/
Leetcode#207
 */

import java.util.*;

public class CourseSchedule {


    public boolean solve(int numCourses, int[][] prerequisites) {
        Solution solution = new Solution();
        return solution.canFinish(numCourses, prerequisites);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {


        public boolean canFinish(int numCourses, int[][] prerequisites) {

            if (numCourses == 1) {
                return true;
            }

            Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
            for (int[] prerequisite : prerequisites) {
                if (adjacencyList.containsKey(prerequisite[0])) {
                    adjacencyList.get(prerequisite[0]).add(prerequisite[1]);
                } else {
                    adjacencyList.put(prerequisite[0], new LinkedList<>() {
                        {
                            add(prerequisite[1]);
                        }
                    });
                }
            }

            boolean[] visitTracker = new boolean[numCourses];
            boolean[] trailTracker = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {
                if (detectCycle(adjacencyList, visitTracker, trailTracker, i)) {
                    return false;
                }
            }


            return true;
        }

        private boolean detectCycle(Map<Integer, List<Integer>> adjacencyList,
                                    boolean[] visitTracker,
                                    boolean[] trailTracker,
                                    int startNode) {
            if (trailTracker[startNode]) {
                return true;
            }
            if (visitTracker[startNode]) {
                return false;
            }

            if (!adjacencyList.containsKey(startNode)) {
                return false;
            }
            trailTracker[startNode] = true;
            visitTracker[startNode] = true;
            for (Integer childNode : adjacencyList.get(startNode)) {
                if (detectCycle(adjacencyList, visitTracker, trailTracker, childNode)) {
                    return true;
                }
            }
            trailTracker[startNode] = false;

            return false;
        }
    }
}
