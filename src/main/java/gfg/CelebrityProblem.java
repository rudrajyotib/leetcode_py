/*
https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
 */

package gfg;

public class CelebrityProblem {

    public int celebrity(int[][] mat) {
        // code here

        int length = mat.length;
        for (int i=0;i<length;i++){
            boolean allZeros = true;
            for (int j=0;j<length;j++){
                if (mat[i][j] != 0){
                    allZeros = false;
                    break;
                }
            }
            if (!allZeros ){
                continue;
            }
            boolean allColOne = true;
            for (int j=0;j<length;j++){
                    if (mat[j][i] == 0){
                        if (i != j) {
                            allColOne = false;
                        }
                        break;
                    }
            }
            if (allColOne){
                return i;
            }
        }
        return -1;


    }


}
