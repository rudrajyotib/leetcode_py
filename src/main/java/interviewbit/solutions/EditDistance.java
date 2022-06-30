package interviewbit.solutions;

public class EditDistance {

    public int solve(String fromString, String toString){
        return new Solution().minDistance(fromString, toString);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution{
        public int minDistance(String fromString, String toString){

            int[][] result = new int[fromString.length()+1][toString.length()+1];

            result[0][0] = 0;
            for (int i=1;i<=toString.length();i++){
                result[0][i] = i;
            }
            for (int i=1;i<=fromString.length();i++){
                result[i][0] = i;
            }

            for (int i=1;i<= fromString.length();i++){
                for (int j=1;j<=toString.length();j++){
                    if (toString.charAt(j-1) == fromString.charAt(i-1)){
                        result[i][j] = result[i-1][j-1];
                    }else{
                        result[i][j] = minimum(result[i-1][j], result[i][j-1], result[i-1][j-1])+1;
                    }
                }
            }

            return result[fromString.length()][toString.length()];
        }

        private int minimum(int a, int b, int c){
            return Math.min(Math.min(a,b), c);
        }
    }

}
