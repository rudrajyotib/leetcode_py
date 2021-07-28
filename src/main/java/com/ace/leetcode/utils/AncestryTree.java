package com.ace.leetcode.utils;

import java.util.HashMap;
import java.util.Map;

public class AncestryTree
{
	private final String name;
	private AncestryTree father;
	private AncestryTree mother;
	
	private AncestryTree(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public AncestryTree getFather()
	{
		return father;
	}
	
	public AncestryTree getMother()
	{
		return mother;
	}
	
	public static AncestryTree create(String s)
	{
		if (s == null || s.equals(""))
		{
			return null;
		}
		
		String value = getValue(0, s);
		AncestryTree root = new AncestryTree(value);
		build(root, value.length(), s, s.length() - 2, new HashMap<>());
		return root;
	}
	
	private static void build(AncestryTree currentNode, int i, String s, int lastIndex, Map<String, AncestryTree> ancestors)
	{
		if (i > lastIndex)
		{
			return;
		}
		
		int start = i + 1;
		if (s.charAt(i) == '(') // found left node
		{
			int end = i + 3;
			String father = getValue(start, s);
			currentNode.father = new AncestryTree(father);
			ancestors.put(father, currentNode);
			
			if (s.charAt(i + father.length()) == ')' && lastIndex > i + 3) // found mother so go back up a level by returning self
			{
				int motherEnd = setMother(end + father.length(), s, currentNode, ancestors);
				build(currentNode, motherEnd, s, lastIndex, ancestors);
			}
			else // find next ancestor
			{
				build(currentNode.father, start + father.length(), s, lastIndex, ancestors);
			}
		}
		else
		{
			if (s.charAt(i) == ')' && s.charAt(i + 1) == '(') // found mother for self
			{
				AncestryTree ancestor = ancestors.get(currentNode.name);
				int motherEnd = setMother(i + 2, s, ancestor, ancestors);
				build(ancestor.mother, motherEnd, s, lastIndex, ancestors); // add to mother node
			}
			else
			{
				build(ancestors.get(currentNode.name), start, s, lastIndex, ancestors);
			}
		}
	}
	
	private static int setMother(int i, String s, AncestryTree node, Map<String, AncestryTree> ancestors)
	{
		String mother = getValue(i, s);
		node.mother = new AncestryTree(mother);
		ancestors.put(mother, node);
		return i + mother.length();
	}
	
	private static String getValue(int start, String s)
	{
		int leftStart = s.indexOf('(', start);
		int rightStart = s.indexOf(')', start);
		int end = leftStart > 0 ? Math.min(leftStart, rightStart) : rightStart;
		return s.substring(start, end > 0 ? end : 1);
	}
	
	public AncestryTree getAncestors(String descendant)
	{
		return null;
	}
	
	public AncestryTree getDescendants(String ancestor)
	{
		return null;
	}
}
