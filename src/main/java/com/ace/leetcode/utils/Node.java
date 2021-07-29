package com.ace.leetcode.utils;

import java.util.Stack;

public abstract class Node<V, E>
{
	protected final V value;
	protected E left;
	protected E right;
	
	protected Node(V value)
	{
		this.value = value;
	}
	
	@SuppressWarnings("unchecked")
	protected void add(Node<V, E> currentNode, int i, String s, int lastIndex, Stack<Node<V, E>> descendants)
	{
		if (i > lastIndex)
		{
			return;
		}
		
		int start = i + 1;
		if (s.charAt(i) == '(') // found left node
		{
			int end = i + 3;
			String left = getValue(start, s);
			currentNode.left = create(left);
			descendants.push(currentNode);
			
			if (s.charAt(i + left.length()) == ')' && lastIndex > i + 3) // found mother so go back up a level by returning self
			{
				int motherEnd = setChildOfRight(end + left.length(), s, currentNode);
				add(currentNode, motherEnd, s, lastIndex, descendants);
			}
			else // find next ancestor
			{
				add((Node<V, E>) currentNode.left, start + left.length(), s, lastIndex, descendants);
			}
		}
		else
		{
			if (s.charAt(i) == ')' && s.charAt(i + 1) == '(') // found mother for self
			{
				Node<V, E> descendant = descendants.peek();
				int motherEnd = setChildOfRight(i + 2, s, descendant);
				add((Node<V, E>) descendant.right, motherEnd, s, lastIndex, descendants); // add to mother node
			}
			else
			{
				add(descendants.pop(), start, s, lastIndex, descendants);
			}
		}
	}
	
	private int setChildOfRight(int i, String s, Node<V, E> node)
	{
		String value = getValue(i, s);
		node.right = create(value);
		return i + value.length();
	}
	
	protected static String getValue(int start, String s)
	{
		int leftStart = s.indexOf('(', start);
		int rightStart = s.indexOf(')', start);
		int end = leftStart > 0 ? Math.min(leftStart, rightStart) : rightStart;
		return s.substring(start, end > 0 ? end : 1);
	}
	protected abstract E create(String value);
}
