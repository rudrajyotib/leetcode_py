package gfg;

/*
https://practice.geeksforgeeks.org/problems/total-decoding-messages1235/1
 */


public class TotalDecodingMessages {

    public int solve(String str){
        return new Solution().CountWays(str);
    }


    static class Solution
    {
        public int CountWays(String str)
        {
            // code here
            if (str.charAt(0) == '0'){
                return 0;
            }
            if (str.length() == 1){
                return 1;
            }
            long[] result = new long[str.length()+1];
            result[0] = 1;
            result[1] = 1;

            for(int i=1;i< str.length();i++){
                if (result[i-1] == 0){
                    return 0;
                }
                if (str.charAt(i) == '0'){
                    if ('1'==str.charAt(i-1) || '2'==str.charAt(i-1))   {
                        result[i+1] = result[i-1];
                        continue;
                    }else{
                        return 0;
                    }
                }
                int code = Integer.parseInt(str.substring(i-1, i+1));
                if (code >= 11 && code <= 26){
                    result[i+1] = result[i] + result[i-1];
                }else{
                    result[i+1] = result[i];
                }

            }

            return (int)(result[str.length()] % 1000000007L);
        }
    }

}
