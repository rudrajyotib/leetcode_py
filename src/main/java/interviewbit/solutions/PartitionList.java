package interviewbit.solutions;

import ds.util.ListNode;

public class PartitionList {

    public ListNode solve(ListNode list, int mid){
        return new Solution().partition(list, mid);
    }



    public static class Solution {
        public ListNode partition(ListNode A, int B) {

            ListNode leftHead = null;
            ListNode leftTail = null;
            ListNode rightHead = null;
            ListNode rightTail = null;

            ListNode pointer = A;
            while (pointer != null){
                if (pointer.val < B){
                    if (leftHead == null){
                        leftHead = pointer;
                        leftTail = pointer;
                    }else{
                        leftTail.next = pointer;
                        leftTail = leftTail.next;
                    }
                }else{
                    if(rightHead == null){
                        rightHead = pointer;
                        rightTail = pointer;
                    }else{
                        rightTail.next = pointer;
                        rightTail = rightTail.next;
                    }
                }
                pointer = pointer.next;
            }

            if (leftHead == null){
                return rightHead;
            }else if (rightHead == null){
                return leftHead;
            }

            leftTail.next = rightHead;
            rightTail.next = null;

            return leftHead;
        }
    }


}
