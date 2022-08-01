package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnakeLadderTest {

    @Test
    public void shouldGetToFinishSet1(){
        assertEquals(4, new SnakeLadder().solve(
                new int[][]{
                        new int[]{2, 80},
                        new int[]{81,90},
                        new int[]{75,99}
                },
                new int[][]{
                    new int[]{91, 74}
                }
        ));
    }

}