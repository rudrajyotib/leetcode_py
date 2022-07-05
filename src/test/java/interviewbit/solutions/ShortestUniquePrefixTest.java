package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestUniquePrefixTest {


    @Test
    public void shouldFindUniquePrefixSet1(){
        assertArrayEquals(new String[]{"z","a","b"},
                new ShortestUniquePrefix().solve(new String[]{"zebra","apple","ball"}));
    }

    @Test
    public void shouldFindUniquePrefixSet2(){
        assertArrayEquals(new String[]{"zion","ziom","ziox"},
                new ShortestUniquePrefix().solve(new String[]{"zion","ziom","ziox"}));
    }

    @Test
    public void shouldFindUniquePrefixSet3(){
        assertArrayEquals(new String[]{"z","dog","du","dov"},
                new ShortestUniquePrefix().solve(new String[]{"zebra","dog","duck","dove"}));
    }


}