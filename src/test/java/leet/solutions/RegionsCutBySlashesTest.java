package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegionsCutBySlashesTest {

    @Test
    public void testCase1(){
        assertEquals(5, new RegionsCutBySlashes().solve(new String[]{"/\\","\\/"}));
    }

    @Test
    public void testCase2(){
        assertEquals(1, new RegionsCutBySlashes().solve(new String[]{" /","  "}));
    }

}