package gfg;

import java.util.*;

public class MaxNumberOfToys {

    public ArrayList<Integer> solve(int[] price, ArrayList<Integer>[] queries) {
        return new Solution().maximumToys(price.length, price, queries.length, queries);
    }


    static class Solution {
        ArrayList<Integer> maximumToys(int toysCount, int[] price, int queriesCount, ArrayList<Integer>[] queries) {
            int[][] toysPriceWithPosition = new int[toysCount][2];
            for (int i = 0; i < toysCount; i++) {
                toysPriceWithPosition[i][0] = price[i];
                toysPriceWithPosition[i][1] = i;
            }
            Arrays.sort(toysPriceWithPosition, Comparator.comparingInt(o -> o[0]));

            Set<Integer> forbidden = new HashSet<>();
            ArrayList<Integer> result = new ArrayList<>(queriesCount);

            int money;
            int forbiddenCount;

            for (ArrayList<Integer> query : queries) {
                money = query.get(0);
                forbiddenCount = query.get(1);
                if (forbiddenCount > 0) {
                    for (int i = 2; i < query.size(); i++) {
                        forbidden.add(query.get(i) - 1);
                    }
                }
                int purchased = 0;
                int counter = 0;
                while (counter < toysCount && money > 0) {
                    if (!forbidden.contains(toysPriceWithPosition[counter][1])) {
                        money -= toysPriceWithPosition[counter][0];
                        if (money >= 0) {
                            ++purchased;
                        }
                    }
                    ++counter;
                }
                result.add(purchased);
                forbidden.clear();
            }


            return result;
        }
    }
}
