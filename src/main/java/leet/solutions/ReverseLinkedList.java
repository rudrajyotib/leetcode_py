package leet.solutions;

/*
https://leetcode.com/problems/reverse-linked-list/
Leetcode#206
 */


import ds.util.ListNode;

import java.util.Stack;

public class ReverseLinkedList {



    public ListNode solve(ListNode node)
    {
        Solution solution = new Solution();
        return solution.reverseList(node);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public ListNode reverseList(ListNode head) {

            if (head == null)
            {
                return null;
            }

            Stack<ListNode> stack = new Stack<>();
            while (head != null) {
                stack.add(head);
                head = head.next;
            }
            ListNode reverseHeadHolyGrail = stack.pop();
            ListNode reverseHead = reverseHeadHolyGrail;
            while (!stack.isEmpty()) {
                reverseHead.next = stack.pop();
                reverseHead = reverseHead.next;
            }
            reverseHead.next = null;
            return reverseHeadHolyGrail;
        }
    }

}
