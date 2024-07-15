package gfg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GraphBfsTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new Integer[]{0 ,1 ,2 ,4 ,8 ,5 ,6 ,9 ,7},
                new GraphBfs().bfsOfGraph(10,
                        new ArrayList<>(
                                List.of(
                                        new ArrayList<>(List.of(1,2,4,8)),
                                        new ArrayList<>(List.of(5,6,9)),
                                        new ArrayList<>(List.of(4)),
                                        new ArrayList<>(List.of(7,8)),
                                        new ArrayList<>(),
                                        new ArrayList<>(List.of(8)),
                                        new ArrayList<>(List.of(7,9)),
                                        new ArrayList<>(),
                                        new ArrayList<>()

                                )
                        )).toArray(new Integer[0]));
    }

}