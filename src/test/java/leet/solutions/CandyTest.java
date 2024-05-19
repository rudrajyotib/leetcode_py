package leet.solutions;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CandyTest  {

    public static final List<List<Integer[]>> testCases = List.of(
            List.of(new Integer[]{1, 0, 2}, new Integer[]{5}),
            List.of(new Integer[]{2,1,2,4,6,3,9}, new Integer[]{15}),
            List.of(new Integer[]{2,1,2,4,6,6,3,2,9}, new Integer[]{20})
    );

    @Test
    public void test(){
        testCases.forEach(integers -> Assert.assertEquals(integers.get(1)[0].intValue(), new Candy.CandyCount().candy(integers.get(0))));
    }

}