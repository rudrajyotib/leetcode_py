package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoTeamsTest {

    @Test
    public void shouldMarkTeamsPossibleFromSpannedTree(){
        assertTrue(new TwoTeams().possible(
                5,
                new int[][]{
                        new int[]{1, 5},
                        new int[]{1,2},
                        new int[]{2,3},
                        new int[]{4,2}
                }
        ));
    }

    @Test
    public void shouldMarkTeamsNotPossibleFromSpannedTree(){
        assertFalse(new TwoTeams().possible(
                4,
                new int[][]{
                        new int[]{1, 2},
                        new int[]{1,3},
                        new int[]{1,4},
                        new int[]{3,4},
                }
        ));
    }

    @Test
    public void shouldMarkTeamsPossibleFromTreeWhichDoesNotHaveAllNodes(){
        assertTrue(new TwoTeams().possible(
                6,
                new int[][]{
                        new int[]{1, 2},
                        new int[]{1,3},
                        new int[]{5,4}
                }
        ));
    }


}