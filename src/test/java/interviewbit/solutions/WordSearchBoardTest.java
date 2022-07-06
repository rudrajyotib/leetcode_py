package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchBoardTest {

    @Test
    public void shouldFindWordFromBoardWithoutRepeatInDictionaryLetters(){
        assertEquals(1, new WordSearchBoard().solve(
                new String[]{"XAD","YBC","ZPM"}, "ABC"
        ));
    }

    @Test
    public void shouldNotFindWordFromBoardWithoutRepeatInDictionaryLetters(){
        assertEquals(0, new WordSearchBoard().solve(
                new String[]{"XAD","YBC","ZPM"}, "ABD"
        ));
    }

    @Test
    public void shouldFindWordUsingSameCellMoreThanOnce(){
        assertEquals(1, new WordSearchBoard().solve(
                new String[]{"XAD","YBC","ZPM"}, "ABPMCBA"
        ));
    }

    @Test
    public void shouldNotFindWordUsingSameCellMoreThanOnce(){
        assertEquals(0, new WordSearchBoard().solve(
                new String[]{"XAD","YBC","ZPM"}, "ABPMCBAY"
        ));
    }

    @Test
    public void shouldFindWithoutRepeatingCellInSingleRowBoard(){
        assertEquals(1, new WordSearchBoard().solve(
                new String[]{"ABCDEF"}, "CDE"
        ));
    }

    @Test
    public void shouldFindWordUsingRepeatingCellInSingleRowBoard(){
        assertEquals(1, new WordSearchBoard().solve(
                new String[]{"ABCDEF"}, "BCDEDCDED"
        ));
    }

    @Test
    public void shouldNotFindWordUsingRepeatingCellInSingleRowBoard(){
        assertEquals(0, new WordSearchBoard().solve(
                new String[]{"ABCDEF"}, "BCDEDCDEDA"
        ));
    }

    @Test
    public void shouldFindWithoutRepeatingCellInSingleColumnBoard(){
        assertEquals(1, new WordSearchBoard().solve(
                new String[]{"A","B","C","D","E","F"}, "CDE"
        ));
    }

    @Test
    public void shouldFindWordUsingRepeatingCellInSingleColumnBoard(){
        assertEquals(1, new WordSearchBoard().solve(
                new String[]{"A","B","C","D","E","F"}, "BCDEDCDED"
        ));
    }

    @Test
    public void shouldNotFindWordUsingRepeatingCellInSingleColumnBoard(){
        assertEquals(0, new WordSearchBoard().solve(
                new String[]{"A","B","C","D","E","F"}, "BCDEDCDEDA"
        ));
    }

    @Test
    public void shouldSupportEmptyBoard(){
        assertEquals(0, new WordSearchBoard().solve(
                new String[]{}, "BCDEDCDEDA"
        ));
    }

    @Test
    public void shouldSupportBoardOfEmptyString(){
        assertEquals(0, new WordSearchBoard().solve(
                new String[]{""}, "BCDEDCDEDA"
        ));
    }

}