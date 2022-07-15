package ds.util;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){

    }

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int x, ListNode next){
        this.val = x;
        this.next = next;
    }

    public List<Integer> toList(){
        List<Integer> list = new ArrayList<>();
        list.add(val);
        ListNode pointer = next;
        while (pointer != null){
            list.add(pointer.val);
            pointer = pointer.next;
        }
        return list;
    }
}
