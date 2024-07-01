/*
https://www.hackerrank.com/challenges/lilys-homework/
 */

package hackerrank;

import java.util.*;

public class LilysHomework {


    public static int lilysHomework(List<Integer> arr) {
        // Write your code here
        List<Integer> targetListAscending = new ArrayList<>(arr.size());
        List<Integer> targetListDescending = new ArrayList<>(arr.size());
        List<Integer> clone = new ArrayList<>(arr.size());
        for (Integer num : arr) {
            targetListAscending.add(num);
            targetListDescending.add(num);
            clone.add(num);
        }
        targetListAscending.sort(Integer::compare);
        targetListDescending.sort((o1, o2) -> Integer.compare(o2, o1));
        int ascendingSwap = getSwaps(arr, targetListAscending);
        int descendingSwap = getSwaps(clone, targetListDescending);
        return Math.min(ascendingSwap, descendingSwap);
    }

    private static int getSwaps(List<Integer> arr, List<Integer> targetList) {
        Map<Integer, Integer> expectedIndices = new HashMap<>();
        for (int i = 0; i < targetList.size(); i++) {
            expectedIndices.put(targetList.get(i), i);
        }
//        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (targetList.get(i).equals(arr.get(i))) {
                continue;
            }
            queue.offer(i);
        }
        int swaps = 0;
        while (!queue.isEmpty()) {
            Integer mismatch = queue.poll();
            if (arr.get(mismatch).equals(targetList.get(mismatch))) {
                continue;
            }
            Integer expectedLocation = expectedIndices.get(arr.get(mismatch));
            Integer elementAtExpectedLocation = arr.get(expectedLocation);
            arr.set(expectedLocation, arr.get(mismatch));
            arr.set(mismatch, elementAtExpectedLocation);
            if (!arr.get(mismatch).equals(targetList.get(mismatch))) {
                queue.offer( mismatch);
            }
            ++swaps;
        }
        return swaps;
    }
}
