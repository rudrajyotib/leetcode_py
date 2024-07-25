package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructBinaryTreeFromParentArrayTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new Integer[]{6,5,3,1,4,0,2},
                new ConstructBinaryTreeFromParentArray().createTree(new int[]{-1, 0, 0, 1, 1, 3,5})
                        .inOrder().toArray(new Integer[0]));
    }

    @Test
    public void testCase2(){
        assertArrayEquals(new Integer[]{25,17,24,4,13,1,21,0,7,15,30,3,23,9,27,11,28,16,26,32,33,6,22,19,29,5,12,10,14,20,8,31,2,18},
                new ConstructBinaryTreeFromParentArray().createTree(new int[]{1,13,31,7,17,33,27,1,5,15,19,3,33,17,19,21,23,25,31,11,29,13,27,7,25,-1,23,15,3,11,21,5,9,9})
                        .levelOrder().toArray(new Integer[0]));
    }



}