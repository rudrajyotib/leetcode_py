package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfIslandsTest {

    @Test
    public void shouldCountIslands()
    {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        assertEquals(1, numberOfIslands.solve(new char[][]{{'1','1'},{'1','1'}}));
        assertEquals(1, numberOfIslands.solve(new char[][]{{'1','1'},{'1','0'}}));
        assertEquals(2, numberOfIslands.solve(new char[][]{{'1','0'},{'0','1'}}));
        assertEquals(1, numberOfIslands.solve(new char[][]{{'1'}}));
        assertEquals(1, numberOfIslands.solve(new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}}));
        assertEquals(1, numberOfIslands.solve(new char[][]{{'1','0','1','1','1'},{'1','0','1','0','1'},{'1','1','1','0','1'}}));

    }

}