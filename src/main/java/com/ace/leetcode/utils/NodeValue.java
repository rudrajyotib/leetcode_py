package com.ace.leetcode.utils;

public class NodeValue implements Comparable<NodeValue>
{
	private final int node;
	private int value;
	
	private NodeValue(int node, int value)
	{
		this.node = node;
		this.value = value;
	}
	
	private void setValue(int value)
	{
		this.value = value;
	}
	
	@Override
	public int compareTo(NodeValue o)
	{
		int thatValue = o.value;
		return Integer.compare(this.value, thatValue);
	}
}
