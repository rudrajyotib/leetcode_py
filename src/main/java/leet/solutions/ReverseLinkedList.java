package leet.solutions;

/*
https://leetcode.com/problems/reverse-linked-list/
Leetcode#206
 */


import ds.util.ListNode;

import java.util.Stack;

public class ReverseLinkedList {



    public ListNode solve(ListNode node, boolean stack)
    {
        Solution solution = new Solution();
        if (stack){
            return solution.reverseListStack(node);
        }
        return solution.reverseList(node);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public ListNode reverseListStack(ListNode head) {

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

        public ListNode reverseList(ListNode node){
            if (node == null){
                return  null;
            }
            if (node.next == null){
                return  node;
            }
            return recursiveReverse(node);
        }

        private ListNode recursiveReverse(ListNode node){
            if (node.next == null){
                return node;
            }
            ListNode temp = node.next;
            ListNode head = recursiveReverse(node.next);
            node.next = null;
            temp.next = node;
            return head;
        }
    }

}
