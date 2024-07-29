package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class RowWithMax1sTest {


    @Test
    public void testCase1(){
        assertEquals(2, new RowWithMax1s().rowWithMax1s(
                new int[][]{
                        new int[]{0,0,0,1},
                        new int[]{0,0,1,1},
                        new int[]{0,1,0,1},
                        new int[]{0,1,0,1},
                }
        ));
    }

    @Test
    public void testCase2(){
        assertEquals(-1, new RowWithMax1s().rowWithMax1s(
                new int[][]{
                        new int[]{0,0,0,0},
                        new int[]{0,0,0,0},
                }
        ));
    }

    @Test
    public void testCase3(){
        assertEquals(3, new RowWithMax1s().rowWithMax1s(
                new int[][]{
                        new int[]{0,0,0,1},
                        new int[]{0,0,1,1},
                        new int[]{0,1,1,1},
                        new int[]{1,1,1,1},
                }
        ));
    }

    @Test
    public void testCase4(){
        assertEquals(0, new RowWithMax1s().rowWithMax1s(
                new int[][]{
                        new int[]{0,0,0,1},
                }
        ));
    }

    @Test
    public void testCase5(){
        assertEquals(4, new RowWithMax1s().rowWithMax1s(
                new int[][]{
                        new int[]{0},
                        new int[]{0},
                        new int[]{0},
                        new int[]{0},
                        new int[]{1},
                        new int[]{1},
                        new int[]{1},
                        new int[]{0},
                }
        ));
    }

    @Test
    public void testCase6(){
        assertEquals(5, new RowWithMax1s().rowWithMax1s(
                new int[][]{
                        new int[]{0,0},
                        new int[]{0,0},
                        new int[]{0,0},
                        new int[]{0,0},
                        new int[]{0,1},
                        new int[]{1,1},
                        new int[]{0,1},
                        new int[]{0,0},
                }
        ));
    }

}