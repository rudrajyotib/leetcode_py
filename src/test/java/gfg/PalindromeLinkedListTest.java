package gfg;

import gfg.util.link.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeLinkedListTest {

    @Test
    public void testCase1(){
        assertFalse(PalindromeLinkedList.isPalindrome(Node.createLinkedList(new Integer[]{1,2,3})));
        assertFalse(PalindromeLinkedList.isPalindrome(Node.createLinkedList(new Integer[]{1,2,3,4,2,1})));
        assertTrue(PalindromeLinkedList.isPalindrome(Node.createLinkedList(new Integer[]{1,2,2,1})));
        assertTrue(PalindromeLinkedList.isPalindrome(Node.createLinkedList(new Integer[]{1,2,3,3,2,1})));
        assertTrue(PalindromeLinkedList.isPalindrome(Node.createLinkedList(new Integer[]{1,2,1})));
        assertTrue(PalindromeLinkedList.isPalindrome(Node.createLinkedList(new Integer[]{1,2,3,2,1})));
        assertTrue(PalindromeLinkedList.isPalindrome(Node.createLinkedList(new Integer[]{1,1})));
        assertFalse(PalindromeLinkedList.isPalindrome(Node.createLinkedList(new Integer[]{1,2})));
    }

    @Test
    public void testCase2(){






    }

}