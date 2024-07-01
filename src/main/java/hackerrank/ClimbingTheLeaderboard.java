/*
https://www.hackerrank.com/challenges/climbing-the-leaderboard
 */

package hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClimbingTheLeaderboard {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new LinkedList<>();
        List<Integer> uniqueNumbers = new ArrayList<>();
        uniqueNumbers.add(ranked.get(0));
        for (int i = 1; i < ranked.size(); i++) {
            if (ranked.get(i).equals(uniqueNumbers.get(uniqueNumbers.size() - 1))) {
                continue;
            }
            uniqueNumbers.add(ranked.get(i));
        }
        int uniqueRanksSize = uniqueNumbers.size();
        for (Integer score : player) {
            if (score < uniqueNumbers.get(uniqueRanksSize - 1)) {
                result.add(uniqueRanksSize + 1);
            } else if (score > uniqueNumbers.get(0)) {
                result.add(1);
            } else {
                result.add(binarySearch(0, uniqueRanksSize - 1, uniqueNumbers, score) + 1);
            }
        }

        return result;
    }

    private static int binarySearch(int s, int e, List<Integer> r, Integer t) {
        int m = (s + e) / 2;
        if (t.equals(r.get(m))) {
            return m;
        }
        if (t.equals(r.get(m + 1))) {
            return m + 1;
        }
        if (t > r.get(m)) {
            return binarySearch(s, m - 1, r, t);
        }
        if (t < r.get(m) && t > r.get(m + 1)) {
            return m + 1;
        }
        return binarySearch(m + 1, e, r, t);
    }
}
