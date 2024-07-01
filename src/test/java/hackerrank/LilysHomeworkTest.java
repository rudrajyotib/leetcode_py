package hackerrank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LilysHomeworkTest {

    @Test
    public void testCase1(){
        assertEquals(2, LilysHomework.lilysHomework(new ArrayList<>(List.of(2,5,3,1))));
        assertEquals(2, LilysHomework.lilysHomework(new ArrayList<>(List.of(3,4,2,5,1))));
    }

}