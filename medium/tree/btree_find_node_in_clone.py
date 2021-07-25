import collections


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        if cloned.left is None and cloned.right is None:
            return cloned
        queue = collections.deque()
        queue.append(cloned)
        while len(queue) > 0:
            node = queue.popleft()
            if node.val == target.val:
                return node
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)

