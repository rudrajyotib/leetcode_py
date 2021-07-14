class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:

        def delete_recursive(node: TreeNode, search_key: int) -> TreeNode:
            if node is None:
                # noinspection PyTypeChecker
                return node

            if search_key < node.val:
                node.left = delete_recursive(node.left, search_key)
            elif search_key > node.val:
                node.right = delete_recursive(node.right, search_key)
            else:
                if node.left is None:
                    return node.right
                elif node.right is None:
                    return node.left

                node.val = minimum_node_in_sub_tree(node.right)
                node.right = delete_recursive(node.right, node.val)
            return node

        def minimum_node_in_sub_tree(node: TreeNode):
            min_val = node.val
            if node is None:
                return min_val
            while node.left is not None:
                node = node.left
                min_val = node.val
            return min_val

        return delete_recursive(node=root, search_key=key)
