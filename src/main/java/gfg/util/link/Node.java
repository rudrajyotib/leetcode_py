package gfg.util.link;

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
}
