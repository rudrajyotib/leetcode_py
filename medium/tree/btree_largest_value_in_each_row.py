import collections
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # noinspection PyMethodMayBeStatic
    def largestValues(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        queue = collections.deque()
        level_count: int = 1
        queue.append(root)
        result: [int] = []
        row_initialised: bool = False
        level_max: int
        while len(queue) > 0:
            node: TreeNode = queue.popleft()
            if not row_initialised:
                row_initialised = True
                level_max = node.val
            else:
                # noinspection PyUnboundLocalVariable
                if node.val > level_max:
                    level_max = node.val
            level_count -= 1
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
            if level_count == 0:
                result.append(level_max)
                row_initialised = False
                level_count = len(queue)
        return result
