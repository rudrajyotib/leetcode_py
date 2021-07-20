class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # noinspection PyMethodMayBeStatic
    def insertIntoBST(self, root: TreeNode, val: int) -> TreeNode:

        if root is None:
            return TreeNode(val=val)

        def insert_recursive(node: TreeNode, target: int):
            if node is None:
                return
            if target > node.val:
                if node.right:
                    insert_recursive(node=node.right, target=target)
                else:
                    node.right = TreeNode(val=target)
            if target < node.val:
                if node.left:
                    insert_recursive(node=node.left, target=target)
                else:
                    node.left = TreeNode(val=target)

        insert_recursive(node=root, target=val)

        return root
