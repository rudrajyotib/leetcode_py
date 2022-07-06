package interviewbit.solutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class CaptureRegionsOnBoardTest {

    @Test
    public void shouldHandleAnEmptyBoard() {
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        new CaptureRegionsOnBoard().solve(board);
        assertTrue(board.isEmpty());
    }

    @Test
    public void shouldHandleBoardWithEmptyRow() {
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        board.add(new ArrayList<>());
        new CaptureRegionsOnBoard().solve(board);
        assertTrue(board.get(0).isEmpty());
    }

    @Test
    public void shouldNotMakeAnyChangeToSingleRowBoard() {
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        board.add(new ArrayList<>(List.of('X', 'O', 'X')));
        new CaptureRegionsOnBoard().solve(board);
        assertArrayEquals(new Character[]{'X', 'O', 'X'},
                board.get(0).toArray(new Character[1]));
    }

    @Test
    public void shouldNotMakeAnyChangeToSingleColumnBoard() {
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        board.add(new ArrayList<>(List.of('X')));
        board.add(new ArrayList<>(List.of('O')));
        board.add(new ArrayList<>(List.of('X')));
        new CaptureRegionsOnBoard().solve(board);
        assertArrayEquals(new Character[]{'X', 'O', 'X'},
                board.stream().map(characters -> characters.get(0)).toArray());
    }

    @Test
    public void shouldMarkCapturedElements() {
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        board.add(new ArrayList<>(List.of('X', 'X', 'X', 'X', 'X')));
        board.add(new ArrayList<>(List.of('X', 'X', 'O', 'X', 'X')));
        board.add(new ArrayList<>(List.of('X', 'X', 'O', 'X', 'X')));
        board.add(new ArrayList<>(List.of('X', 'O', 'X', 'X', 'X')));
        new CaptureRegionsOnBoard().solve(board);
        assertArrayEquals(new Character[]{'X', 'X', 'X', 'X', 'X'}, board.get(0).toArray(new Character[1]));
        assertArrayEquals(new Character[]{'X', 'X', 'X', 'X', 'X'}, board.get(1).toArray(new Character[1]));
        assertArrayEquals(new Character[]{'X', 'X', 'X', 'X', 'X'}, board.get(2).toArray(new Character[1]));
        assertArrayEquals(new Character[]{'X', 'O', 'X', 'X', 'X'}, board.get(3).toArray(new Character[1]));
    }

}