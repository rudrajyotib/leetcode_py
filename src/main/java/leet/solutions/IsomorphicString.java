/*
https://leetcode.com/problems/isomorphic-strings
 */

package leet.solutions;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public boolean solve(String s, String t){
        return  new Solution().isIsomorphic(s, t);
    }

    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> sCharMap = new HashMap<>();
            Map<Character, Character> tCharMap = new HashMap<>();
            for (int i=0;i<s.length();i++){
                if (sCharMap.containsKey(s.charAt(i))){
                    if (!sCharMap.get(s.charAt(i)).equals(t.charAt(i))){
                        return false;
                    }
                }else{
                    sCharMap.put(s.charAt(i), t.charAt(i));
                }
                if(tCharMap.containsKey(t.charAt(i))){
                    if (!tCharMap.get(t.charAt(i)).equals(s.charAt(i))){
                        return false;
                    }
                }else{
                    tCharMap.put(t.charAt(i), s.charAt(i));
                }
            }

            return true;
        }
    }
}
