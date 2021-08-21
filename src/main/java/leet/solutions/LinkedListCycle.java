package leet.solutions;
/*
https://leetcode.com/problems/linked-list-cycle/
Leetcode#141
 */


public class LinkedListCycle {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public boolean solve(ListNode node) {
        Solution solution = new Solution();
        return solution.hasCycle(node);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            if (head.next == null) {
                return false;
            }
            if (head.next.next == null) {
                return false;
            }
            ListNode jumpOneStep = head.next;
            ListNode jumpTwoStep = head.next.next;

            while ((jumpTwoStep != null) && (jumpOneStep != null)) {
                if (jumpOneStep == jumpTwoStep) {
                    return true;
                }
                jumpOneStep = jumpOneStep.next;
                jumpTwoStep = jumpTwoStep.next;
                if (jumpTwoStep != null) {
                    jumpTwoStep = jumpTwoStep.next;
                }
            }
            return false;
        }
    }


}
