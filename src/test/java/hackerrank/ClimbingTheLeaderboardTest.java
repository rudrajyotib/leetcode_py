package hackerrank;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class ClimbingTheLeaderboardTest {


    @Test
    public void testCase1() {
        assertArrayEquals(new Integer[]{6, 5, 4, 2, 1},
                ClimbingTheLeaderboard.climbingLeaderboard(
                        List.of(100, 90, 90, 80, 75, 60),
                        List.of(50 ,65 ,77 ,90 ,102)
                ).toArray()
        );

        assertArrayEquals(new Integer[]{6, 4, 2, 1},
                ClimbingTheLeaderboard.climbingLeaderboard(
                        List.of(100, 100, 50, 40, 40, 20, 10),
                        List.of(5, 25, 50, 120)
                ).toArray()
        );

        assertArrayEquals(new Integer[]{6,6,6,6},
                ClimbingTheLeaderboard.climbingLeaderboard(
                        List.of(100, 100, 50, 40, 40, 20, 10),
                        List.of(5, 6, 7, 8)
                ).toArray()
        );
    }

}