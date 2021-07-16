package com.ace.leetcode;

public class LeetCode331
{
    public boolean verify(String[] input)
    {
        int countOpenNodes = 0;
        boolean first = true;
        for (String node : input)
        {
            if (node.equals("#"))
            {
                countOpenNodes -= 1;
            }
            else
            {
                if (first)
                {
                    countOpenNodes += 2;
                    first = false;
                }
                else
                {
                    countOpenNodes += 1;
                }
            }
        }
        return countOpenNodes == 0;
    }
}
