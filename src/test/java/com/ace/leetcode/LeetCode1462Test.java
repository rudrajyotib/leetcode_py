package com.ace.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCode1462Test
{
	@Test
	public void shouldReturnPrerequisites()
	{
		assertEquals(new Boolean[]{false, false}, LeetCode1462.checkIfPrerequisiteUsingFloydWarshall(2, new int[0][0], new int[][]{{0, 1}, {1, 0}}).toArray(new Boolean[0]));
		assertEquals(new Boolean[]{false, true}, LeetCode1462.checkIfPrerequisiteUsingFloydWarshall(2, new int[][]{{1, 0}}, new int[][]{{0, 1}, {1, 0}}).toArray(new Boolean[0]));
		assertEquals(new Boolean[]{true, true}, LeetCode1462.checkIfPrerequisiteUsingFloydWarshall(3, new int[][]{{1, 2}, {1, 0}, {2, 0}}, new int[][]{{1, 0}, {1, 2}}).toArray(new Boolean[0]));
		
//		if (dist{i}{k} + dist{k}{j} < dist{i}{j})
//		dist{i}{j} = dist{i}{k} + dist{k}{j};
	}
}
