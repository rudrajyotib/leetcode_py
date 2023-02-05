package gfg;

import gfg.util.link.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionPointOfLinkedListsTest {

    @Test
    public void set1(){
        Node common = new Node(15, new Node(20, new Node(30)));
        assertEquals(15, new IntersectionPointOfLinkedLists().solve(
                new Node(5, new Node(6, new Node(7, common))),
                new Node(10, common)
        ));
    }

    @Test
    public void set2(){
        Node common = new Node(15, new Node(20, new Node(30)));
        assertEquals(-1, new IntersectionPointOfLinkedLists().solve(
                new Node(5, new Node(6, new Node(7, common))),
                new Node(10, new Node(20, new Node(30, new Node(40))))
        ));
    }


}