package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedArrayToBalancedBSTTest {

    @Test
    public void set1(){
        TreeNode root = new SortedArrayToBalancedBST().solve(new int[]{1,2,3,4,5,6,7,8});
        assertEquals(4, root.val);
        assertEquals("12345678",root.inOrder());
    }

}