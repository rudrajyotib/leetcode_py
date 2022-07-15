package interviewbit.solutions;

import ds.util.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeListTest {

    @Test
    public void shouldIdentifyOddSizeListAsPalindrome(){
        assertTrue(new PalindromeList().isPalindrome(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(2,
                                                new ListNode(1)))))
        ));
    }

    @Test
    public void shouldIdentifyEvenSizeListAsPalindrome(){
        assertTrue(new PalindromeList().isPalindrome(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(3,
                                                new ListNode(2,
                                                        new ListNode(1))))))
        ));
    }

    @Test
    public void shouldNotIdentifyOddSizeListAsPalindrome(){
        assertFalse(new PalindromeList().isPalindrome(
                new ListNode(1,
                        new ListNode(5,
                                new ListNode(3,
                                        new ListNode(2,
                                                new ListNode(1)))))
        ));
    }

    @Test
    public void shouldNotIdentifyEvenSizeListAsPalindrome(){
        assertFalse(new PalindromeList().isPalindrome(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(2,
                                                        new ListNode(1))))))
        ));
    }

    @Test
    public void shouldIdentifySingleNodeListAsPalindrome(){
        assertTrue(new PalindromeList().isPalindrome(
                new ListNode(1)
        ));
    }

    @Test
    public void shouldHandleNull(){
        assertFalse(new PalindromeList().isPalindrome(null));
    }

    @Test
    public void shouldIdentifyPalindromeForTwoSizedList(){
        assertTrue(new PalindromeList().isPalindrome(
                new ListNode(1, new ListNode(1))
        ));
    }

    @Test
    public void shouldNotIdentifyPalindromeForTwoSizedList(){
        assertFalse(new PalindromeList().isPalindrome(
                new ListNode(1, new ListNode(2))
        ));
    }




}