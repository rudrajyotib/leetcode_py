package gfg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BridgeEdgeInGapTest {

    @Test
    public void testCase1(){
        assertEquals(1,
                BridgeEdgeInGap.isBridge(
                        4, new ArrayList<>(List.of(
                                new ArrayList<>(List.of(1)),
                                new ArrayList<>(List.of(0, 2)),
                                new ArrayList<>(List.of(1, 3)),
                                new ArrayList<>(List.of(2))
                        )), 1, 2
                ));
    }

    @Test
    public void testCase2(){
        assertEquals(0,
                BridgeEdgeInGap.isBridge(
                        5, new ArrayList<>(List.of(
                                new ArrayList<>(List.of(1,2,3)),
                                new ArrayList<>(List.of(0, 2)),
                                new ArrayList<>(List.of(1, 0)),
                                new ArrayList<>(List.of(0,4)),
                                new ArrayList<>(List.of(3))
                        )), 0, 2
                ));
    }

}