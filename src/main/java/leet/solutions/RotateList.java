package leet.solutions;

/*
https://leetcode.com/problems/rotate-list/
Leetcode#61
 */


import ds.util.ListNode;

public class RotateList {


    public ListNode solve(ListNode head, int k)
    {
        Solution solution = new Solution();
        return solution.rotateRight(head, k);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {

            if (head == null)
            {
                return null;
            }

            int size = 0;
            ListNode temp = head;
            while (temp != null)
            {
                ++size;
                temp = temp.next;
            }

            int realShift = k % size;
            if (realShift == 0)
            {
                return head;
            }else
            {
                temp = head;
                for (int i=1;i<(size-realShift);i++)
                {
                    temp = temp.next;
                }
                ListNode newHead = temp.next;
                temp.next = null;
                temp = newHead;
                while (temp.next != null)
                {
                    temp = temp.next;
                }
                temp.next = head;
                return newHead;
            }

        }
    }


}
