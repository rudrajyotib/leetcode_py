/*
https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
 */

package leet.solutions;

import ds.util.ListNode;

public class MaxAndMinNumberOfNodesBetweenCriticalPoints {

    public int[] solve(ListNode head){
        return new Solution().nodesBetweenCriticalPoints(head);
    }

    static class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {

            int maxDistance = -1;
            int minDistance = -1;
            int previousCriticalPoint = -1;
            int firstCriticalPoint = -1;

            ListNode prevNode = head;
            ListNode currentNode = head.next;
            int nodePos = 2;
            while (currentNode.next != null){
                ListNode next = currentNode.next;
                if ((next.val > currentNode.val && prevNode.val > currentNode.val)
                    || (next.val < currentNode.val && prevNode.val < currentNode.val)){
                    if (previousCriticalPoint != -1) {
                        int dist = nodePos - previousCriticalPoint;
                        if (firstCriticalPoint != -1){
                            maxDistance = nodePos - firstCriticalPoint;
                        }
                        if (minDistance == -1){
                            minDistance = dist;
                        }else{
                            minDistance = Math.min(minDistance, dist);
                        }
                    }else{
                        firstCriticalPoint = nodePos;
                    }
                    previousCriticalPoint = nodePos;
                }
                ++nodePos;
                prevNode = currentNode;
                currentNode = currentNode.next;
            }


            return new int[]{minDistance,maxDistance};
        }
    }
}
