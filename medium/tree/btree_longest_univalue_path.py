class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    possible_uni_value_paths: int = 0

    def longestUnivaluePath(self, root: TreeNode) -> int:

        if root is None:
            return 0

        Solution.possible_uni_value_paths = 1

        def find_through_dfs(node: TreeNode) -> int:
            if node.left is None and node.right is None:
                return 1
            left_uni_value_depth = 0
            right_uni_value_depth = 0
            if node.left:
                left_uni_value_depth = find_through_dfs(node.left)
                if node.left.val != node.val:
                    left_uni_value_depth = 0
            if node.right:
                right_uni_value_depth = find_through_dfs(node.right)
                if node.right.val != node.val:
                    right_uni_value_depth = 0
            uni_value_depth = 1
            if left_uni_value_depth > right_uni_value_depth:
                uni_value_depth += left_uni_value_depth
            else:
                uni_value_depth += right_uni_value_depth

            node_oriented_depth = 1 + right_uni_value_depth + left_uni_value_depth

            if uni_value_depth > Solution.possible_uni_value_paths:
                Solution.possible_uni_value_paths = uni_value_depth

            if node_oriented_depth > Solution.possible_uni_value_paths:
                Solution.possible_uni_value_paths = node_oriented_depth

            return uni_value_depth

        find_through_dfs(root)
        return Solution.possible_uni_value_paths - 1
