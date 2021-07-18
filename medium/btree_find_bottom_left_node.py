import collections


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def findBottomLeftValue(self, root: TreeNode) -> int:
        left_most_node: TreeNode = root
        level_count: int = 1
        queue = collections.deque()
        queue.append(root)
        while len(queue) > 0:
            node: TreeNode = queue.pop()
            if node.right:
                queue.appendleft(node.right)
            if node.left:
                queue.appendleft(node.left)
            level_count -= 1
            if level_count == 0:
                left_most_node = node
                level_count = len(queue)
        return left_most_node.val
