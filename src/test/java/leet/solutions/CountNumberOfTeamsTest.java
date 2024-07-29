package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountNumberOfTeamsTest {

    @Test
    public void testCase1(){
        assertEquals(3, new CountNumberOfTeams().solve(new int[]{2,5,3,4,1}));
        assertEquals(0, new CountNumberOfTeams().solve(new int[]{2,1,3}));
        assertEquals(4, new CountNumberOfTeams().solve(new int[]{1,2,3,4}));
    }

}