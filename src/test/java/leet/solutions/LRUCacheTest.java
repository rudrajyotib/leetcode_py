package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void shouldAddAndEvictWhenNeeded()
    {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put(1, 100);
        lruCache.put(2, 200);
        lruCache.put(3, 300);
        lruCache.put(4, 400);
        lruCache.put(5, 500);
        lruCache.put(6, 600);
        assertEquals(-1, lruCache.get(1));
        lruCache.put(2, 201);
        lruCache.put(1, 101);
        assertEquals(-1, lruCache.get(3));
        assertEquals(400, lruCache.get(4));
    }

    @Test
    public void shouldSupportSingleNodeLruCache()
    {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(1, 10);
        lruCache.put(2, 20);
        assertEquals(-1, lruCache.get(1));
        assertEquals(20, lruCache.get(2));
        assertEquals(20, lruCache.get(2));
    }

    @Test
    public void lruCacheTestSet1()
    {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertEquals(1, lruCache.get(1));
        lruCache.put(3, 3);
        assertEquals(-1, lruCache.get(2));
        lruCache.put(4, 4);
        assertEquals(-1, lruCache.get(1));
        assertEquals(3, lruCache.get(3));
        assertEquals(4, lruCache.get(4));

    }


    @Test
    public void lruCacheTestSet2()
    {
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(10,13);
        lruCache.put(3,17);
        lruCache.put(6,11);
        lruCache.put(10,5);
        lruCache.put(9,10);
        lruCache.get(13);
        lruCache.put(2,19);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.put(5,25);
        lruCache.get(8);
        lruCache.put(9,22);
        lruCache.put(5,5);
        lruCache.put(1,30);
        lruCache.get(11);
        lruCache.put(9,12);
        lruCache.get(7);
        lruCache.get(5);
        lruCache.get(8);
        lruCache.get(9);
        lruCache.put(4,30);
        lruCache.put(9,3);
        lruCache.get(9);
        lruCache.get(10);
        lruCache.get(10);
        lruCache.put(6,14);
        lruCache.put(3,1);
        lruCache.get(3);
        lruCache.put(10,11);
        lruCache.get(8);
        lruCache.put(2,14);
        lruCache.get(1);
        lruCache.get(5);
        lruCache.get(4);
        lruCache.put(11,4);
        lruCache.put(12,24);
        lruCache.put(5,18);
        lruCache.get(13);
        lruCache.put(7,23);
        lruCache.get(8);
        lruCache.get(12);
        lruCache.put(3,27);
        lruCache.put(2,12);
        lruCache.get(5);
        lruCache.put(2,9);
        lruCache.put(13,4);
        lruCache.put(8,18);
        lruCache.put(1,7);
        lruCache.get(6);
        lruCache.put(9,29);
        lruCache.put(8,21);
        lruCache.get(5);
        lruCache.put(6,30);
        lruCache.put(1,12);
        lruCache.get(10);
        lruCache.put(4,15);
        lruCache.put(7,22);
        lruCache.put(11,26);
        lruCache.put(8,17);
        lruCache.put(9,29);
        lruCache.get(5);
        lruCache.put(3,4);
        lruCache.put(11,30);
        lruCache.get(12);
        lruCache.put(4,29);
        lruCache.get(3);
        lruCache.get(9);
        lruCache.get(6);
        lruCache.put(3,4);
        lruCache.get(1);
        lruCache.get(10);
        lruCache.put(3,29);
        lruCache.put(10,28);
        lruCache.put(1,20);
        lruCache.put(11,13);
        lruCache.get(3);
        lruCache.put(3,12);
        lruCache.put(3,8);
        lruCache.put(10,9);
        lruCache.put(3,26);
        lruCache.get(8);
        lruCache.get(7);
        lruCache.get(5);
        lruCache.put(13,17);
        lruCache.put(2,27);
        lruCache.put(11,15);
        lruCache.get(12);
        lruCache.put(9,19);
        lruCache.put(2,15);
        lruCache.put(3,16);
        lruCache.get(1);
        lruCache.put(12,17);
        lruCache.put(9,1);
        lruCache.put(6,19);
        lruCache.get(4);
        lruCache.get(5);
        lruCache.get(5);
        lruCache.put(8,1);
        lruCache.put(11,7);
        lruCache.put(5,2);
        lruCache.put(9,28);
        lruCache.get(1);
        lruCache.put(2,2);
        lruCache.put(7,4);
        lruCache.put(4,22);
        lruCache.put(7,24);
        lruCache.put(9,26);
        lruCache.put(13,28);
        lruCache.put(11,26);
    }


}