package leet.solutions;

import org.junit.Assert;
import org.junit.Test;

public class AppendCharactersToMakeSubsequenceTest {

    @Test
    public void testCase() {
        Assert.assertEquals(0, new AppendCharactersToMakeSubsequence().solve("abcdef", "cd"));
        Assert.assertEquals(4, new AppendCharactersToMakeSubsequence().solve("coaching", "coding"));
        Assert.assertEquals(4, new AppendCharactersToMakeSubsequence().solve("abcdef", "ghij"));

    }

}