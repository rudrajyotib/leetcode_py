class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # noinspection PyMethodMayBeStatic
    def sumEvenGrandparent(self, root: TreeNode) -> int:

        if root is None:
            return 0

        def recursive_sum_of_grandchildren(node: TreeNode, parent_even: bool, grand_parent_even: bool) -> int:
            if node is None:
                return 0
            left_tree_sum = recursive_sum_of_grandchildren(node=node.left, parent_even=node.val % 2 == 0,
                                                           grand_parent_even=parent_even)
            right_tree_sum = recursive_sum_of_grandchildren(node=node.right, parent_even=node.val % 2 == 0,
                                                            grand_parent_even=parent_even)
            if grand_parent_even:
                return left_tree_sum + right_tree_sum + node.val
            else:
                return left_tree_sum + right_tree_sum

        return recursive_sum_of_grandchildren(node=root, parent_even=False, grand_parent_even=False)
