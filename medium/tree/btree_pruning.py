class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    # noinspection PyMethodMayBeStatic
    def pruneTree(self, root: TreeNode) -> TreeNode:

        def prune_tree_recursive(node: TreeNode) -> bool:
            if node is None:
                return True
            right_child_can_be_deleted: bool = prune_tree_recursive(node=node.right)
            left_child_can_be_deleted: bool = prune_tree_recursive(node=node.left)
            if right_child_can_be_deleted:
                node.right = None
            if left_child_can_be_deleted:
                node.left = None
            if node.val == 0 and left_child_can_be_deleted and right_child_can_be_deleted:
                return True
            return False

        if prune_tree_recursive(node=root):
            # noinspection PyTypeChecker
            return None

        return root
