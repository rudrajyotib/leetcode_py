package gfg;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

    public boolean solve(String s1, String s2){
        return new Solution().isScramble(s1, s2);
    }

    static class Solution{
        public boolean isScramble(String s1,String s2)
        {
            //code here
            if (s1.length() != s2.length()){
                return false;
            }

            int[] s1Chars = new int[26];

            for (int i=0;i<s1.length();i++){
                ++s1Chars[s1.charAt(i)-'a'];
                --s1Chars[s2.charAt(i)-'a'];
            }
            for (int count : s1Chars){
                if (count != 0){
                    return false;
                }
            }



            Map<String, Boolean> memo = new HashMap<>();
            return isScrambleRec(s1, s2, memo);
        }

        private boolean isScrambleRec(String s1, String s2, Map<String , Boolean> memo){
            if (s1.equals(s2)){
                return true;
            }
            String key1 = s1+"_"+s2;
            String key2 = s2+"_"+s1;

            if (memo.containsKey(key1)){
                return memo.get(key1);
            }
            if (memo.containsKey(key2)){
                return memo.get(key2);
            }

            boolean result = false;

            for (int i=1;i<s1.length();i++){
                boolean swapped = isScrambleRec(s1.substring(0, i), s2.substring(s2.length()-i), memo)
                        && isScrambleRec(s1.substring(i), s2.substring(0,s2.length()-i), memo);
                boolean notSwapped = isScrambleRec(s1.substring(0, i), s2.substring(0, i), memo)
                        && isScrambleRec(s1.substring(i), s2.substring(i), memo);
                if (swapped || notSwapped){
                    result = true;
                    break;
                }
            }

            memo.put(key1, result);
            memo.put(key2, result);
            return result;
        }
    }
}
