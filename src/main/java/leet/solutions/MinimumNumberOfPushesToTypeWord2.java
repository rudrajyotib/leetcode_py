/*
https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii
 */

package leet.solutions;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfPushesToTypeWord2 {


    public int solve(String word) {
        return new Solution().minimumPushes(word);
    }

    static class Solution {
        public int minimumPushes(String word) {
            int[] frequency = new int[26];
            int distinct = 0;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (frequency[c - 'a'] == 0) {
                    ++distinct;
                }
                ++frequency[c - 'a'];
            }
            Integer[] frequencies = new Integer[distinct];
            int counter = 0;
            for (int i = 0; i < 26; i++) {
                if (frequency[i] > 0) {
                    frequencies[counter] = frequency[i];
                    ++counter;
                }
            }
            Arrays.sort(frequencies, Comparator.reverseOrder());
            int repeatCount = 0;
            int pushes = 0;
            for (Integer f : frequencies) {
                int p = (repeatCount / 8) + 1;
                pushes += (p * f);
                ++repeatCount;
            }
            return pushes;
        }
    }

}
