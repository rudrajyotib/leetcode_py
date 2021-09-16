package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SurroundedRegionsTest {


    @Test
    public void shouldIdentifySurroundedRegion()
    {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] board = new char[][]
                {
                        {'X','X','X','X'},
                        {'X','O','O','X'},
                        {'X','X','O','X'},
                        {'X','O','X','X'}
                };
        surroundedRegions.solve(board);
        assertEquals('X', board[1][1]);
        assertEquals('X', board[1][2]);
        assertEquals('X', board[2][2]);
    }

    @Test
    public void shouldNotIdentifyAnySurroundedRegion()
    {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] board = new char[][]
                {
                        {'X','X','X','X'},
                        {'X','O','O','X'},
                        {'X','X','O','X'},
                        {'X','X','O','X'}
                };
        surroundedRegions.solve(board);
        assertEquals('O', board[1][1]);
        assertEquals('O', board[1][2]);
        assertEquals('O', board[2][2]);
        assertEquals('O', board[3][2]);
    }

    @Test
    public void shouldNotAlterSingleRowStructure()
    {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] board = new char[][]
                {
                        {'X','X','X','O','X'}
                };
        surroundedRegions.solve(board);
        assertEquals('O', board[0][3]);
    }

}