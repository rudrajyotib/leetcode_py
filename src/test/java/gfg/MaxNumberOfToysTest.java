package gfg;

/*
https://practice.geeksforgeeks.org/problems/maximum-number-of-toys/1
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MaxNumberOfToysTest {

    @SuppressWarnings("unchecked")
    @Test
    public void set1(){
        assertArrayEquals(new Integer[]{2,5}, new MaxNumberOfToys().solve(new int[]{8, 6, 9, 2, 5}, new ArrayList[]{
                new ArrayList<>(List.of(12, 2, 3, 4)),
                new ArrayList<>(List.of(30, 0))
        }).toArray(new Integer[1]));
    }


    @SuppressWarnings("unchecked")
    @Test
    public void set2(){
        assertArrayEquals(new Integer[]{0}, new MaxNumberOfToys().solve(new int[]{3,3}, new ArrayList[]{
                new ArrayList<>(List.of(1,0))
        }).toArray(new Integer[1]));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void set3(){
        assertArrayEquals(new Integer[]{1,4,1}, new MaxNumberOfToys().solve(new int[]{9 ,7 ,2 ,1 ,9 ,4 ,2 ,9 ,5 ,8}, new ArrayList[]{
                new ArrayList<>(List.of(1 ,2 ,6 ,7)),
                new ArrayList<>(List.of(9,1,10)),
                new ArrayList<>(List.of(5 ,6 ,6 ,7, 3, 8, 9, 10))
        }).toArray(new Integer[1]));
    }


}