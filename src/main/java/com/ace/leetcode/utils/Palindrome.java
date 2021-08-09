package com.ace.leetcode.utils;

public class Palindrome
{
	private final String s;
	
	public Palindrome(String s)
	{
		this.s = s.replaceAll("[^a-zA-Z0-9]", "");
	}
	
	public boolean isValid()
	{
		if (s.length() >= 1 && s.length() <= (2 * Math.pow(10, 5)))
		{
			return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
		}
		return false;
	}
	
	public String getLongestPalindrome()
	{
		String longestPalindrome = "";
		for (int i = 0; i < s.length(); i++)
		{
			longestPalindrome = getNextPalindrome(i, s, longestPalindrome);
		}
		
		return longestPalindrome;
	}
	
	private String getNextPalindrome(int i, String s, String longestPalindrome)
	{
		int j = i;
		while (j < s.length())
		{
			j++;
			String current = s.substring(i, j);
			if (current.equalsIgnoreCase(new StringBuilder(current).reverse().toString()))
			{
				longestPalindrome = current.length() > longestPalindrome.length() ? current : longestPalindrome;
			}
		}
		return longestPalindrome;
	}
}
