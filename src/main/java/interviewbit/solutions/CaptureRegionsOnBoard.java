package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/capture-regions-on-board/
 */

import java.util.ArrayList;

public class CaptureRegionsOnBoard {

    public void solve(ArrayList<ArrayList<Character>> board){
        new Solution().solve(board);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public void solve(ArrayList<ArrayList<Character>> board) {
            if (board.isEmpty()){
                return;
            }
            if (board.get(0).isEmpty()){
                return;
            }
            if (board.size()==1){
                return;
            }
            if (board.get(0).size()==1){
                return;
            }
            int rowCount = board.size();
            int columnCount = board.get(0).size();
            boolean[][] visitTracker = new boolean[rowCount][columnCount];
            for (int i=0;i<columnCount;i++){
                visitRecursive(board, visitTracker, 0, i, rowCount, columnCount);
            }
            for (int i=1;i<rowCount;i++){
                visitRecursive(board, visitTracker, i, columnCount-1, rowCount, columnCount);
            }
            for (int i=0;i<columnCount-1;i++){
                visitRecursive(board, visitTracker, rowCount-1, i, rowCount, columnCount);
            }
            for (int i=1;i<rowCount-1;i++){
                visitRecursive(board, visitTracker, i, 0, rowCount, columnCount);
            }
            for (int i=1;i<rowCount-1;i++){
                for (int j=1;j<columnCount-1;j++){
                    if (board.get(i).get(j).equals('O')){
                        if (!visitTracker[i][j]){
                            board.get(i).set(j, 'X');
                        }
                    }
                }
            }


        }

        private void visitRecursive(ArrayList<ArrayList<Character>> board, boolean[][] visitTracker, int row, int column, int rowCount, int columnCount){
            if (!isCoordinateWithinBoard(row, column, rowCount, columnCount)){
                return;
            }
            if (visitTracker[row][column]){
                return;
            }
            if (board.get(row).get(column).equals('X')){
                return;
            }
            visitTracker[row][column] = true;
            visitRecursive(board, visitTracker, row+1, column, rowCount, columnCount);
            visitRecursive(board, visitTracker, row-1, column, rowCount, columnCount);
            visitRecursive(board, visitTracker, row, column+1, rowCount, columnCount);
            visitRecursive(board, visitTracker, row, column-1, rowCount, columnCount);
        }

        private boolean isCoordinateWithinBoard(int row, int column, int rowCount, int columnCount){
            return ((row>=0) && (row<rowCount) && (column>=0) && (column<columnCount));
        }
    }
}
