from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    possible_paths: int = 0

    # noinspection PyMethodMayBeStatic
    def pathSum(self, root: TreeNode, targetSum: int) -> int:
        Solution.possible_paths = 0
        if root is None:
            return 0

        def traverse_till_leaf(node: TreeNode, path_sum: List[int]):
            node_list = path_sum.copy()
            node_list.append(0)
            updated_node_list = list(map(lambda x: x + node.val, node_list))
            Solution.possible_paths += len(list(filter(lambda x: x == targetSum, updated_node_list)))
            if node.left:
                traverse_till_leaf(node=node.left, path_sum=updated_node_list)
            if node.right:
                traverse_till_leaf(node=node.right, path_sum=updated_node_list)

        traverse_till_leaf(root, [])
        return Solution.possible_paths
