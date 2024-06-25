package leet.solutions;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GetWatchedVideosByYourFriendsTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new String[]{"B","C"},
                Arrays.stream(new GetWatchedVideosByYourFriends().solve(
                        List.of(List.of("A","B"), List.of("C"), List.of("B", "C"), List.of("D")),
                        new int[][]{new int[]{1,2},new int[]{0,3}, new int[]{0,3}, new int[]{1,2}}, 0, 1
                ).toArray(new String[1])).sorted().toArray());
    }

    @Test
    public void testCase2(){
        assertArrayEquals(new String[]{"D"},
                Arrays.stream(new GetWatchedVideosByYourFriends().solve(
                        List.of(List.of("A","B"), List.of("C"), List.of("B", "C"), List.of("D")),
                        new int[][]{new int[]{1,2},new int[]{0,3}, new int[]{0,3}, new int[]{1,2}}, 0, 2
                ).toArray(new String[1])).sorted().toArray());
    }


}