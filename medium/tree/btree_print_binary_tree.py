from typing import List, Tuple


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    nodes_with_path: List[Tuple]
    tree_depth: int

    def printTree(self, root: TreeNode) -> List[List[str]]:

        if root is None:
            return []

        Solution.nodes_with_path = []
        Solution.tree_depth = 0

        def traverse_tree_depth_first(node_element: TreeNode, path: str, level: int):
            node_level = level + 1
            Solution.nodes_with_path.append((str(node_element.val), path))
            if node_element.left is None and node_element.right is None:
                if node_level > Solution.tree_depth:
                    Solution.tree_depth = node_level
            if node_element.left:
                traverse_tree_depth_first(node_element=node_element.left, path=path + 'L', level=node_level)
            if node_element.right:
                traverse_tree_depth_first(node_element=node_element.right, path=path + 'R', level=node_level)

        traverse_tree_depth_first(node_element=root, path='', level=-1)
        result: List[List[str]] = []
        max_width: int = pow(2, Solution.tree_depth + 1) - 1
        root_index: int = max_width // 2 + 1
        root_width: int = max_width // 2

        for height in range(0, Solution.tree_depth+1, 1):
            columns = []
            for width in range(0, max_width, 1):
                columns.append("")
            result.append(columns)

        def calculate_padding(path: str, reference_width: int, reference_index: int) -> int:
            for path_element in path:
                if path_element == 'R':
                    reference_index = reference_index + ((reference_width // 2) + 1)
                if path_element == 'L':
                    reference_index = reference_index - ((reference_width // 2) + 1)
                reference_width = reference_width // 2
            return reference_index

        for node in Solution.nodes_with_path:
            row_index = len(node[1])
            result[row_index][calculate_padding(path=node[1], reference_width=root_width, reference_index=root_index) - 1] = node[0]

        result[0][root_index-1] = str(root.val)

        return result
