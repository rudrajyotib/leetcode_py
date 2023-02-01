package gfg;

import gfg.util.link.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlattenLinkedListTest {

    @Test
    public void set1(){
            Node head = new Node(5,
                    new Node(10,
                            new Node(19,
                                    new Node(28))));
            head.bottom=new Node(7);
            head.bottom.bottom = new Node(8);
            head.bottom.bottom.bottom = new Node(30);

            head.next.bottom = new Node(20);

            head.next.next.bottom = new Node(22);
            head.next.next.bottom.bottom = new Node(50);

            head.next.next.next.bottom = new Node(35);
            head.next.next.next.bottom.bottom = new Node(40);
            head.next.next.next.bottom.bottom.bottom = new Node(45);


      assertArrayEquals(new Integer[]{5,7,8,10,19,20,22,28,30,35,40,45,50},
              new FlattenLinkedList().solve(head).listBottom().toArray(new Integer[1]));
    }

    @Test
    public void set2(){
            Node head = new Node(5,
                    new Node(10,
                            new Node(19,
                                    new Node(28))));



      assertArrayEquals(new Integer[]{5,10,19,28},
              new FlattenLinkedList().solve(head).listBottom().toArray(new Integer[1]));
    }


}