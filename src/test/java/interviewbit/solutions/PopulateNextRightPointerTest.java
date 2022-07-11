package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class PopulateNextRightPointerTest {

    @Test
    public void shouldGenerateLinkSet1(){
        PopulateNextRightPointer.TreeLinkNode treeLinkNode =
                new PopulateNextRightPointer.TreeLinkNode(1,
                        new PopulateNextRightPointer.TreeLinkNode(2,
                                new PopulateNextRightPointer.TreeLinkNode(4,
                                        new PopulateNextRightPointer.TreeLinkNode(6),
                                        null),
                                new PopulateNextRightPointer.TreeLinkNode(5,
                                        new PopulateNextRightPointer.TreeLinkNode(7),
                                        null)),
                        new PopulateNextRightPointer.TreeLinkNode(3,
                                null,
                                new PopulateNextRightPointer.TreeLinkNode(8,
                                        null,
                                        new PopulateNextRightPointer.TreeLinkNode(9))));
       new PopulateNextRightPointer().solve(treeLinkNode);
        assertNull(treeLinkNode.next);
        assertEquals(3, treeLinkNode.left.next.val);
        assertNull(treeLinkNode.right.next);
        assertEquals(8, treeLinkNode.left.left.next.next.val);
        assertNull(treeLinkNode.right.right.next);
        assertEquals(9, treeLinkNode.left.left.left.next.next.val);
        assertNull(treeLinkNode.right.right.right.next);
    }

    @Test
    public void shouldGenerateLinkSet2(){
        PopulateNextRightPointer.TreeLinkNode treeLinkNode =
                new PopulateNextRightPointer.TreeLinkNode(1,
                        new PopulateNextRightPointer.TreeLinkNode(2,
                                new PopulateNextRightPointer.TreeLinkNode(3,
                                        new PopulateNextRightPointer.TreeLinkNode(4),
                                        null),
                                null),
                        new PopulateNextRightPointer.TreeLinkNode(5,
                                null,
                                new PopulateNextRightPointer.TreeLinkNode(6,
                                        null,
                                        new PopulateNextRightPointer.TreeLinkNode(7))));
        new PopulateNextRightPointer().solve(treeLinkNode);
        assertNull(treeLinkNode.next);
        assertEquals(5, treeLinkNode.left.next.val);
        assertEquals(6, treeLinkNode.left.left.next.val);
        assertEquals(7, treeLinkNode.left.left.left.next.val);

        assertNull(treeLinkNode.right.next);
        assertNull(treeLinkNode.right.right.next);
        assertNull(treeLinkNode.right.right.right.next);
    }

}