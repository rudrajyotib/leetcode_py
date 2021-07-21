from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    deepest_level: int
    paths_list: List[str]

    # noinspection PyMethodMayBeStatic
    def subtreeWithAllDeepest(self, root: TreeNode) -> TreeNode:

        Solution.deepest_level = 0
        Solution.paths_list = []

        def traverse_depth_first(node: TreeNode, level: int, path: str):
            if node is None:
                return
            Solution.paths_list.append(path)
            if level > Solution.deepest_level:
                Solution.deepest_level = level
            traverse_depth_first(node=node.left, level=level + 1, path=path + 'L')
            traverse_depth_first(node=node.right, level=level + 1, path=path + 'R')

        traverse_depth_first(node=root.left, level=1, path='L')
        traverse_depth_first(node=root.right, level=1, path='R')

        all_paths_to_deepest_nodes = list(filter(lambda x: len(x) == Solution.deepest_level, Solution.paths_list))
        if len(all_paths_to_deepest_nodes) == 1:
            start_node = root
            for counter in range(0, len(all_paths_to_deepest_nodes[0]), 1):
                if all_paths_to_deepest_nodes[0][counter] == 'R':
                    start_node = start_node.right
                else:
                    start_node = start_node.left
            return start_node
        longest_common_node = -1
        for i in range(0, Solution.deepest_level, 1):
            matches = True
            for j in range(0, len(all_paths_to_deepest_nodes) - 1, 1):
                matches = matches and all_paths_to_deepest_nodes[j][i] == all_paths_to_deepest_nodes[j + 1][i]
            if not matches:
                break
            else:
                longest_common_node += 1
        base_common_node = root
        if longest_common_node >= 0:
            for node_path in range(0, longest_common_node + 1, 1):
                if all_paths_to_deepest_nodes[0][node_path] == 'R':
                    base_common_node = base_common_node.right
                else:
                    base_common_node = base_common_node.left
        return base_common_node
