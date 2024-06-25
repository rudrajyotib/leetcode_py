package leet.solutions;

import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

public class CriticalConnectionsInNetworkTest {

    @Test
    public void testCase1() {
        List<List<Integer>> result = new CriticalConnectionsInNetwork().solve(
                4,
                List.of(
                        List.of(0, 1),
                        List.of(1, 2),
                        List.of(2, 0),
                        List.of(1, 3)
                )
        );
        assertArrayEquals(new Integer[]{1, 3},
                result.stream().flatMap((Function<List<Integer>, Stream<Integer>>) Collection::stream).sorted().toArray(Integer[]::new));
    }

}