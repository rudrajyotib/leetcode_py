/*
https://leetcode.com/problems/count-and-say/
 */

package leet.solutions;

public class CountAndSay {

    public String solve(int n){
        return new Solution().countAndSay(n);
    }

    static class Solution {
        public String countAndSay(int n) {
            if (n == 1){
                return "1";
            }
            if (n == 2){
                return "11";
            }
            String result = "11";
            for (int i=3;i<=n;i++){
                StringBuilder stringBuilder = new StringBuilder();
                char[] chars = result.toCharArray();
                int repeatCount = 1;
                for (int j=1;j<chars.length;j++){
                    if (chars[j]==chars[j-1]){
                        ++repeatCount;
                    }else{
                        stringBuilder.append(repeatCount);
                        stringBuilder.append(chars[j-1]);
                        repeatCount = 1;
                    }
                }
                stringBuilder.append(repeatCount);
                stringBuilder.append(chars[chars.length-1]);
                result = stringBuilder.toString();
            }
            return result ;
        }
    }

}
