from typing import Tuple


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    max_diff: int

    # noinspection PyMethodMayBeStatic
    def maxAncestorDiff(self, root: TreeNode) -> int:
        Solution.max_diff = 0

        if root.left is None and root.right is None:
            return 0

        def traverse_depth_first(node: TreeNode, limits: Tuple[int, int]):
            if node is None:
                return
            if node.left is None and node.right is None:
                upper_limit = limits[1]
                lower_limit = limits[0]
                if node.val < lower_limit:
                    lower_limit = node.val
                elif node.val > upper_limit:
                    upper_limit = node.val
                difference = abs(upper_limit - lower_limit)
                if difference > Solution.max_diff:
                    Solution.max_diff = difference
            else:
                if node.left is not None:
                    if limits[0] < node.val < limits[1]:
                        traverse_depth_first(node.left, limits)
                    else:
                        lower_limit = limits[0]
                        upper_limit = limits[1]
                        if node.val < lower_limit:
                            lower_limit = node.val
                        elif node.val > upper_limit:
                            upper_limit = node.val
                        traverse_depth_first(node.left, (lower_limit, upper_limit))
                if node.right is not None:
                    if limits[0] < node.val < limits[1]:
                        traverse_depth_first(node.right, limits)
                    else:
                        lower_limit = limits[0]
                        upper_limit = limits[1]
                        if node.val < lower_limit:
                            lower_limit = node.val
                        elif node.val > upper_limit:
                            upper_limit = node.val
                        traverse_depth_first(node.right, (lower_limit, upper_limit))

        if root.left is not None:
            if root.left.val > root.val:
                traverse_depth_first(node=root.left, limits=(root.val, root.left.val))
            else:
                traverse_depth_first(node=root.left, limits=(root.left.val, root.val))

        if root.right is not None:
            if root.right.val > root.val:
                traverse_depth_first(node=root.right, limits=(root.val, root.right.val))
            else:
                traverse_depth_first(node=root.right, limits=(root.right.val, root.val))

        return Solution.max_diff
