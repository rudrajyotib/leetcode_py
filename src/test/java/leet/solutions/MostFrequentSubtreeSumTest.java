package leet.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MostFrequentSubtreeSumTest {

    @Test
    public void set1(){
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(-3);
        assertArrayEquals(new int[]{-3,2,4}, Arrays.stream(new MostFrequentSubtreeSum().solve(treeNode)).sorted().toArray());
    }

    @Test
    public void set2(){
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(-5);
        assertArrayEquals(new int[]{2}, Arrays.stream(new MostFrequentSubtreeSum().solve(treeNode)).sorted().toArray());
    }

    @Test
    public void set3(){
        TreeNode treeNode = new TreeNode(2);
        assertArrayEquals(new int[]{2}, Arrays.stream(new MostFrequentSubtreeSum().solve(treeNode)).sorted().toArray());
    }

    @Test
    public void set4(){
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(2);
        assertArrayEquals(new int[]{2, 4}, Arrays.stream(new MostFrequentSubtreeSum().solve(treeNode)).sorted().toArray());
    }


}