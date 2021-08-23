package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidAnagramTest {

    @Test
    public void shouldValidateAnagram()
    {
        ValidAnagram validAnagram = new ValidAnagram();
        assertTrue(validAnagram.solve("rat","tar"));
        assertTrue(validAnagram.solve("raataa","aaatar"));
        assertFalse(validAnagram.solve("raataaa","aaatar"));
        assertFalse(validAnagram.solve("raataaa","baaatar"));
    }

}