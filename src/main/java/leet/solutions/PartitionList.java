package leet.solutions;

/*
https://leetcode.com/problems/partition-list/
Leetcode#86
 */

import ds.util.ListNode;

public class PartitionList {




    public ListNode solve(ListNode head, int x)
    {
        Solution solution = new Solution();
        return solution.partition(head, x);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null)
            {
                return null;
            }
            //find tempHead where detachment starts
            ListNode lastElementBeforePartition ;
            if (head.val >= x)
            {
                lastElementBeforePartition = null;
            }else {
                lastElementBeforePartition = head;
                while (true) {
                    if ((lastElementBeforePartition.next != null) &&
                            (lastElementBeforePartition.next.val >= x)) {
                        break;
                    } else if (lastElementBeforePartition.next == null) {
                        return head;
                    } else {
                        lastElementBeforePartition = lastElementBeforePartition.next;
                    }
                }
            }

            ListNode headOfRightPartition = lastElementBeforePartition == null ? head : lastElementBeforePartition.next;
            ListNode pointer = headOfRightPartition;
            ListNode headOfShuffledNodes = null;
            ListNode tailOfShuffledNodes = null;
            while (pointer.next != null)
            {

                if (pointer.next.val < x)
                {
                    ListNode nextPointer = pointer.next;
                    pointer.next = nextPointer.next;
                    nextPointer.next = null;
                    if (tailOfShuffledNodes == null)
                    {
                        headOfShuffledNodes = nextPointer;
                        tailOfShuffledNodes = nextPointer;
                    }else
                    {
                        tailOfShuffledNodes.next = nextPointer;
                        tailOfShuffledNodes = tailOfShuffledNodes.next;
                    }
                }else
                {
                    pointer = pointer.next;
                }
            }

            if (lastElementBeforePartition == null)
            {
                if (headOfShuffledNodes == null)
                {
                    return head;
                }
                tailOfShuffledNodes.next = headOfRightPartition;
                return headOfShuffledNodes;
            }else
            {
                if (headOfShuffledNodes != null) {
                    lastElementBeforePartition.next = headOfShuffledNodes;
                    tailOfShuffledNodes.next = headOfRightPartition;
                }
                return head;
            }

        }
    }

}
