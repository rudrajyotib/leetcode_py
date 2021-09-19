package leet.solutions;

/*
https://leetcode.com/problems/lru-cache/
Leetcode#146
 */

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


    static class ListNode
    {
        private final int key;
        private int value;
        private ListNode next;
        private ListNode prev;


        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    static class LruLinkedList
    {
        private int size = 0;
        private ListNode head;
        private ListNode tail;

        public ListNode addNode(int key, int value)
        {
            ListNode listNode = new ListNode(key, value);
            if (this.size == 0)
            {
                this.head = listNode;
            }else
            {
                listNode.prev = this.tail;
                this.tail.next = listNode;
            }
            this.tail = listNode;
            ++size;
            return listNode;
        }

        public ListNode deleteFirst()
        {
            if (this.size == 0)
            {
                return null;
            }
            if (this.size == 1)
            {
                ListNode temp = this.head;
                this.head = null;
                this.tail = null;
                this.size = 0;
                return temp;
            }
            ListNode temp = this.head;
            this.head = temp.next;
            this.head.prev = null;
            --this.size;
            temp.next = null;
            temp.prev = null;
            return temp;
        }

        public void moveToEnd(ListNode listNode)
        {
            if (listNode == null)
            {
                return;
            }
            if (this.size <= 1)
            {
                return;
            }
            if (listNode.prev == null)
            {
                this.head = this.head.next;
                this.head.prev = null;
                listNode.prev = this.tail;
                this.tail.next = listNode;
                listNode.next = null;
                this.tail = listNode;
            }else {
                if (listNode.next != null) {
                    listNode.prev.next = listNode.next;
                    listNode.next.prev = listNode.prev;
                    this.tail.next = listNode;
                    listNode.prev = this.tail;
                    this.tail = listNode;
                    this.tail.next = null;
                }
            }
        }

    }

    private final LruLinkedList cacheAccessSequence;
    private final int capacity;
    private final Map<Integer, ListNode> cache;




    public LRUCache(int capacity) {
        this.cacheAccessSequence = new LruLinkedList();
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity, 1);
    }

    public int get(int key) {
        if (!cache.containsKey(key))
        {
            return -1;
        }
        ListNode nodeKey = this.cache.get(key);
        this.cacheAccessSequence.moveToEnd(nodeKey);
        return nodeKey.value;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key))
        {
            this.cacheAccessSequence.moveToEnd(cache.get(key));
            this.cache.get(key).value=value;
        }else
        {
            if (this.cacheAccessSequence.size == this.capacity)
            {
                ListNode evictedKey = this.cacheAccessSequence.deleteFirst();
                if (evictedKey != null) {
                    this.cache.remove(evictedKey.key);
                }
            }
            ListNode listNode = this.cacheAccessSequence.addNode(key, value);
            this.cache.put(key, listNode);
        }
    }


}
