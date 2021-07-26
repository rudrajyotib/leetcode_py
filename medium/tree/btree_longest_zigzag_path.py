class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    longest_path: int
    LEFT_PATH = "L"
    RIGHT_PATH = "R"

    def longestZigZag(self, root: TreeNode) -> int:

        Solution.longest_path = 0

        if root is None:
            return 0

        def traverse_depth_first_and_add_path(node: TreeNode,
                                              path_from_parent: str, path_length: int):
            if node is None:
                return
            if path_length > Solution.longest_path:
                Solution.longest_path = path_length
            traverse_depth_first_and_add_path(node=node.left,
                                              path_from_parent=Solution.LEFT_PATH,
                                              path_length=path_length + 1 if
                                              path_from_parent == Solution.RIGHT_PATH else 1)
            traverse_depth_first_and_add_path(node=node.right,
                                              path_from_parent=Solution.RIGHT_PATH,
                                              path_length=path_length + 1 if
                                              path_from_parent == Solution.LEFT_PATH else 1)

        traverse_depth_first_and_add_path(node=root.left, path_from_parent=Solution.LEFT_PATH, path_length=1)
        traverse_depth_first_and_add_path(node=root.right, path_from_parent=Solution.RIGHT_PATH, path_length=1)

        return Solution.longest_path
