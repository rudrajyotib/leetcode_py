package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseSubstringBetweenEachPairOfParenthesesTest {


    @Test
    public void testCase1(){
        assertEquals("banana", new ReverseSubstringBetweenEachPairOfParentheses().solve("b(na)ana"));
        assertEquals("banana", new ReverseSubstringBetweenEachPairOfParentheses().solve("banana"));
        assertEquals("leetcode", new ReverseSubstringBetweenEachPairOfParentheses().solve("(ed(et(oc))el)"));
    }

}