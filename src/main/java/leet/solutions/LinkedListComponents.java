/*
https://leetcode.com/problems/linked-list-components
 */

package leet.solutions;

import ds.util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {

    public int solve(ListNode head, int[] nums) {
        return new Solution().numComponents(head, nums);
    }


    static class Solution {
        public int numComponents(ListNode head, int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int connectedComponent = 0;
            boolean inConnection = false;

            while (head != null) {
                if (set.contains(head.val)) {
                    if (!inConnection) {
                        ++connectedComponent;
                        inConnection = true;
                    }
                } else {
                    inConnection = false;
                }
                head = head.next;
            }


            return connectedComponent;
        }
    }

}
