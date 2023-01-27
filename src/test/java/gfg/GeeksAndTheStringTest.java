package gfg;

import org.junit.Assert;
import org.junit.Test;

public class GeeksAndTheStringTest {

    @Test
    public void set1(){
        Assert.assertEquals("ad", new GeeksAndTheString().solve("aaabbaaccd"));
    }

    @Test
    public void set2(){
        Assert.assertEquals("", new GeeksAndTheString().solve("aaaa"));
    }


}