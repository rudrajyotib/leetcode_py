package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListCycleTest {

    @Test
    public void shouldDetectLoopStartingNodeInLongList(){
        ListNode[] listNodes = new ListNode[10];
        for (int i=0;i<10;i++){
            listNodes[i] = new ListNode(i);
        }
        for (int i=0;i<9;i++){
            listNodes[i].next = listNodes[i+1];
        }

        listNodes[9].next = listNodes[6];

        assertEquals(6, new ListCycle().solve(
                listNodes[0]
        ).val);
    }

    @Test
    public void shouldDetectSmallLoopStartingNodeInLongList(){
        ListNode[] listNodes = new ListNode[10];
        for (int i=0;i<10;i++){
            listNodes[i] = new ListNode(i);
        }
        for (int i=0;i<9;i++){
            listNodes[i].next = listNodes[i+1];
        }

        listNodes[9].next = listNodes[8];

        assertEquals(8, new ListCycle().solve(
                listNodes[0]
        ).val);
    }

    @Test
    public void shouldDetectSmallLoopStartingNodeInSmallList(){
        ListNode[] listNodes = new ListNode[2];
        for (int i=0;i<2;i++){
            listNodes[i] = new ListNode(i);
        }
        listNodes[0].next = listNodes[1];
        listNodes[1].next = listNodes[0];

        assertEquals(0, new ListCycle().solve(
                listNodes[0]
        ).val);
    }

}