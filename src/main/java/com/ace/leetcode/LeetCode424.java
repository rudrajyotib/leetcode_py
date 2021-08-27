package com.ace.leetcode;

public class LeetCode424
{
	public static int characterReplacement(String s, int k)
	{
		int l = s.length();
		int[] charCounts = new int[26];
		int windowStart = 0;
		int maxLength = 0;
		int maxCharCount = 0;
		for (int windowEnd = 0; windowEnd < l; windowEnd++)
		{
			int currentCharIntVal = s.charAt(windowEnd) - 'A';
			charCounts[currentCharIntVal]++;
			int currentCharCount = charCounts[currentCharIntVal];
			maxCharCount = Math.max(maxCharCount, currentCharCount);
			
			while (windowEnd - windowStart - maxCharCount + 1 > k) // move the right pointer until we have valid number of replacements
			{
				charCounts[s.charAt(windowStart) - 'A']--;
				windowStart++;
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}
}
