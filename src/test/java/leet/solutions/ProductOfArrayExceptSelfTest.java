package leet.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductOfArrayExceptSelfTest {


    @Test
    public void shouldCreateProductArray()
    {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        assertArrayEquals(new int[]{21, 7, 3}, productOfArrayExceptSelf.solve(new int[]{1, 3, 7}));
        assertArrayEquals(new int[]{0, 0, 7}, productOfArrayExceptSelf.solve(new int[]{1, 7, 0}));
        assertArrayEquals(new int[]{0, 0, 0, 0}, productOfArrayExceptSelf.solve(new int[]{0, 1, 7, 0}));
        assertArrayEquals(new int[]{1, 2}, productOfArrayExceptSelf.solve(new int[]{2, 1}));
    }

}