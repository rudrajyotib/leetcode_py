package hackerrank;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ConnectedCellInGridTest {

    @Test
    public void testCase1(){
        assertEquals(5, ConnectedCellInGrid.maxRegion(
                List.of(
                        List.of(1,1,0,0),
                        List.of(0,1,1,0),
                        List.of(0,0,1,0),
                        List.of(1,0,0,0)
                )
        ));
    }

}