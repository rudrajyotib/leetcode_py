/*
https://www.hackerrank.com/challenges/even-tree
 */

package hackerrank;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EvenTreeTest {

    @Test
    public void testCase1(){
        assertEquals(2, EvenTree.evenForest(
                10, 9,
                List.of(2, 3, 4, 5, 6, 7, 8, 9, 10),
                List.of(1,1,3,2,1,2,6,8,8)
        ));
    }

}