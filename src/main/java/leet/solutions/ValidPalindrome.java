package leet.solutions;

/*
https://leetcode.com/problems/valid-palindrome/
Leetcode#125
 */


public class ValidPalindrome {


    public boolean isPalindrome(String s)
    {
        Solution solution = new Solution();
        return solution.isPalindrome(s);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public boolean isPalindrome(String s) {

            s = s.toLowerCase();
            int startIndex = 0;
            int endIndex = s.length()-1;
            int asciiValueStart;
            int asciiValueEnd;
            boolean alphanumericStart;
            boolean alphanumericEnd;
            while (startIndex <= endIndex)
            {
                asciiValueStart = s.charAt(startIndex);
                asciiValueEnd = s.charAt(endIndex);
                alphanumericStart = isAlphaNumeric(asciiValueStart);
                alphanumericEnd = isAlphaNumeric(asciiValueEnd);

                if (!alphanumericStart)
                {
                    ++startIndex;
                }
                if (!alphanumericEnd)
                {
                    --endIndex;
                }
                if (alphanumericStart && alphanumericEnd )
                {
                    if ((asciiValueStart!=asciiValueEnd)) {
                        return false;
                    }
                    ++startIndex;
                    --endIndex;
                }
            }
            return true;

        }

        private boolean isAlphaNumeric(int ascii)
        {
            return (  (  (ascii>=97 && ascii<=122) || (ascii>=48 && ascii<=57) ) );
        }
    }
}
