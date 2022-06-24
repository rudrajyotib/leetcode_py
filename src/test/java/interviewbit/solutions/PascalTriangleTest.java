package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PascalTriangleTest {

    @Test
    public void shouldCreatePascalTriangleForOneRow() {
        ArrayList<ArrayList<Integer>> triangle=new PascalTriangle().solve(1);
        assertEquals(1, triangle.size());
        assertEquals(1, triangle.get(0).size());
        assertEquals(1, triangle.get(0).get(0).intValue());
    }

    @Test
    public void shouldCreatePascalTriangleForTwoRows() {
        ArrayList<ArrayList<Integer>> triangle=new PascalTriangle().solve(2);
        assertEquals(2, triangle.size());
        assertEquals(1, triangle.get(0).size());
        assertEquals(1, triangle.get(0).get(0).intValue());
        assertArrayEquals(new Integer[]{1,1}, triangle.get(1).toArray(new Integer[1]));
    }

    @Test
    public void shouldCreatePascalTriangleForSixRows() {
        ArrayList<ArrayList<Integer>> triangle=new PascalTriangle().solve(6);
        assertEquals(6, triangle.size());
        assertEquals(1, triangle.get(0).size());
        assertEquals(1, triangle.get(0).get(0).intValue());
        assertArrayEquals(new Integer[]{1,1}, triangle.get(1).toArray(new Integer[1]));
        assertArrayEquals(new Integer[]{1,2,1}, triangle.get(2).toArray(new Integer[1]));
        assertArrayEquals(new Integer[]{1,3,3,1}, triangle.get(3).toArray(new Integer[1]));
        assertArrayEquals(new Integer[]{1,4,6,4,1}, triangle.get(4).toArray(new Integer[1]));
        assertArrayEquals(new Integer[]{1,5,10,10,5,1}, triangle.get(5).toArray(new Integer[1]));
    }


}