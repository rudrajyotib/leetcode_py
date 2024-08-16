/*
https://www.geeksforgeeks.org/problems/cutted-segments1642/1
 */

package gfg;

import java.util.HashMap;
import java.util.Map;

public class MaximizeTheCutSegments {

    public int maximizeCuts(int n, int x, int y, int z)
    {
        Map<Integer, Integer> memo = new HashMap<>();
        //Your code here
        int max = maxRec(n, x, y, z, memo);
        return max != -1 ? max : 0;
    }

    private int maxRec(int n, int x, int y, int z, Map<Integer, Integer> memo){
        if (memo.containsKey(n)){
            return memo.get(n);
        }
        if (n == 0){
            return 0;
        }
        if (n < 0 ){
            return -1;
        }
        int maxX = maxRec(n-x, x, y, z, memo);
        if (maxX != -1){
            maxX+=1;
        }
        int maxY = maxRec(n -y, x , y , z, memo);
        if (maxY != -1){
            maxY+=1;
        }
        int maxZ = maxRec( n-z, x, y, z, memo);
        if (maxZ != -1){
            maxZ +=1;
        }
        int max = Math.max(maxX, Math.max(maxY, maxZ));
        memo.put(n, max);
        return max;
    }

}
