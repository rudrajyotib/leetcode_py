class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    max_level: int = 0
    left_most_node: TreeNode

    # noinspection PyMethodMayBeStatic
    def findBottomLeftValue(self, root: TreeNode) -> int:
        Solution.left_most_node = root
        Solution.max_level = 0

        def find_bottom_left_recursive(node: TreeNode, level: int):
            if level > Solution.max_level:
                Solution.left_most_node = node
                Solution.max_level = level
            if node.left:
                find_bottom_left_recursive(node=node.left, level=level + 1)
            if node.right:
                find_bottom_left_recursive(node=node.right, level=level + 1)

        find_bottom_left_recursive(node=root, level=1)
        return Solution.left_most_node.val
