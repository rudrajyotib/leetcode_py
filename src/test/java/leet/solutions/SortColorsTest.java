package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortColorsTest {

    @Test
    public void shouldSortColors()
    {
        int[] nums = new int[]{0,1, 2, 1, 2, 1, 2, 0, 0};
        SortColors sortColors = new SortColors();
        sortColors.solve(nums);
        assertArrayEquals(new int[]{0,0,0,1,1,1,2,2,2}, nums);
    }

    @Test
    public void shouldSortWithMissingColors()
    {
        int[] nums = new int[]{0,1,1,0,0,1};
        SortColors sortColors = new SortColors();
        sortColors.solve(nums);
        assertArrayEquals(new int[]{0,0,0,1,1,1}, nums);
    }


}