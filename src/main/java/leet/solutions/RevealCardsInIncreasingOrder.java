/*
https://leetcode.com/problems/reveal-cards-in-increasing-order
 */

package leet.solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {

    public int[] solve(int[] deck){
        return new Solution().deckRevealedIncreasing(deck);
    }

    static class Solution {
        public int[] deckRevealedIncreasing(int[] deck) {
            Arrays.sort(deck);

            Queue<Integer> queue = new LinkedList<>();
            int deckIndex = 0;
            int[] result = new int[deck.length];

            for (int i=0;i<deck.length;i++){
                queue.add(i);
            }
            while (!queue.isEmpty()){
                int popIndex = queue.poll();
                result[popIndex] = deck[deckIndex];
                ++deckIndex;
                if (!queue.isEmpty()) {
                    int toSendBack = queue.poll();
                    queue.add(toSendBack);
                }
            }

            return result;
        }
    }

}
