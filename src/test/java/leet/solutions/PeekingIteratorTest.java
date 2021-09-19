package leet.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PeekingIteratorTest {

    @Test
    public void shouldSupportIteratorFunctions() {
        List<Integer> sampleList = new ArrayList<>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(sampleList.iterator());
        assertEquals(1, peekingIterator.peek().intValue());
        assertEquals(1, peekingIterator.next().intValue());
        assertEquals(2, peekingIterator.next().intValue());
        assertEquals(3, peekingIterator.next().intValue());
        assertEquals(4, peekingIterator.peek().intValue());
        assertTrue(peekingIterator.hasNext());
        assertEquals(4, peekingIterator.next().intValue());
        assertFalse(peekingIterator.hasNext());
    }


}