class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def is_leaf_node(node: TreeNode) -> bool:
    return node.left is None and node.right is None


class Solution:
    # noinspection PyMethodMayBeStatic
    def removeLeafNodes(self, root: TreeNode, target: int) -> TreeNode:

        def calculate_recursive(node: TreeNode) -> bool:
            if node is None:
                return True
            if is_leaf_node(node):
                if node.val == target:
                    return True
                else:
                    return False
            else:
                left_to_be_deleted = calculate_recursive(node.left)
                right_to_be_deleted = calculate_recursive(node.right)
                if left_to_be_deleted:
                    node.left = None
                if right_to_be_deleted:
                    node.right = None
                if left_to_be_deleted and right_to_be_deleted:
                    return node.val == target

            return False

        if calculate_recursive(node=root):
            # noinspection PyTypeChecker
            return None
        else:
            return root
