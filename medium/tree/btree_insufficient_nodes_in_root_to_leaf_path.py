class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def is_leaf_node(node: TreeNode) -> bool:
    return node.left is None and node.right is None


class Solution:
    def sufficientSubset(self, root: TreeNode, limit: int) -> TreeNode:

        def calculate_recursive(node: TreeNode,  path_sum: int) -> bool:
            if node is None:
                return True
            node_sum = path_sum + node.val
            if is_leaf_node(node):
                if node_sum < limit:
                    return True
                else:
                    return False
            else:
                left_to_be_deleted = calculate_recursive(node.left, path_sum=node_sum)
                right_to_be_deleted = calculate_recursive(node.right, path_sum=node_sum)
                if left_to_be_deleted and right_to_be_deleted:
                    return True
                if left_to_be_deleted:
                    node.left = None
                if right_to_be_deleted:
                    node.right = None

            return False

        if calculate_recursive(node=root,  path_sum=0):
            # noinspection PyTypeChecker
            return None
        else:
            return root
