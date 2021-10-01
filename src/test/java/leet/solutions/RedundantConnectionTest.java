package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class RedundantConnectionTest {

    @Test
    public void shouldFindRedundantConnection()
    {
        RedundantConnection redundantConnection = new RedundantConnection();
        assertArrayEquals(new int[]{3, 4},
                redundantConnection.solve(new int[][]{{0, 1},
                        {0, 2},
                        {1, 3},
                        {1, 4},
                        {3, 4},
                        {2, 5},
                        {5, 6},
                        {5, 7}}));
    }


}