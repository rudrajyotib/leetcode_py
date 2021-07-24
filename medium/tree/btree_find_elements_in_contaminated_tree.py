import collections


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class FindElements:

    def __init__(self, root: TreeNode):
        queue = collections.deque()
        self._sorted_array: [int] = []
        root.val = 0
        queue.append(root)
        while len(queue) > 0:
            node: TreeNode = queue.popleft()
            if node:
                self._sorted_array.append(node.val)
            if node.left:
                node.left.val = node.val * 2 + 1
                queue.append(node.left)
            if node.right:
                node.right.val = node.val * 2 + 2
                queue.append(node.right)

    def find(self, target: int) -> bool:
        return target in self._sorted_array
