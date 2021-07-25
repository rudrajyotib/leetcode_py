class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # noinspection PyMethodMayBeStatic
    def goodNodes(self, root: TreeNode) -> int:
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return 1

        def traverse_depth_first(node: TreeNode, max_in_path: int) -> int:
            if node is None:
                return 0
            return (1 if node.val >= max_in_path else 0) + \
                   traverse_depth_first(node.left, max(node.val, max_in_path)) + \
                   traverse_depth_first(node.right, max(node.val, max_in_path))

        return traverse_depth_first(node=root, max_in_path=root.val)
