class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def trimBST(self, root: TreeNode, low: int, high: int) -> TreeNode:
        if root is None:
            return None
        if root.val < low:
            return self.trimBST(root=root.right, low=low, high=high)
        if root.val > high:
            return self.trimBST(root=root.left, low=low, high=high)

        root.left = self.trimBST(root=root.left, low=low, high=high)
        root.right = self.trimBST(root=root.right, low=low, high=high)

        return root
