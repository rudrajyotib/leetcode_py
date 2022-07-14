package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SuppressWarnings({"unchecked", "rawtypes"})
public class MaximumOnesAfterModificationTest {

    private final List[] testCases = new ArrayList[]{
            new ArrayList<>(List.of(6, 2, 1, 1, 1, 1, 1, 1)),
            new ArrayList<>(List.of(3, 2, 1, 0, 0, 0, 0, 1)),
            new ArrayList<>(List.of(6, 5, 1, 0, 0, 0, 0, 1)),
            new ArrayList<>(List.of(5, 2, 1, 0, 0, 0, 0, 1, 1, 1)),
    };

    @Test
    public void shouldExecuteTestCases() {
        for (int i = 0; i < testCases.length; i++) {
            assertEquals(String.format("Test case %d failed", i + 1),
                    testCases[i].get(0),
                    new MaximumOnesAfterModification().solve(
                            new ArrayList<Integer>(testCases[i].subList(2, testCases[i].size())),
                            (int) testCases[i].get(1)
                    ));
        }
    }


}