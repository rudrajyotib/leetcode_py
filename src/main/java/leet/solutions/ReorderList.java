package leet.solutions;

/*
https://leetcode.com/problems/reorder-list/
Leetcode#143
 */


import ds.util.ListNode;

import java.util.Stack;

public class ReorderList {



    public void solve(ListNode head) {
        Solution solution = new Solution();
        solution.reorderList(head);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public void reorderList(ListNode head) {

            ListNode counterHead = head;
            Stack<ListNode> stack = new Stack<>();
            int length = 0;
            while (counterHead != null) {
                ++length;
                stack.add(counterHead);
                counterHead = counterHead.next;
            }

            int reorderLength = 1;
            ListNode replicateHead = head;
            ListNode nextNode = head.next;
            boolean flip = true;
            while (reorderLength <= length) {
                ++reorderLength;
                if (flip) {
                    ListNode temp = stack.pop();
                    replicateHead.next = temp;
                    replicateHead = temp;
                } else {
                    replicateHead.next = nextNode;
                    nextNode = nextNode.next;
                    replicateHead = replicateHead.next;
                }
                flip = !flip;
            }
            replicateHead.next = null;

        }
    }

}
