import collections
from typing import List


class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:

        if root is None:
            return []

        queue = collections.deque()
        level_count = 1
        queue.append(root)
        result: List[List[int]] = []
        level: List[int] = []
        while len(queue) > 0:
            node = queue.popleft()
            level.append(node.val)
            if node.children:
                for child_node in node.children:
                    queue.append(child_node)
            level_count -= 1
            if level_count == 0:
                result.append(level)
                level = []
                level_count = len(queue)

        return result
