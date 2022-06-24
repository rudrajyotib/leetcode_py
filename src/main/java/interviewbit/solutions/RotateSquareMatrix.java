package interviewbit.solutions;

import java.util.ArrayList;

public class RotateSquareMatrix {

    public void solveAntiClockwise(ArrayList<ArrayList<Integer>> matrix) {
        new SolutionAntiClockwise().rotate( matrix);
    }

    public void solveClockwise(ArrayList<ArrayList<Integer>> matrix) {
        new SolutionClockwise().rotate( matrix);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class SolutionAntiClockwise {
        public void rotate( ArrayList<ArrayList<Integer>> matrix) {
            int length = matrix.size();
            for (int rotateCounter = 0; rotateCounter < length / 2; rotateCounter++) {
                for (int column = rotateCounter; column < length - rotateCounter - 1; column++) {
                    int temp = matrix.get(rotateCounter).get(column);
                    matrix.get(rotateCounter).set(column, matrix.get(column).get(length-rotateCounter-1)) ;
                    matrix.get(column).set(length-rotateCounter-1, matrix.get(length-rotateCounter-1).get(length-1-column)) ;
                    matrix.get(length-rotateCounter-1).set(length-1-column,  matrix.get(length-1-column).get(rotateCounter)) ;
                    matrix.get(length-1-column).set(rotateCounter, temp) ;
                }
            }
        }
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class SolutionClockwise {
        public void rotate( ArrayList<ArrayList<Integer>> matrix) {
            int length = matrix.size();
            for (int rotateCounter = 0; rotateCounter < length / 2; rotateCounter++) {
                for (int column = rotateCounter; column < length - rotateCounter - 1; column++) {
                    int temp = matrix.get(rotateCounter).get(column);
                    matrix.get(rotateCounter).set(column, matrix.get(length-1-column).get(rotateCounter)) ;
                    matrix.get(length-1-column).set(rotateCounter, matrix.get(length-rotateCounter-1).get(length-1-column));
                    matrix.get(length-rotateCounter-1).set(length-1-column, matrix.get(column).get(length-rotateCounter-1));
                    matrix.get(column).set(length-rotateCounter-1, temp);
                }
            }
        }
    }

}
