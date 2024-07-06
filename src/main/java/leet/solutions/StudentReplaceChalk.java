/*
https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/
 */

package leet.solutions;

public class StudentReplaceChalk {

    public int solve(int[] chalk, int k){
        return new Solution().chalkReplacer(chalk, k);
    }

    static class Solution {
        public int chalkReplacer(int[] chalk, int k) {
            long oneRoundChalk = 0;
            for (int j : chalk) {
                oneRoundChalk += j;
            }
            int lastRoundChalk = (int) ((long)k % oneRoundChalk);
            for (int i=0;i<chalk.length;i++){
                if (chalk[i] > lastRoundChalk){
                    return i;
                }
                lastRoundChalk -= chalk[i];
            }
            return -1;
        }
    }
}
