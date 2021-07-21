"""
From discussions.
"""
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def allPossibleFBT(self, n: int) -> List[TreeNode]:

        if n == 1:
            return [TreeNode(val=0)]
        if n % 2 == 0:
            return []
        result = []
        for i in range(1, n):
            left_children = self.allPossibleFBT(i)
            right_children = self.allPossibleFBT(n - i - 1)
            for left_child in left_children:
                for right_child in right_children:
                    result.append(TreeNode(val=0, left=left_child, right=right_child))
        return result
