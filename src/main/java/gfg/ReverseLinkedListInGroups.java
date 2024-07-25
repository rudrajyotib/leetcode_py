/*
https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size
 */

package gfg;

import gfg.util.link.Node;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseLinkedListInGroups {

    public static Node reverse(Node node, int k)
    {
        if (node == null){
            return null;
        }
        if (node.next == null){
            return node;
        }
        //Your code here
        Node nav = node;
        Queue<Node> list = new LinkedList<>();
        while (nav != null) {
            Node temp = nav;
            int counter = 1;
            list.add(temp);
            while (counter < k && temp != null){
                ++counter;
                temp = temp.next;
            }
            if (temp != null){
                nav = temp.next;
                temp.next = null;
            }else{
                nav = null;
            }
        }
        Node tail = list.remove();
        Node returnHead = recur(tail);
        while (!list.isEmpty()){
            Node n = list.remove();
            tail.next = recur(n);
            tail = n;
        }
        return returnHead;
    }

    private static Node recur(Node node){
        if (node.next == null){
            return node;
        }
        Node temp = node.next;
        node.next = null;
        Node rev = recur(temp);
        temp.next = node;
        return rev;
    }
}
