package gfg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DijkstraTest {

    @Test
    public void testCase1(){
        ArrayList<ArrayList<Integer>> from0 = new ArrayList<>(
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(1,1)),
                        new ArrayList<>(List.of(2,6))
                ))
        );
        ArrayList<ArrayList<Integer>> from1 = new ArrayList<>(
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(2,3)),
                        new ArrayList<>(List.of(0,1))
                ))
        );
        ArrayList<ArrayList<Integer>> from2 = new ArrayList<>(
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(1,3)),
                        new ArrayList<>(List.of(0,6))
                ))
        );
        assertArrayEquals(new int[]{4, 3, 0},
                Dijkstra.dijkstra(
                        3,
                       new ArrayList<>(new ArrayList<>(List.of(from0, from1, from2))), 2
                )
        );
    }

}