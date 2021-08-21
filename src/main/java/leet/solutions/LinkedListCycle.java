package leet.solutions;
/*
https://leetcode.com/problems/linked-list-cycle/
Leetcode#141
 */


import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public boolean solve(ListNode node) {
        Solution solution = new Solution();
        return solution.hasCycle(node);
    }

    class Solution {
        public boolean hasCycle(ListNode head) {

            Set<ListNode> visited = new HashSet<>();

            while (head != null) {
                if (visited.contains(head)) {
                    return true;
                }
                visited.add(head);
                head = head.next;
            }
            return false;
        }
    }


}
