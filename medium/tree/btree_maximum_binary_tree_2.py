class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # noinspection PyMethodMayBeStatic
    def insertIntoMaxTree(self, root: TreeNode, val: int) -> TreeNode:
        if val > root.val:
            return TreeNode(val=val, left=root)

        right_child = root

        while right_child.right is not None and right_child.right.val > val:
            right_child = right_child.right

        if right_child.right is None:
            right_child.right = TreeNode(val=val)
        else:
            node = TreeNode(val=val, left=right_child.right)
            right_child.right = node

        return root
