package gfg;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrefixSuffixStringTest {

    @Test
    public void set1()
    {
        assertEquals(2, new PrefixSuffixString().countPrefixSuffix(
                new String[]{"cat", "catanddog", "lion"},
                new String[]{"cat", "dog", "rat"}
        ));
    }


     @Test
    public void set2()
    {
        assertEquals(4, new PrefixSuffixString().countPrefixSuffix(
                new String[]{"jrjiml", "tchetn", "ucrhye", "ynayhy",
                        "cuhffd", "cvgpoiu", "znyadv"},
                new String[]{"jr", "ml", "cvgpoi", "gpoiu", "wnmkmluc",
                        "geheqe", "uglxagyl", "uyxdroj"}
        ));
    }

    @Test
    public void set3()
    {
        assertEquals(0, new PrefixSuffixString().countPrefixSuffix(
                new String[]{"jrjiml", "tchetn", "ucrhye", "ynayhy",
                        "cuhffd", "cvgpoiu", "znyadv"},
                new String[]{"aax","bbd","ueyu"}
        ));
    }


}