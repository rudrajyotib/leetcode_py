package gfg;

/*
https://practice.geeksforgeeks.org/problems/case-specific-sorting-of-strings4845/1
 */


import java.util.Arrays;

public class CaseSpecificSortingOfStrings {

    public String solve(String str){
        return new Solution().caseSort(str);
    }


    static class Solution
    {
        //Function to perform case-specific sorting of strings.
        public String caseSort(String str)
        {
            int upperCaseCount = 0;
            int lowerCaseCount;
            char[] result = new char[str.length()];
            for (int i=0;i<str.length();i++){
                if (str.charAt(i)<=90){
                    ++upperCaseCount;
                }
            }
            lowerCaseCount = str.length() - upperCaseCount;
            int upperCaseCounter = 0;
            int lowerCaseCounter = 0;
            char[] upperCaseChars = new char[upperCaseCount];
            char[] lowerCaseChars = new char[lowerCaseCount];
            for (int i=0;i<str.length();i++){
                if (str.charAt(i)<=90){
                    upperCaseChars[upperCaseCounter++] = str.charAt(i);
                }else{
                    lowerCaseChars[lowerCaseCounter++] = str.charAt(i);
                }
            }
            Arrays.sort(upperCaseChars);
            Arrays.sort(lowerCaseChars);
            upperCaseCounter = 0;
            lowerCaseCounter = 0;
            for (int i=0;i<str.length();i++){
                if (str.charAt(i)<=90){
                    result[i]=upperCaseChars[upperCaseCounter++];
                }else{
                    result[i]=lowerCaseChars[lowerCaseCounter++];
                }
            }

            // Your code here
            return new String(result);
        }
    }

}
