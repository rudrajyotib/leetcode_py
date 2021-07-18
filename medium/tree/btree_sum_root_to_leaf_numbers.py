class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumNumbers(self, root: TreeNode) -> int:

        if root is None:
            return 0

        def generate_sum_numbers(node: TreeNode):
            if node.left is None and node.right is None:
                generate_sum_numbers.sum = generate_sum_numbers.sum + node.val
            if node.left is not None:
                node.left.val = (10 * node.val) + node.left.val
                generate_sum_numbers(node.left)
            if node.right is not None:
                node.right.val = (10 * node.val) + node.right.val
                generate_sum_numbers(node.right)

        generate_sum_numbers.sum = 0
        generate_sum_numbers(root)
        return generate_sum_numbers.sum
