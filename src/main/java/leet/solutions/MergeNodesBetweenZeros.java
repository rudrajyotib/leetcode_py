/*
https://leetcode.com/problems/merge-nodes-in-between-zeros
 */

package leet.solutions;

import ds.util.ListNode;

public class MergeNodesBetweenZeros {

    public ListNode solve(ListNode head){
        return new Solution().mergeNodes(head);
    }

    static class Solution {

        public ListNode mergeNodes(ListNode head){
            ListNode resultPointer = head;
            ListNode resultHead = resultPointer;
            boolean activeNode = false;
            boolean initiated = false;
            while (head!=null){
                if (head.val == 0){
                    activeNode = false;
                }else{
                    if (!activeNode){
                        if (!initiated){
                            initiated = true;
                            resultPointer = head;
                            resultHead = resultPointer;
                        }else {
                            resultPointer.next = head;
                            resultPointer = resultPointer.next;
                        }
                        activeNode = true;
                    }else{
                        resultPointer.val += head.val;
                    }
                }
                head = head.next;
            }

            assert resultPointer != null;
            resultPointer.next = null;
            return resultHead;
        }

    }
}
