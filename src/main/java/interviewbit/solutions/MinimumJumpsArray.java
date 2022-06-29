package interviewbit.solutions;

import java.util.ArrayList;

public class MinimumJumpsArray {

    public int solve(ArrayList<Integer> steps) {
        return new Solution().jump(steps);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int jump(ArrayList<Integer> A) {

            if (A.size() == 1) {
                return 0;
            }
            if (A.get(0) == 0) {
                return -1;
            }

            int stepsSize = A.size();

            int[] result = new int[A.size()];

            for (int i = 1; i < stepsSize; i++) {
                result[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if ((i <= j + A.get(j))
                            && result[j] != Integer.MAX_VALUE) {
                        result[i] = Math.min(result[i], result[j] + 1);
                        break;
                    }
                }
            }

//            Arrays.fill(result, -1);
//            result[0] = 0;
//            for (int i=0;i<stepsSize-1;i++){
//                int jumpsPossibleFromThisStep = A.get(i);
//                if (result[i] ==-1){
//                    continue;
//                }
//                for (int j=1;j<=jumpsPossibleFromThisStep;j++){
//                    if ((i+j) >= stepsSize){
//                        break;
//                    }
//                    if(result[i+j] == -1){
//                        result[i+j] = result[i]+1;
//                    }else if (result[i+j] > 0){
//                        result[i+j] = Math.min(result[i+j], result[i]+1);
//                    }
//                }
//            }


            return result[stepsSize - 1] == Integer.MAX_VALUE ? -1 : result[stepsSize - 1];
        }
    }


}
