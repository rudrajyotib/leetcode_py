from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    possible_paths: List[List[int]] = []

    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:

        Solution.possible_paths = []

        def travers_till_leaf(node: TreeNode, temp_total: int, traversed_path: List[int]):
            if node is None:
                return
            sum_at_node = temp_total + node.val
            new_traversed_path = traversed_path.copy()
            new_traversed_path.append(node.val)
            if sum_at_node == targetSum:
                if node.left is None and node.right is None:
                    Solution.possible_paths.append(new_traversed_path)
                    return
            if node.left:
                travers_till_leaf(node=node.left, temp_total=sum_at_node, traversed_path=new_traversed_path)
            if node.right:
                travers_till_leaf(node=node.right, temp_total=sum_at_node, traversed_path=new_traversed_path)

        if root is None:
            return []

        travers_till_leaf(node=root, temp_total=0, traversed_path=[])
        return Solution.possible_paths
