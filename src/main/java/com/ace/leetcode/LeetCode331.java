package com.ace.leetcode;

public class LeetCode331
{
    public boolean verify(String[] input)
    {
        int currentParentIndex = 0;
        for (int i = 0; i < input.length; i++)
        {
            if (input[i].equals("#"))
            {
                if (input[currentParentIndex].equals("#"))
                {
                    return false;
                }
            }
            else
            {
                currentParentIndex = i;
            }
        }
        return true;
    }
}
