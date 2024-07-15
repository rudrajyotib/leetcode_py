package gfg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UndirectedCycleGraphTest {

    @Test
    public void testCase1() {
        assertTrue(new UndirectedCycleGraph().isCycle(
                5, new ArrayList<>(
                        List.of(
                                new ArrayList<>(List.of(1)),
                                new ArrayList<>(List.of(0, 2, 4)),
                                new ArrayList<>(List.of(1, 3)),
                                new ArrayList<>(List.of(2, 4)),
                                new ArrayList<>(List.of(1, 3))
                        )
                )
        ));
    }

    @Test
    public void testCase2() {
        assertFalse(new UndirectedCycleGraph().isCycle(
                5, new ArrayList<>(
                        List.of(
                                new ArrayList<>(List.of(1)),
                                new ArrayList<>(List.of(2)),
                                new ArrayList<>(List.of(3)),
                                new ArrayList<>(List.of(4))
                        )
                )
        ));
    }

    @Test
    public void testCase3() {
        assertTrue(new UndirectedCycleGraph().isCycle(
                5, new ArrayList<>(
                        List.of(
                                new ArrayList<>(List.of(1)),
                                new ArrayList<>(List.of(2)),
                                new ArrayList<>(List.of(3)),
                                new ArrayList<>(List.of(4)),
                                new ArrayList<>(List.of(2))
                        )
                )
        ));
    }

    @Test
    public void testCase4() {
        assertFalse(new UndirectedCycleGraph().isCycle(
                5, new ArrayList<>(
                        List.of(
                                new ArrayList<>(List.of(1)),
                                new ArrayList<>(List.of(2)),
                                new ArrayList<>(List.of(3)),
                                new ArrayList<>(List.of(4)),
                                new ArrayList<>()
                        )
                )
        ));
    }

    @Test
    public void testCase5() {
        assertFalse(new UndirectedCycleGraph().isCycle(
                4, new ArrayList<>(
                        List.of(
                                new ArrayList<>(),
                                new ArrayList<>(List.of(2)),
                                new ArrayList<>(List.of(3)),
                                new ArrayList<>()
                        )
                )
        ));
    }

}