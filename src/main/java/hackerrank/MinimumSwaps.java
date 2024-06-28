/*
https://www.hackerrank.com/challenges/minimum-swaps-2
 */

package hackerrank;

import java.util.PriorityQueue;

public class MinimumSwaps {


    static int minimumSwaps(int[] arr) {

        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i + 1) {
                continue;
            }
            priorityQueue.offer(new Integer[]{i, Math.abs(arr[i] - (i + 1))});
        }
        int swapCount = 0;

        while (!priorityQueue.isEmpty()) {
            Integer[] mismatch = priorityQueue.poll();
            if (arr[mismatch[0]] == mismatch[0] + 1) {
                continue;
            }
            int target = arr[mismatch[0]];
            int temp = arr[target - 1];
            arr[target - 1] = target;
            arr[mismatch[0]] = temp;
            priorityQueue.offer(new Integer[]{mismatch[0], Math.abs(temp - mismatch[0] - 1)});
            ++swapCount;
        }

        return swapCount;

    }

}
