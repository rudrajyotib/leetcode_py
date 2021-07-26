from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    good_leaf_pair_count = 0

    # noinspection PyMethodMayBeStatic
    def countPairs(self, root: TreeNode, distance: int) -> int:
        Solution.good_leaf_pair_count = 0

        def calculate_leaf_depth(node: TreeNode) -> List[List[int]]:
            if node is None:
                return [[0, 0]]
            if node.left is None and node.right is None:
                return [[0, 1]]
            leaves_from_left = calculate_leaf_depth(node=node.left)
            for leaf in leaves_from_left:
                leaf[0] += 1
            leaves_from_right = calculate_leaf_depth(node=node.right)
            for leaf in leaves_from_right:
                leaf[0] += 1
            for left_leaf in leaves_from_left:
                for right_leaf in leaves_from_right:
                    if (left_leaf[0] + right_leaf[0]) <= distance \
                            and left_leaf[1] > 0 and right_leaf[1] > 0:
                        Solution.good_leaf_pair_count += (left_leaf[1] + right_leaf[1] - 1)
            return leaves_from_right + leaves_from_left

        calculate_leaf_depth(node=root)

        return Solution.good_leaf_pair_count
