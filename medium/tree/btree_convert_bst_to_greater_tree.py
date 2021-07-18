from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # noinspection PyMethodMayBeStatic
    def convertBST(self, root: TreeNode) -> TreeNode:

        def traverse_in_order(node: TreeNode, container: List[TreeNode]):
            if node is None:
                return
            if node.left:
                traverse_in_order(node=node.left, container=container)
            container.append(node)
            if node.right:
                traverse_in_order(node=node.right, container=container)

        in_order: [TreeNode] = []

        traverse_in_order(node=root, container=in_order)

        for i in range(len(in_order) - 2, -1, -1):
            in_order[i].val += in_order[i + 1].val

        return root
