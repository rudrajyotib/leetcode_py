package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameTest {

    @Test
    public void shouldEvaluateJump()
    {
        JumpGame jumpGame = new JumpGame();
        assertTrue(jumpGame.solve(new int[]{1,2,3,4}));
        assertFalse(jumpGame.solve(new int[]{1,2,3,4,0,0,0,0,1}));
        assertFalse(jumpGame.solve(new int[]{1,0,1}));
        assertTrue(jumpGame.solve(new int[]{1,2,3,4,0,0,0,1}));
        assertTrue(jumpGame.solve(new int[]{1}));
    }

}