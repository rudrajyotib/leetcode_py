package gfg;

public class FloodFill {

    @SuppressWarnings("UnusedReturnValue")
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int rowLen=image.length;
        int colLen = image[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        int startColour = image[sr][sc];
        recursiveFill(image,visited, sr, sc, newColor, startColour, rowLen, colLen);
        return image;
        // Code here
    }

    private void recursiveFill(int[][] image, boolean[][] visited, int row, int col, int newColour, int oldColour, int rowLen, int colLen){
        if (!isInRange(row, col, rowLen, colLen)){
            return;
        }
        if (visited[row][col]){
            return;
        }
        if (image[row][col] != oldColour){
            return;
        }
        visited[row][col] = true;
        image[row][col] = newColour;
        recursiveFill(image, visited, row+1, col, newColour, oldColour, rowLen, colLen);
        recursiveFill(image, visited, row-1, col, newColour, oldColour, rowLen, colLen);
        recursiveFill(image, visited, row, col+1, newColour,  oldColour,rowLen, colLen);
        recursiveFill(image, visited, row, col-1, newColour, oldColour, rowLen, colLen);
    }


    private boolean isInRange(int row, int col, int rowLen, int colLen){
        if ((row<0)||(row>=rowLen)){
            return false;
        }
        return (col >= 0) && (col < colLen);
    }

}
