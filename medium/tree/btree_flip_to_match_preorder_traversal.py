import collections
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # noinspection PyMethodMayBeStatic
    def flipMatchVoyage(self, root: TreeNode, voyage: List[int]) -> List[int]:

        if len(voyage) == 1:
            if root.left is None and root.right is None:
                if root.val != voyage[0]:
                    return [-1]
                else:
                    return []

        result: List[int] = []
        queue = collections.deque()
        queue.append(root)
        pre_order_index = 0
        while len(queue) > 0:
            node: TreeNode = queue.pop()
            if node.val != voyage[pre_order_index]:
                return [-1]
            if node.left is not None and node.right is not None:
                if node.left.val != voyage[pre_order_index + 1]:
                    node.left, node.right = node.right, node.left
                    result.append(node.val)
                queue.append(node.right)
                queue.append(node.left)
            elif node.left is None:
                if node.right is not None:
                    queue.append(node.right)
            else:
                queue.append(node.left)
            pre_order_index += 1

        return result
