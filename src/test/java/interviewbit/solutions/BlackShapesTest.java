package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class BlackShapesTest {

    @Test
    public void shouldCountBlackShapesSet1(){
        assertEquals(2, new BlackShapes().solve(
                new String[]{
                        "OOXO",
                        "OXXX",
                        "OOXX",
                        "XOOO"
                }
        ));
    }

    @Test
    public void shouldCountBlackShapesSet2(){
        assertEquals(1, new BlackShapes().solve(
                new String[]{
                        "OOXO",
                        "OXXX",
                        "OOXX",
                        "XXXO"
                }
        ));
    }

    @Test
    public void shouldCountBlackShapesSet3(){
        assertEquals(0, new BlackShapes().solve(
                new String[]{
                        "OOOO",
                        "OOOO",
                        "OOOO",
                        "OOOO"
                }
        ));
    }


}