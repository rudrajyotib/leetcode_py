package com.ace.leetcode;

import com.ace.leetcode.utils.BinaryTree;

import java.util.Stack;

public class LeetCode114
{
	public static void flatten(BinaryTree root)
	{
		BinaryTree original = new BinaryTree(root.getValue(), root.getLeft(), root.getRight());
		root.setLeft(null);
		root.setRight(null);
		Stack<BinaryTree> nodes = new Stack<>();
		nodes.push(root);
		toLinkedList(original, nodes);
	}
	
	private static void toLinkedList(BinaryTree original, Stack<BinaryTree> nodes)
	{
		if (original == null)
		{
			return;
		}
		
		BinaryTree node = nodes.pop();
		node.setValue(original.getValue());
		node.setRight(new BinaryTree(0));
		nodes.push(node.getRight());
		
		toLinkedList(original.getLeft(), nodes);
		toLinkedList(original.getRight(), nodes);
	}
}
