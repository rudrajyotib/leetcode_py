class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    last_known_node: TreeNode = None
    bst_validity_failed: bool = False

    # noinspection PyMethodMayBeStatic
    def isValidBST(self, root: TreeNode) -> bool:
        Solution.bst_validity_failed = False
        Solution.last_known_node = None
        if root is None:
            return False

        def bst_validity_check(node: TreeNode):
            if node is None:
                return
            if Solution.bst_validity_failed:
                return
            if node.left:
                bst_validity_check(node.left)
            if Solution.last_known_node is None:
                Solution.last_known_node = node
            elif Solution.last_known_node.val >= node.val:
                Solution.bst_validity_failed = True
                return
            else:
                Solution.last_known_node = node

            if node.right:
                bst_validity_check(node.right)

        bst_validity_check(root)
        return not Solution.bst_validity_failed
