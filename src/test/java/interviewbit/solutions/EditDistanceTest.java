package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest {

    private final String[][] testCases = new String[][]{
            new String[]{"BOTTLE","OTE", "3"},
            new String[]{"CAT","DOG", "3"},
            new String[]{"Anshuman","Antihuman", "2"}
    };

    @Test
    public void execute(){
        for (int i=0;i<testCases.length;i++){
            assertEquals(String.format("Test case %d failed", i+1),Integer.parseInt(testCases[i][2]),
                    new EditDistance().solve(testCases[i][0], testCases[i][1]));
        }
    }


}