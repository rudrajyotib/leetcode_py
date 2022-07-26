package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/woodcutting-made-easy/
 */

import java.util.Arrays;

public class WoodcuttingMadeEasy {


    public int solve(int[] trees, int height){
        return new Solution().solve(trees, height);
    }

    public static class Solution {
        public int solve(int[] A, int B) {
            Arrays.sort(A);
            int maxCut = 0;
            int minHeightCutIndex = -1;
            for (int i = A.length-2;i>=0;i--){
                maxCut = 0;
                for (int j=i+1;j<A.length;j++){
                    maxCut = maxCut + (A[j]-A[i]);
                }
                if (maxCut >= B){
                    minHeightCutIndex = i;
                    break;
                }
            }
            if (maxCut == B){
                return A[minHeightCutIndex];
            }
            int low = minHeightCutIndex == -1 ? 0 : A[minHeightCutIndex];
            int high = A[minHeightCutIndex+1];
            int lastKnownMid = (low + high) / 2;
            while (low <= high){
                int mid = (low+high)/2;
                int totalLength = 0;
                for (int i=minHeightCutIndex+1;i<A.length;i++){
                    totalLength += (A[i] - mid);
                }
                if (totalLength == B){
                    return mid;
                }else if (totalLength > B ){
                    low = mid +1;
                    lastKnownMid = mid;
                }else{
                    high = mid-1 ;
                }
            }
            return lastKnownMid;
        }
    }

}
