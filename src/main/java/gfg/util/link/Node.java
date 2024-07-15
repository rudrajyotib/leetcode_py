package gfg.util.link;


import java.util.ArrayList;
import java.util.LinkedList;

public class Node {
    public int data;
    public Node next;
    public Node bottom;

    public Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }

    public Node(int d, Node next){
        this.data = d;
        this.next = next;
        this.bottom = null;
    }

    public LinkedList<Integer> listBottom(){
        LinkedList<Integer> list = new LinkedList<>();
        Node temp = this;
        while (temp != null){
            list.add(temp.data);
            temp = temp.bottom;
        }
        return list;
    }

    public Integer[] toArray(){
        Node head = this;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null){
            arrayList.add(head.data);
            head = head.next;
        }
        return arrayList.toArray(new Integer[0]);
    }

    public static Node createLinkedList(Integer[] nums){
        Node head = new Node(nums[0]);
        Node temp = head;
        for (int i=1;i< nums.length; i++){
            temp.next = new Node(nums[i]);
            temp=temp.next;
        }
        return head;
    }
}
