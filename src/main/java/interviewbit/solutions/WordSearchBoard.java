package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/word-search-board/
 */

public class WordSearchBoard {

    public int solve(String[] dictionary, String toSearch){
        return new Solution().exist(dictionary, toSearch);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int exist(String[] dictionary, String toSearch) {
            if (dictionary.length == 0){
                return 0;
            }
            if (dictionary[0].isEmpty()){
                return 0;
            }
            char[][] board = new char[dictionary.length][dictionary[0].length()];
            for(int i=0;i<dictionary.length;i++){
                for (int j=0;j<dictionary[0].length();j++){
                    board[i][j] = dictionary[i].charAt(j);
                }
            }
            for (int i=0;i<board.length;i++){
                for (int j=0;j<board[0].length;j++){
                    if (searchRecursive(board, i, j , 0, toSearch, board.length, board[0].length)){
                        return 1;
                    }
                }
            }
            return 0;
        }

        private boolean searchRecursive(char[][] dictionary, int row, int column, int textIndexToMatch, String toSearch, int rowCount, int colCount){
            if (!isWithinBoard(row, column, rowCount, colCount)){
                return false;
            }
            if (textIndexToMatch>=toSearch.length()){
                return false;
            }
            if (dictionary[row][column] != toSearch.charAt(textIndexToMatch)){
                return false;
            }
            if (textIndexToMatch == toSearch.length()-1){
                return true;
            }
            return searchRecursive(dictionary, row+1, column, textIndexToMatch+1, toSearch, rowCount, colCount)
                    || searchRecursive(dictionary, row-1, column, textIndexToMatch+1, toSearch, rowCount, colCount)
                    || searchRecursive(dictionary, row, column+1, textIndexToMatch+1, toSearch, rowCount, colCount)
                    || searchRecursive(dictionary, row, column-1, textIndexToMatch+1, toSearch, rowCount, colCount);
        }

        private boolean isWithinBoard(int row, int column, int rowCount, int columnCount){
            return ((row>=0) && (row<rowCount) && (column>=0) && (column<columnCount));
        }

    }



}
