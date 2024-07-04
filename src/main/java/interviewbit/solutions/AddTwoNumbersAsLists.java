/*
https://www.interviewbit.com/problems/add-two-numbers-as-lists/
 */

package interviewbit.solutions;

import ds.util.ListNode;

public class AddTwoNumbersAsLists {

    public ListNode solve(ListNode a, ListNode b){
        return new Solution().addTwoNumbers(a, b);
    }

    public static class Solution {
        public ListNode addTwoNumbers(ListNode A, ListNode B) {
            ListNode result = null;
            ListNode resultHead = null;
            int carry = 0;
            while (A!= null && B!= null){
                int add = A.val + B.val + carry;
                carry = add / 10;
                add = add %10;
                if (result == null){
                    result = new ListNode(add);
                    resultHead = result;
                }else{
                    result.next = new ListNode(add);
                    result = result.next;
                }
                A= A.next;
                B = B.next;
            }
            if (A==null && B==null){
                if (carry > 0 ){
                    result.next = new ListNode(carry);
                }
            }
            if (A!=null){
                processSingleNonEmptyList(A, result, carry);
            }
            if (B!=null){
                processSingleNonEmptyList(B, result, carry);
            }


            return resultHead;
        }

        private void processSingleNonEmptyList(ListNode listNode, ListNode resultPointer, int carry){
            while (listNode != null){
                int add = listNode.val + carry;
                carry = add/10;
                add = add %10;
                resultPointer.next = new ListNode(add);
                resultPointer = resultPointer.next;
                listNode = listNode.next;
            }
            if (carry > 0){
                resultPointer.next = new ListNode(carry);
            }
        }
    }

}
