from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def insert_node_recursive(root_node: TreeNode, to_insert: int) -> TreeNode:
    if root_node.val < to_insert:
        if root_node.right is None:
            root_node.right = TreeNode(val=to_insert)
            return root_node.right
        else:
            return insert_node_recursive(root_node=root_node.right, to_insert=to_insert)
    else:
        if root_node.left is None:
            root_node.left = TreeNode(val=to_insert)
            return root_node.left
        else:
            return insert_node_recursive(root_node.left, to_insert=to_insert)


class Solution:
    # noinspection PyMethodMayBeStatic
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        if len(preorder) == 1:
            return TreeNode(val=preorder[0])

        root = TreeNode(preorder[0])

        for pre_order_index in range(1, len(preorder), 1):
            insert_node_recursive(root_node=root, to_insert=preorder[pre_order_index])
        return root
