package leet.solutions;

/*
https://leetcode.com/problems/candy/description/
 */


public class Candy {

    static class CandyCount {
        public int candy(Integer[] ratings) {
            int[] temp = new int[ratings.length];
            for (int i = 0; i < ratings.length; i++) {
                temp[i] = ratings[i];
            }
            return new Solution().candy(temp);
        }
    }

    static class Solution {
        public int candy(int[] ratings) {

            int[] candies = new int[ratings.length];

            candies[0] = 1;

            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                } else {
                    candies[i] = 1;
                }
            }
            int sum = candies[ratings.length - 1];
            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
                sum += candies[i];
            }


            return sum;
        }
    }

}
