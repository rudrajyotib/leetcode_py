package gfg;

import org.junit.Test;

import static org.junit.Assert.*;
public class AlienDictionaryTest {

    @Test
    public void testCase1(){
        assertEquals("bdac", new AlienDictionary().findOrder(
                new String[]{"baa","abcd","abca","cab","cad"}
        ));
    }

    @Test
    public void testCase2(){
        assertEquals("cab", new AlienDictionary().findOrder(
                new String[]{"caa","aaa","aab"}
        ));
    }

    @Test
    public void testCase3(){
        assertTrue( new AlienDictionary().findOrder(
                new String[]{"baa","abb","caa","cab",}
        ).isEmpty());
    }


    @Test
    public void testCase4(){
        assertEquals( "hfbcdegijkla", new AlienDictionary().findOrder(
                new String[]{"bhhb", "blkbggfecalifjfcbkjdicehhgikkdhlachlgbhji", "cfjjhcifladadbgcleggjgbcieihabcglblflgajgkejccj",
                        "dlgdhiha", "ehggedljjhfldcajeceaeehkalkfeidhigkifjl", "gdalgkblahcldahledfghjb", "geldbblaaflegjhlfjlgblfbdc",
                        "ibjceciedbiilkjliijgklcgliaeeic", "jcebjkfgfibfckfiikklecihik", "jdkcabjjjckgdblkljf",
                        "jijlbjbliigkffhkchkclkhafbiiiblcglhfjkflbjjkih", "kfd", "lhdgidialgabfklffahiihceflebfidl"}
        ));
    }

}