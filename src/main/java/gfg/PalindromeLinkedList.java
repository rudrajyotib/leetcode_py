package gfg;

import gfg.util.link.Node;

import java.util.Stack;

public class PalindromeLinkedList {

    public static boolean isPalindrome(Node head)
    {
        //Your code here

        if (head.next == null){
            return true;
        }

        if (head.next.next == null){
            return head.data == head.next.data;
        }

        int length = 0;
        Node temp = head;
        while (temp!= null){
            ++length;
            temp = temp.next;
        }

        int mid = (length-1) / 2;
        temp = head;
        for (int i=1;i<mid;i++){
            temp = temp.next;
        }

        Node secondHalfStart = (mid%2==1)?temp.next.next:temp.next;

        Stack<Node> stack = new Stack<>();
        while (secondHalfStart != null){
            stack.push(secondHalfStart);
            secondHalfStart = secondHalfStart.next;
        }

        while (!stack.isEmpty()){
            if (head.data != stack.peek().data){
                return false;
            }
            stack.pop();
            head = head.next;
        }
        return true;


    }

}
