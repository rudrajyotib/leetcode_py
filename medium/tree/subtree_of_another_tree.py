from typing import Optional

"""
https://leetcode.com/problems/subtree-of-another-tree/
Leetcode#572
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def match_sub_tree(root1: TreeNode, root2: TreeNode) -> bool:
    if root1 is None and root2 is None:
        return True
    if root1 is None and root2 is not None:
        return False
    if root1 is not None and root2 is None:
        return False

    # noinspection PyUnresolvedReferences
    if root1.val != root2.val:
        return False
    # noinspection PyUnresolvedReferences
    return match_sub_tree(root1.left, root2.left) and match_sub_tree(root1.right, root2.right)


def traverse_tree(root: TreeNode, subRoot: TreeNode) -> bool:
    if root is None:
        return False
    if root.val == subRoot.val:
        if match_sub_tree(root, subRoot):
            return True
    return traverse_tree(root.left, subRoot) or traverse_tree(root.right, subRoot)


class Solution:
    # noinspection PyMethodMayBeStatic
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if root is None:
            return False
        if subRoot is None:
            return False
        return traverse_tree(root, subRoot)


class SubTreeOfAnotherTree:
    # noinspection PyMethodMayBeStatic
    def solve(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        solution = Solution()
        return solution.isSubtree(root, subRoot)
