package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class TypeItTest {

    @Test
    public void set1(){
        assertEquals(5, new TypeIt().solve("abcabca"));
    }

    @Test
    public void set2(){
        assertEquals(8, new TypeIt().solve("abcdefgh"));
    }

    @Test
    public void set3(){
        assertEquals(11, new TypeIt().solve("aacgdheghhh"));
    }


}