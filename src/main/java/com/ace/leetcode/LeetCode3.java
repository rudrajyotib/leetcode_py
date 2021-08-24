package com.ace.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3
{
	public static int returnLengthOfLongestSubstring(String s)
	{
		if (s.length() == 0)
		{
			return 0;
		}
		if (s.length() == 1)
		{
			return 1;
		}
		Map<Character, Integer> chars = new HashMap<>();
		int longest = 0;
		int leftPointer = 0;
		int rightPointer = 0;
		while (rightPointer < s.length())
		{
			char next = s.charAt(rightPointer);
			if (chars.containsKey(next))
			{
				longest = Math.max(rightPointer - leftPointer, longest);
				int index = chars.get(next);
				leftPointer = index < leftPointer ? leftPointer : index + 1;
			}
			chars.put(next, rightPointer++);
		}
		return Math.max(s.length() - leftPointer, longest);
	}
}
