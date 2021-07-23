class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # noinspection PyMethodMayBeStatic
    def bstToGst(self, root: TreeNode) -> TreeNode:

        if root.left is None and root.right is None:
            return root

        def form_greater_sum_tree(node: TreeNode, offset: int) -> int:
            if node is None:
                return 0
            if node.left is None and node.right is None:
                temp = node.val
                node.val = node.val + offset
                # print("updating leaf node {} to {}".format(temp, node.val))
                return temp
            sum_from_right: int = 0
            sum_from_left: int = 0
            if node.right is not None:
                sum_from_right = form_greater_sum_tree(node=node.right, offset=offset)
            # print("updating node {} to {}".format(node.val, node.val + sum_from_right + offset))
            temp_node_val = node.val + sum_from_right
            node.val = node.val + sum_from_right + offset
            if node.left is not None:
                sum_from_left = form_greater_sum_tree(node=node.left, offset=node.val)

            return temp_node_val + sum_from_left

        root.val += form_greater_sum_tree(node=root.right, offset=0)
        form_greater_sum_tree(node=root.left, offset=root.val)

        return root
