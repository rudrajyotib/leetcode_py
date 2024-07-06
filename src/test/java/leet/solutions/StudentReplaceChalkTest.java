package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentReplaceChalkTest {

    @Test
    public void testCase1(){
        assertEquals(0, new StudentReplaceChalk().solve(
                new int[]{5,1,5}, 22
        ));
    }

}