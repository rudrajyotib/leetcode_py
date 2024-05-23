package interviewbit.solutions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LargestRectangleAreaTest{

    public static final List<List<Integer[]>> testCases = List.of(
            List.of(new Integer[]{2, 1, 5, 6, 2, 3}, new Integer[]{10}),
            List.of(new Integer[]{17, 91, 27, 4, 80, 78}, new Integer[]{156}),
            List.of(new Integer[]{200,1,2,3}, new Integer[]{200}),
            List.of(new Integer[]{2}, new Integer[]{2}),
            List.of(new Integer[]{2,1,2}, new Integer[]{3})
    );

    @Test
    public void test(){
        testCases.forEach(integers -> Assert.assertEquals(integers.get(1)[0].intValue(), new LargestRectangleArea().solve(new ArrayList<>(List.of(integers.get(0))))));
    }

}