package com.ace.leetcode;

public class LeetCode331
{
    public boolean verify(String[] input)
    {
        boolean childFound = false;
        int currentParentIndex = 0;
        for (int i = 0; i < input.length; i++)
        {
            if (input[i].equals("#"))
            {
                if (input[currentParentIndex].equals("#") || !childFound)
                {
                    return false;
                }
            }
            else
            {
                currentParentIndex = i;
                if (i > 0)
                {
                    childFound = true;
                }
            }
        }
        return true;
    }
}
