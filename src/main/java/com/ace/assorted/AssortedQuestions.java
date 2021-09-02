package com.ace.assorted;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AssortedQuestions
{
	private static final String az = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static int pairSums(int[] arr, int k)
	{
		Map<Integer, Integer> numbers = new HashMap<>();
		int result = 0;
		for (int num : arr)
		{
			int diff = k - num;
			if (numbers.containsKey(diff))
			{
				result++;
				if (numbers.get(diff) > 1)
				{
					result++;
					numbers.put(diff, 1);
				}
			}
			if (numbers.containsKey(num))
			{
				numbers.put(num, 1 + numbers.get(num));
			}
			else
			{
				numbers.put(num, 1);
			}
		}
		
		return result;
	}
	
	public static int[] countSubArrays(int[] arr)
	{
		int[] ans = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++)
		{
			int current = arr[i];
			int leftPointer = i - 1;
			int rightPointer = i + 1;
			
			while (leftPointer >= 0 && current > arr[leftPointer])
			{
				ans[i]++;
				leftPointer--;
			}
			while (rightPointer < arr.length && current > arr[rightPointer])
			{
				ans[i]++;
				rightPointer++;
			}
			ans[i]++;
		}
		return ans;
	}
	
	public static String rotationalCipher(String input, int rotationFactor)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++)
		{
			char original = input.charAt(i);
			if (Character.isLetter(original))
			{
				int intValue = Character.toUpperCase(original) - 'A' + rotationFactor;
				intValue = intValue > 24 ? intValue % 26 : intValue;
				char replacement = az.charAt(intValue);
				sb.append(Character.isUpperCase(original) ? replacement : Character.toLowerCase(replacement));
			}
			else if (Character.isDigit(original))
			{
				int value = Integer.parseInt(Integer.parseInt(original + "") + "") + rotationFactor;
				sb.append(value > 9 ? value % 10 : value);
			}
			else
			{
				sb.append(original);
			}
		}
		return sb.toString();
	}
	
	public static boolean areTheyEqual(int[] array_a, int[] array_b)
	{
		int length = array_a.length;
		if (length == 1 && array_b[0] == array_a[0])
		{
			return true;
		}
		
		Arrays.sort(array_a);
		Arrays.sort(array_b);
		for (int i = 0; i < array_a.length; i++)
		{
			if (array_a[i] != array_b[i])
			{
				return false;
			}
		}
		return true;
	}
	
	public static int[] findSignatureCounts(int[] arr)
	{
		int length = arr.length;
		boolean[] visited = new boolean[length];
		int[] result = new int[length];
		for (int i = 1; i <= length; i++)
		{
			int recipient = arr[i - 1];
			result[i - 1]++;
			if (i == recipient)
			{
				visited[i - 1] = true;
			}
			if (!visited[recipient - 1])
			{
				result[recipient - 1]++;
			}
		}
		return result;
	}
}
