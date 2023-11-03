package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BstIteratorTest {

    @Test
    public void set1(){
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(7,
                                null,
                                new TreeNode(8))));

        BstIterator.Solution bstIterator = new BstIterator.Solution(root);
        StringBuilder result = new StringBuilder();
        while (bstIterator.hasNext()){
            result.append(bstIterator.next());
        }
        assertEquals("12345678", result.toString());
    }

    @Test
    public void set2(){
        TreeNode root = new TreeNode(4,
                null,
                new TreeNode(5,
                        null,
                        new TreeNode(7,
                                new TreeNode(6),
                                new TreeNode(8))));

        BstIterator.Solution bstIterator = new BstIterator.Solution(root);
        StringBuilder result = new StringBuilder();
        while (bstIterator.hasNext()){
            result.append(bstIterator.next());
        }
        assertEquals("45678", result.toString());
    }


}