package com.ace.assorted;

import java.util.*;

public class AssortedQuestions
{
	private static final String az = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static int[] getMilestoneDays(int[] revenues, int[] milestones)
	{
		Map<Integer, Integer> cumulatives = new HashMap<>();
		int total = 0;
		for (int i = 0; i < revenues.length; i++)
		{
			total = total + revenues[i];
			cumulatives.put(i + 1, total);
		}
		
		List<Integer> days = new ArrayList<>();
		List<Integer> met = new ArrayList<>();
		for (int milestone : milestones)
		{
			for (int day : cumulatives.keySet()) // TODO: binary search
			{
				int revenue = cumulatives.get(day);
				if (!met.contains(milestone) && revenue >= milestone)
				{
					days.add(day);
					met.add(milestone);
				}
			}
		}
		return days.stream().mapToInt(i -> i).toArray();
	}
	
	public static int getBillionUsersDay(float[] growthRates)
	{
		int target = 1000000000;
		
		int low = 1;
		int high = 2000;
		while (low < high)
		{
			int mid = high + low >> 1;
			if (hasGrowthReachedTarget(growthRates, target, mid)) // keep incrementing days until target reached
			{
				high = mid;
			}
			else
			{
				low = mid + 1;
			}
		}
		return low;
	}
	
	private static boolean hasGrowthReachedTarget(float[] growthRates, int target, int days)
	{
		int total = 0;
		for (float rate : growthRates)
		{
			total += Math.pow(rate, days);
		}
		return total >= target;
	}
	
	public static boolean canGetExactChange(int targetMoney, int[] denominations)
	{
		int length = denominations.length;
		return canGetExactChange(targetMoney, denominations, length, 0);
	}
	
	private static boolean canGetExactChange(int targetMoney, int[] denominations, int length, int denomination)
	{
		if (targetMoney == 0)
		{
			return true;
		}
		if (targetMoney < 0 || denomination >= length)
		{
			return false;
		}
		
		return canGetExactChange(targetMoney - denominations[denomination], denominations, length, denomination)
					   || canGetExactChange(targetMoney, denominations, length, denomination + 1);
	}
	
	public static String findEncryptedWord(String s)
	{
		int length = s.length();
		if (s.equals(""))
		{
			return "";
		}
		if (s.length() == 1)
		{
			return s;
		}
		int mid = (length % 2 == 0) ? (length / 2 - 1) : length / 2;
		return String.format("%s%s%s",
				s.charAt(mid),
				findEncryptedWord(s.substring(0, mid)),
				findEncryptedWord(s.substring(mid + 1)));
	}
	
	public static int minOperations(int[] arr)
	{
		int length = arr.length;
		boolean[] visited = new boolean[length + 1];
		int[] numberToIndex = new int[length + 1];
		for (int i = 0; i < length; i++)
		{
			numberToIndex[arr[i]] = i;
		}
		int swaps = 0;
		for (int i = 1; i <= length; i++)
		{
			int next;
			if (!visited[i])
			{
				visited[i] = true;
			}
			
			if (i - 1 != numberToIndex[i])
			{
				int c = arr[i - 1];
				while (!visited[c])
				{
					visited[c] = true;
					next = arr[c - 1];
					c = next;
					swaps++;
				}
			}
		}
		return swaps;
	}
	
	
	public static Node reverseLinkedList(Node head)
	{
		Node reversedNode = new Node(0);
		reversedNode.next = head;
		
		Node prev = reversedNode;
		Node curr = head;
		
		while (curr != null)
		{
			if (curr.data % 2 == 0)
			{
				prev.next = reverseOdds(curr);
			}
			
			prev = curr;
			curr = curr.next;
		}
		
		return reversedNode.next;
	}
	
	private static Node reverseOdds(Node head)
	{
		Node prev = null;
		Node curr = head;
		
		while (curr != null && curr.data % 2 == 0)
		{
			Node next = curr.next;
			curr.next = prev;
			
			prev = curr;
			curr = next;
		}
		
		head.next = curr;
		return prev;
	}
	
	
	public static boolean isBalanced(String s)
	{
		
		// Write your code here
		if (s.length() < 2)
		{
			return false;
		}
		
		Map<Character, Character> brackets = new HashMap<>()
		{
			{
				put('}', '{');
				put(')', '(');
				put(']', '[');
			}
		};
		
		List<Character> closingBlackets = new ArrayList<>()
		{
			{
				add(')');
				add('}');
				add(']');
			}
		};
		
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++)
		{
			Character next = s.charAt(i);
			if (closingBlackets.contains(next))
			{
				if (!stack.peek().equals(brackets.get(next)))
				{
					return false;
				}
				stack.pop();
			}
			else
			{
				stack.push(next);
			}
		}
		
		return stack.isEmpty();
		
	}
	
	
	public static int[] findPositions(int[] arr, int x)
	{
		int[] result = new int[x];
		Queue<Index> queue = new LinkedList<>();
		
		for (int i = 0; i < arr.length; i++)
		{
			int num = arr[i];
			queue.add(new Index(i + 1, num));
		}
		
		List<Index> popped = new ArrayList<>();
		for (int i = 0; i < x; i++)
		{
			Index largest = queue.peek();
			for (int j = 0; j < x && !queue.isEmpty(); j++)
			{
				Index p = queue.poll();
				popped.add(p);
				
				if (p.val > largest.val)
				{
					largest = p;
				}
			}
			
			result[i] = largest.index;
			
			for (Index p : popped)
			{
				if (p.index != largest.index)
				{
					Index next = new Index(p.index, (p.val == 0) ? p.val : p.val - 1);
					queue.add(next);
				}
			}
			popped.clear();
		}
		
		return result;
	}
	
	
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
	
	public static int[] findMaxProduct(int[] arr)
	{
		int length = arr.length;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		int[] result = new int[length];
		for (int i = 0; i < length; i++)
		{
			queue.add(arr[i]);
			result[i] = product(queue);
		}
		return result;
	}
	
	private static int product(PriorityQueue<Integer> queue)
	{
		if (queue.size() < 3)
		{
			return -1;
		}
		List<Integer> products = new ArrayList<>();
		int count = 0;
		while (!queue.isEmpty() && count < 3)
		{
			products.add(queue.poll());
			count++;
		}
		int product = products.get(0);
		products.remove(0);
		queue.add(product);
		for (int i : products)
		{
			queue.add(i);
			product = product * i;
		}
		return product;
	}
	
	public static int maxCandies(int[] arr, int k)
	{
		int length = arr.length;
		int result = 0;
		for (int i = 0; i < k; i++)
		{
			sortMaxHeap(arr);
			int numCandy = arr[0];
			result = result + numCandy;
			deleteFromHeap(arr);
			arr[length - 1] = (int) Math.floor(numCandy / 2);
		}
		return result;
	}
	
	private static void deleteFromHeap(int[] arr)
	{
		arr[0] = arr[arr.length - 1];
		arr[arr.length - 1] = 0;
	}
	
	private static void sortMaxHeap(int[] arr)
	{
		for (int i = arr.length - 1; i > 0; i--)
		{
			int pi = i / 2;
			if (arr[i] > arr[pi])
			{
				int higher = arr[i];
				arr[i] = arr[pi];
				arr[pi] = higher;
			}
		}
	}
	
	public static int[] findMedian(int[] arr)
	{
		int length = arr.length;
		int[] result = new int[length];
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < length; i++)
		{
			numbers.add(arr[i]);
			Collections.sort(numbers);
			int currentSize = numbers.size();
			int mid = currentSize / 2;
			if (currentSize % 2 == 0)
			{
				result[i] = (int) Math.floor((numbers.get(mid - 1) + numbers.get(mid)) / 2);
			}
			else
			{
				result[i] = (numbers.get(mid));
			}
		}
		
		return result;
	}
	
	boolean balancedSplitExists(int[] arr)
	{
		// Write your code here
		Map<Integer, Integer> counts = new HashMap<>();
		int total = 0;
		for (int n : arr)
		{
			total = total + n;
			if (counts.containsKey(n))
			{
				counts.put(n, counts.get(n) + 1);
			}
			else
			{
				counts.put(n, 1);
			}
		}
		
		if (total % 2 == 0)
		{
			int half = total / 2;
			int max = 0;
			for (int n : counts.keySet())
			{
				if (half == 0 && max < n)
				{
					return true;
				}
				max = Math.max(n, max);
				half = half - (counts.get(n) * n);
			}
		}
		return false;
		
		
	}
	
	private static class Index
	{
		int index;
		int val;
		
		Index(int index, int val)
		{
			this.index = index;
			this.val = val;
		}
	}
	
	public static class Node
	{
		int data;
		Node next;
		
		Node(int x)
		{
			data = x;
			next = null;
		}
	}
	
}
