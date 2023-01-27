package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class CaseSpecificSortingOfStringsTest {

    @Test
    public void set1(){
        assertEquals("deeIRSfrsTUX", new CaseSpecificSortingOfStrings().solve("defRTSersUXI"));
        assertEquals("birDKs", new CaseSpecificSortingOfStrings().solve("srbDKi"));
    }


}