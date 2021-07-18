class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def countNodes(self, root: TreeNode) -> int:
        if root is None:
            return 0

        def count_node(node: TreeNode) -> int:
            if node is None:
                return 0
            return 1 + count_node(node.left) + count_node(node.right)

        return count_node(node=root)
