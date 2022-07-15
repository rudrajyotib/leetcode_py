package leet.solutions;
/*
https://leetcode.com/problems/merge-two-sorted-lists/
Leetcode#21
 */


import ds.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLists {


    public Integer[] merge(int[] l1, int[] l2)
    {

        ListNode list1 = new ListNode(l1[0]);
        ListNode nextNode = list1;
        for (int i=1; i<l1.length; i++)
        {
            ListNode tempNode  = new ListNode(l1[i]);
            nextNode.next = tempNode;
            nextNode = tempNode;
        }

        ListNode list2 = new ListNode(l2[0]);
        nextNode = list2;
        for (int i=1; i<l2.length; i++)
        {
            ListNode tempNode  = new ListNode(l2[i]);
            nextNode.next = tempNode;
            nextNode = tempNode;
        }

        Solution solution = new Solution();

        ListNode result = solution.mergeTwoLists(list1, list2);
        List<Integer> resultList = new ArrayList<>();
        while (result != null)
        {
            resultList.add(result.val);
            result = result.next;
        }
        return resultList.toArray(new Integer[1]);
    }


    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = new ListNode();
            ListNode tempResult = result;

            while ((l1 != null) && (l2 != null)) {
                if (l1.val <= l2.val) {
                    tempResult.next = new ListNode(l1.val);
                    tempResult = tempResult.next;
                    l1 = l1.next;
                } else {
                    tempResult.next = new ListNode(l2.val);
                    tempResult = tempResult.next;
                    l2 = l2.next;
                }
            }
            if (l1 != null)
            {
                while (l1 != null)
                {
                    tempResult.next = new ListNode(l1.val);
                    tempResult = tempResult.next;
                    l1 = l1.next;
                }
            }
            if (l2 != null)
            {
                while (l2 != null)
                {
                    tempResult.next = new ListNode(l2.val);
                    tempResult = tempResult.next;
                    l2 = l2.next;
                }
            }

            result = result.next;
            return result;
        }
    }
}



