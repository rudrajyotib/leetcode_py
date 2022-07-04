package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("unchecked")
public class RemoveDuplicatesTest {

    @SuppressWarnings("rawtypes")
    private final ArrayList<Integer>[][] testCases = new ArrayList[][]{
            new ArrayList[]{new ArrayList(List.of(1, 2, 3, 4)), new ArrayList(Arrays.asList(1, 2, 3, 3, 4))},
            new ArrayList[]{new ArrayList(List.of(1, 2, 3)), new ArrayList(Arrays.asList(1, 2, 3))},
            new ArrayList[]{new ArrayList(List.of(1)), new ArrayList(Arrays.asList(1, 1, 1, 1, 1, 1, 1))},
            new ArrayList[]{new ArrayList(List.of(1)), new ArrayList(List.of(1))},
            new ArrayList[]{new ArrayList(List.of(1, 2)), new ArrayList(Arrays.asList(1, 2, 2, 2, 2, 2))},
    };


    @Test
    public void shouldExecuteTestCases() {
        for (int i = 0; i < testCases.length; i++) {
            int result = new RemoveDuplicates().solve(testCases[i][1]);
            assertEquals(String.format("Index does not match for test case %d", i + 1),
                    testCases[i][0].size(), result);
            assertArrayEquals(String.format("Elements do not match for test case %d", i + 1),
                    testCases[i][0].toArray(new Integer[1]),
                    testCases[i][1].subList(0, result).toArray(new Integer[1]));
        }
    }


}