/*
https://leetcode.com/problems/string-compression/
 */

package leet.solutions;

public class StringCompression {

    public int solve(char[] chars){
        return new Solution().compress(chars);
    }

    static class Solution {
        public int compress(char[] chars) {

            if (chars.length == 1){
                return 1;
            }

            int leftPointer = 0;
            int rightPointer = 1;
            int updatePointer = -1;

            while (rightPointer<chars.length){
                if (chars[rightPointer] != chars[leftPointer]){
                    int length = rightPointer - leftPointer;
                    if (length == 1){
                        chars[++updatePointer] = chars[leftPointer];
                    }else{
                        String compress = ""+chars[leftPointer]+length;
                        for (int i=0;i<compress.length();i++){
                            chars[++updatePointer] = compress.charAt(i);
                        }
                    }
                    leftPointer = rightPointer;
                }
                ++rightPointer;
            }
            int length = rightPointer - leftPointer;
            if (length == 1){
                chars[++updatePointer] = chars[leftPointer];
            }else{
                String compress = ""+chars[leftPointer]+length;
                for (int i=0;i<compress.length();i++){
                    chars[++updatePointer] = compress.charAt(i);
                }
            }

            return ++updatePointer;
        }
    }

}
