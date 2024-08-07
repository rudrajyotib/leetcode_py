/*
https://leetcode.com/problems/minimum-penalty-for-a-shop/
 */

package leet.solutions;

public class MinimumPenaltyForShop {

    public int solve(String customers) {
        return new Solution().bestClosingTime(customers);
    }

    static class Solution {
        public int bestClosingTime(String customers) {

            int[] ys = new int[customers.length()];
            char[] chars = customers.toCharArray();
//            int[] ns = new int[customers.length()];

            if (chars[0] == 'Y') {
                ys[0] = 1;
            }
            for (int i = 1; i < chars.length; i++) {
                ys[i] = ys[i - 1];
                if (chars[i] == 'Y') {
                    ++ys[i];
                }
            }
            int yCount = ys[chars.length - 1];
            int minIndex = 0;
            int minPenalty = yCount;
            int nCount = customers.length() - yCount;

            for (int i = 1; i < customers.length(); i++) {
                int pen;
                if (chars[i] == 'Y') {
                    pen = yCount - ys[i - 1] + (i + 1 - ys[i]);
                } else {
                    pen = (i - ys[i]) + yCount - ys[i];
                }
                if (pen < minPenalty) {
                    minPenalty = pen;
                    minIndex = i;
                }
            }
            if (nCount < minPenalty) {
                return customers.length();
            }
            return minIndex;
        }
    }
}
