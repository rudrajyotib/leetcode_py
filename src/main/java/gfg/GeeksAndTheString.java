package gfg;

/*
https://practice.geeksforgeeks.org/problems/466faca80c3e86f13880710491c634d26abd44a7/1
 */

import java.util.Stack;

public class GeeksAndTheString {

    public String solve(String s){
        return new Solution().removePair(s);
    }


    static class Solution {
        public  String removePair(String s) {
            // code here
            Stack<Character> chars = new Stack<>();
            for (int i=0;i<s.length();i++){
                if (chars.isEmpty()){
                    chars.push(s.charAt(i));
                }else{
                    if (s.charAt(i) == chars.peek()){
                        chars.pop();
                    }else{
                        chars.push(s.charAt(i));
                    }
                }
            }
            char[] arr = new char[chars.size()];
            for (int i=arr.length-1;i>=0;i--){
                arr[i] = chars.pop();
            }


            return new String(arr);
        }
    }


}
