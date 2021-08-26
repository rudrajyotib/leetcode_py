package com.ace.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LeetCode17
{
	private static final Map<Character, String> ALPHA_NUMERIC_KEY = new HashMap<>()
	{
		{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}
	};
	
	public static List<String> letterCombinations(String digits)
	{
		LinkedList<String> result = new LinkedList<>();
		
		if (digits.equals(""))
		{
			return result;
		}
		
		result.add("");
		
		int i = 0;
		for (Character digit : digits.toCharArray())
		{
			while (result.peek() != null && result.peek().length() == i)
			{
				String current = result.remove();
				for (char c : ALPHA_NUMERIC_KEY.get(digit).toCharArray())
				{
					result.add(current + c);
				}
			}
			i++;
		}
		return result;
	}
}
