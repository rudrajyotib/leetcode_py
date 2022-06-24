package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class RotateSquareMatrixTest {


    @Test
    public void shouldRotateMatrixAnticlockwiseWithEvenNumberOfRows() {
        ArrayList<ArrayList<Integer>> testMatrix = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2, 3, 4)),
                        new ArrayList<>(Arrays.asList(5, 6, 7, 8)),
                        new ArrayList<>(Arrays.asList(9, 10, 11, 12)),
                        new ArrayList<>(Arrays.asList(13, 14, 15, 16))
                )
        );
        new RotateSquareMatrix().solveAntiClockwise(
                 testMatrix
        );
        assertArrayEquals(new int[][]{
                new int[]{4, 8, 12, 16},
                new int[]{3, 7, 11, 15},
                new int[]{2, 6, 10, 14},
                new int[]{1, 5, 9, 13}
        }, testMatrix.stream().map(integers -> integers.stream().mapToInt(value -> value).toArray()).toArray());

    }

    @Test
    public void shouldRotateMatrixAnticlockwiseWithOddNumberOfRows() {
        ArrayList<ArrayList<Integer>> testMatrix = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)),
                        new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10)),
                        new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15)),
                        new ArrayList<>(Arrays.asList(16, 17, 18, 19, 20)),
                        new ArrayList<>(Arrays.asList(21, 22, 23, 24, 25))
                )
        );

        new RotateSquareMatrix().solveAntiClockwise(
               testMatrix
        );
        assertArrayEquals(new int[][]{
                new int[]{5, 10, 15, 20, 25},
                new int[]{4, 9, 14, 19, 24},
                new int[]{3, 8, 13, 18, 23},
                new int[]{2, 7, 12, 17, 22},
                new int[]{1, 6, 11, 16, 21}
        }, testMatrix.stream().map(integers -> integers.stream().mapToInt(value -> value).toArray()).toArray());

    }

    @Test
    public void shouldRotateSmallMatrixAnticlockwise() {
        ArrayList<ArrayList<Integer>> testMatrix = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2)),
                        new ArrayList<>(Arrays.asList(3, 4))
                )
        );
        new RotateSquareMatrix().solveAntiClockwise( testMatrix);
        assertArrayEquals(new int[][]{
                new int[]{2, 4},
                new int[]{1, 3}

        }, testMatrix.stream().map(integers -> integers.stream().mapToInt(value -> value).toArray()).toArray());
    }

    @Test
    public void shouldRotateMatrixClockwiseWithEvenNumberOfRows() {
        ArrayList<ArrayList<Integer>> testMatrix = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2, 3, 4)),
                        new ArrayList<>(Arrays.asList(5, 6, 7, 8)),
                        new ArrayList<>(Arrays.asList(9, 10, 11, 12)),
                        new ArrayList<>(Arrays.asList(13, 14, 15, 16))
                )
        );
        new RotateSquareMatrix().solveClockwise(
                 testMatrix
        );
        assertArrayEquals(new int[][]{
                new int[]{13, 9, 5, 1},
                new int[]{14, 10, 6, 2},
                new int[]{15, 11, 7, 3},
                new int[]{16, 12, 8, 4}
        }, testMatrix.stream().map(integers -> integers.stream().mapToInt(value -> value).toArray()).toArray());

    }

    @Test
    public void shouldRotateMatrixClockwiseWithOddNumberOfRows() {
        ArrayList<ArrayList<Integer>> testMatrix = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)),
                        new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10)),
                        new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15)),
                        new ArrayList<>(Arrays.asList(16, 17, 18, 19, 20)),
                        new ArrayList<>(Arrays.asList(21, 22, 23, 24, 25))
                )
        );

        new RotateSquareMatrix().solveClockwise(
               testMatrix
        );
        assertArrayEquals(new int[][]{
                new int[]{21, 16, 11, 6, 1},
                new int[]{22, 17, 12, 7, 2},
                new int[]{23, 18, 13, 8, 3},
                new int[]{24, 19, 14, 9, 4},
                new int[]{25, 20, 15, 10, 5}
        }, testMatrix.stream().map(integers -> integers.stream().mapToInt(value -> value).toArray()).toArray());

    }

    @Test
    public void shouldRotateSmallMatrixClockwise() {
        ArrayList<ArrayList<Integer>> testMatrix = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 2)),
                        new ArrayList<>(Arrays.asList(3, 4))
                )
        );
        new RotateSquareMatrix().solveClockwise( testMatrix);
        assertArrayEquals(new int[][]{
                new int[]{3, 1},
                new int[]{4, 2}

        }, testMatrix.stream().map(integers -> integers.stream().mapToInt(value -> value).toArray()).toArray());
    }

}