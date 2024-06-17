package leet.solutions;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ReplaceWordTest {

    @Test
    public void testCases() {
        Assert.assertEquals("the cat was rat by the bat",
                new ReplaceWord().solve(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        Assert.assertEquals("a a b c",
                new ReplaceWord().solve(List.of("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"));
    }


}