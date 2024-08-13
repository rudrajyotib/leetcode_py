/*
https://leetcode.com/problems/kth-largest-element-in-a-stream
 */

package leet.solutions;

import java.util.PriorityQueue;

@SuppressWarnings("DataFlowIssue")
public class KthLargest {

    private final PriorityQueue<Integer> priorityQueue;
    private final int limit;

    public KthLargest(int k, int[] nums) {
        this.priorityQueue = new PriorityQueue<>(k);
        this.limit = k;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                this.priorityQueue.offer(nums[i]);
            } else {
                if (this.priorityQueue.peek() <= nums[i]) {
                    this.priorityQueue.remove();
                    this.priorityQueue.offer(nums[i]);
                }
            }
        }
    }

    public int add(int val) {
        if (this.priorityQueue.size() < this.limit) {
            this.priorityQueue.offer(val);
        } else {
            if (this.priorityQueue.peek() <= val) {
                this.priorityQueue.remove();
                this.priorityQueue.offer(val);
            }
        }
        return this.priorityQueue.peek();

    }
}
