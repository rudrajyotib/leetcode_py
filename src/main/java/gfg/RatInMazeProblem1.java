/*
https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 */

package gfg;

import java.util.ArrayList;
import java.util.LinkedList;

public class RatInMazeProblem1 {


    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> result = new ArrayList<>();
        int len = mat.length;

        if (mat[0][0] == 0) {
            return new ArrayList<>();
        }
        if (mat[len - 1][len - 1] == 0) {
            return new ArrayList<>();
        }
        boolean[][] visited = new boolean[mat.length][mat.length];
        LinkedList<Character> dirStack = new LinkedList<>();
        visitRecursive(0, 0, len, mat, visited, dirStack, result);
        return result;
    }

    private boolean isInRange(int row, int col, int len) {
        if (row < 0 || row >= len) {
            return false;
        }
        return col >= 0 && col < len;
    }

    private void visitRecursive(int row, int col, int len, int[][] mat, boolean[][] visited, LinkedList<Character> dirStack, ArrayList<String> result) {
        if (row == len - 1 && col == len - 1) {
            StringBuilder sb = new StringBuilder();
            dirStack.forEach(sb::append);
            result.add(sb.toString());
            return;
        }
        if (visited[row][col]) {
            return;
        }
        if (mat[row][col] == 0) {
            return;
        }
        visited[row][col] = true;
        if (isInRange(row - 1, col, len)) {
            dirStack.addLast('U');
            visitRecursive(row - 1, col, len, mat, visited, dirStack, result);
            dirStack.removeLast();
        }
        if (isInRange(row + 1, col, len)) {
            dirStack.addLast('D');
            visitRecursive(row + 1, col, len, mat, visited, dirStack, result);
            dirStack.removeLast();
        }
        if (isInRange(row, col - 1, len)) {
            dirStack.addLast('L');
            visitRecursive(row, col - 1, len, mat, visited, dirStack, result);
            dirStack.removeLast();
        }
        if (isInRange(row, col + 1, len)) {
            dirStack.addLast('R');
            visitRecursive(row, col + 1, len, mat, visited, dirStack, result);
            dirStack.removeLast();
        }
        visited[row][col] = false;
    }


}
