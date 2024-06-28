/*
https://www.hackerrank.com/challenges/new-year-chaos/
 */

package hackerrank;

import java.util.List;

public class NewYearChaos {

    public static int minimumBribes(List<Integer> q) {
        // Write your code here
        Integer[] originalPosition = new Integer[q.size()];
        for (int i=0;i<q.size();i++){
            originalPosition[i] = i+1;
        }
        int bribes = 0;
        for (int i=0;i<q.size();i++){
            if (originalPosition[i].equals(q.get(i))){
                continue;
            }
            int j = i+1;
            while (!q.get(i).equals(originalPosition[j])){
                ++j;
            }
            if ((j-i)>2){
                return -1;
            }
            bribes += (j-i);
            move(originalPosition, i, (j-i));
        }
        return bribes;
    }

    private static void move(Integer[] originalPositions, int startIndex, int moveCount){
        int endPosition = startIndex+moveCount;
        Integer briber = originalPositions[endPosition];
        for (int i=0;i<moveCount;i++){
            originalPositions[endPosition] = originalPositions[endPosition-1];
            --endPosition;
        }
        originalPositions[startIndex] = briber;
    }

}
