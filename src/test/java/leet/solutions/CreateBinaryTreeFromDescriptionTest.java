package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateBinaryTreeFromDescriptionTest {

    @Test
    public void set1(){
        TreeNode root = new CreateBinaryTreeFromDescription().solve(
            new int[][]{
                    new int[]{20,15,1},
                    new int[]{20,17,0},
                    new int[]{50,20,1},
                    new int[]{50,80,0},
                    new int[]{80,19,1}
            }
        );
        assertEquals("152017501980", root.inOrder());
    }

    @Test
    public void set2(){
        TreeNode root = new CreateBinaryTreeFromDescription().solve(
            new int[][]{
                    new int[]{1,2,1},
                    new int[]{2,3,0},
                    new int[]{3,4,1}
            }
        );
        assertEquals("2431", root.inOrder());
    }


}