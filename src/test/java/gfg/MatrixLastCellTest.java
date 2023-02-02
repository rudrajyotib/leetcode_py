package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixLastCellTest {

    @Test
    public void set1(){
        assertArrayEquals(new int[]{2,0}, new MatrixLastCell().solve(new int[][]{
                new int[]{0, 1, 1, 1, 0},
                new int[]{1, 0, 1, 0, 1},
                new int[]{1, 1, 1, 0, 0}
        }));
    }

    @Test
    public void set2(){
        assertArrayEquals(new int[]{1,1}, new MatrixLastCell().solve(new int[][]{
                new int[]{0, 1},
                new int[]{1, 0}
        }));
    }

    @Test
    public void set3(){
        assertArrayEquals(new int[]{2,0}, new MatrixLastCell().solve(new int[][]{
                new int[]{1, 0},
                new int[]{0, 1},
                new int[]{1, 0}
        }));
    }


}