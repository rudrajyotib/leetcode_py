/*
https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/
 */

package leet.solutions;

import ds.util.ListNode;

public class DoubleNumberAsLinkedList {

    public ListNode solve(ListNode head){
        return new Solution().doubleIt(head);
    }


    static class Solution {
        public ListNode doubleIt(ListNode head) {
            ListNode tempHead = head;
            ListNode resultHead = new ListNode();
            ListNode pristine = resultHead;
            int headDoubled = head.val * 2;
            if (headDoubled > 9 ){
                resultHead.val = 1;
                resultHead.next = new ListNode(headDoubled - 10);
                resultHead = resultHead.next;
            }else {
                resultHead.val = headDoubled;
            }
            tempHead = tempHead.next;
            while (tempHead != null){
                int doubled = tempHead.val * 2;
                if (doubled <= 9){
                    resultHead.next = new ListNode(doubled);
                }else {
                    resultHead.val += 1;
                    resultHead.next = new ListNode(doubled - 10);
                }
                resultHead = resultHead.next;
                tempHead = tempHead.next;
            }
            return pristine;
        }
    }

}
