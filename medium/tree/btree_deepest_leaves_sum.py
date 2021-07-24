class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    deepest_level: int
    sum: int

    # noinspection PyMethodMayBeStatic
    def deepestLeavesSum(self, root: TreeNode) -> int:
        if root.left is None and root.right is None:
            return root.val
        Solution.deepest_level = 0
        Solution.sum = root.val

        def traverse_depth_first(node: TreeNode, level: int):
            if node is None:
                return
            if node.left is None and node.right is None:
                if Solution.deepest_level > level:
                    return
                if Solution.deepest_level < level:
                    Solution.sum = node.val
                    Solution.deepest_level = level
                else:
                    Solution.sum += node.val
            else:
                traverse_depth_first(node=node.left, level=level + 1)
                traverse_depth_first(node=node.right, level=level + 1)

        traverse_depth_first(node=root, level=0)
        return Solution.sum
