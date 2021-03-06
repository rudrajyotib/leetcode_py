package com.ace.leetcode;

public class LeetCode331
{
    public boolean verify(String[] input)
    {
        int countOpenNodes = 1;
        int countOfDeadNodesInCurrentSequence = 0;
        for (String node : input)
        {
            if (countOfDeadNodesInCurrentSequence > 2)
            {
                return false;
            }
            if (node.equals("#"))
            {
                countOfDeadNodesInCurrentSequence += 1;
                countOpenNodes -= 1;
            }
            else
            {
                countOfDeadNodesInCurrentSequence = 0;
                if (countOpenNodes == 0)
                {
                    return false;
                }
                countOpenNodes += 1;
            }
        }
        return countOpenNodes == 0;
    }
}
