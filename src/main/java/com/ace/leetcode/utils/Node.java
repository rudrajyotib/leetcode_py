package com.ace.leetcode.utils;

import java.util.ArrayList;
import java.util.List;
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
	public Node<V, E> add(Node<V, E> root, String s, int index)
	{
		Stack<Node<V, E>> nodes = new Stack<>();
		nodes.push(root);
		for (int i = index; i < s.length(); i++)
		{
			if (s.charAt(i) == '(') // found left node
			{
				int start = i + 1;
				String left = getValue(start, s);
				E node = create(left);
				Node<V, E> currentNode = nodes.peek();
				if (currentNode.left == null)
				{
					currentNode.left = node;
				}
				else
				{
					currentNode.right = node;
				}
				nodes.push((Node<V, E>) node);
				i = i + left.length();
			}
			else
			{
				nodes.pop();
			}
		}
		return nodes.peek();
	}
	
	protected static String getValue(int start, String s)
	{
		int leftStart = s.indexOf('(', start);
		int rightStart = s.indexOf(')', start);
		int end = leftStart > 0 ? Math.min(leftStart, rightStart) : rightStart;
		return s.substring(start, end > 0 ? end : 1);
	}
	
	protected List<V> toInorderList()
	{
		List<V> values = new ArrayList<>();
		toInorderList(this, values);
		return values;
	}
	
	protected List<V> toPostorderList()
	{
		List<V> values = new ArrayList<>();
		toPostorderList(this, values);
		return values;
	}
	
	protected List<V> toPreorderList()
	{
		List<V> values = new ArrayList<>();
		toPreorderList(this, values);
		return values;
	}
	
	@SuppressWarnings("unchecked")
	private void toPreorderList(Node<V, E> node, List<V> values)
	{
		if (node == null)
		{
			return;
		}
		
		values.add(node.value);
		toPreorderList((Node<V, E>) node.left, values);
		toPreorderList((Node<V, E>) node.right, values);
	}
	
	@SuppressWarnings("unchecked")
	private void toPostorderList(Node<V, E> node, List<V> values)
	{
		if (node == null)
		{
			return;
		}
		toPostorderList((Node<V, E>) node.left, values);
		toPostorderList((Node<V, E>) node.right, values);
		values.add(node.value);
	}
	
	@SuppressWarnings("unchecked")
	private void toInorderList(Node<V, E> node, List<V> values)
	{
		if (node == null)
		{
			return;
		}
		toInorderList((Node<V, E>) node.left, values);
		values.add(node.value);
		toInorderList((Node<V, E>) node.right, values);
	}
	
	protected abstract E create(String value);
	
	public abstract V[] toInorder();
	
	public abstract V[] toPreorder();
	
	public abstract V[] toPostorder();
}
