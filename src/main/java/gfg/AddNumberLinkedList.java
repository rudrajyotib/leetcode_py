/*
https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists
 */

package gfg;

import gfg.util.link.Node;

import java.util.Stack;

public class AddNumberLinkedList {

    static Node addTwoLists(Node num1, Node num2) {
        // code here
        // return head of sum list
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        Node temp = num1;
        while (temp != null){
            stack1.push(temp.data);
            temp = temp.next;
        }
        temp = num2;
        while (temp != null){
            stack2.push(temp.data);
            temp = temp.next;
        }

        Stack<Integer> result = new Stack<>();

        Integer carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            int add = stack1.pop() + stack2.pop() + carry;
            if (add > 9 ){
                carry = 1;
                result.push(add - 10);
            }else{
                carry = 0;
                result.push(add);
            }
        }
        if (!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                int add = stack1.pop() + carry;
                if (add > 9 ){
                    carry = 1;
                    result.push(add - 10);
                }else{
                    carry = 0;
                    result.push(add);
                }
            }
        }
        while (!stack2.isEmpty()){
            int add = stack2.pop() + carry;
            if (add > 9 ){
                carry = 1;
                result.push(add - 10);
            }else{
                carry = 0;
                result.push(add);
            }
        }
        if (carry == 1){
            result.push(1);
        }

        Node resultHead = null;
        Node resultPointer = null;
        boolean firstNonZeroDigitFound = false;
        while (!result.isEmpty()){
            Integer num = result.pop();
            if (!firstNonZeroDigitFound){
                if(num>0){
                    firstNonZeroDigitFound = true;
                    resultHead = new Node(num);
                    resultPointer = resultHead;
                }
            }else {
                resultPointer.next = new Node(num);
                resultPointer = resultPointer.next;
            }
        }
        if (!firstNonZeroDigitFound){
            resultHead = new Node(0);
        }
        return resultHead;

    }

}
