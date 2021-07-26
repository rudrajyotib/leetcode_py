import collections


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # noinspection PyMethodMayBeStatic
    def isEvenOddTree(self, root: TreeNode) -> bool:
        if root is None:
            return False
        if root.left is None and root.right is None:
            return root.val % 2 == 1
        if root.val % 2 == 0:
            return False
        ascending = False
        queue = collections.deque()
        level_length = 0
        level_index = 0
        level_limit = 0
        next_level_size = 0
        if root.left:
            queue.append(root.left)
            level_length += 1
        if root.right:
            queue.append(root.right)
            level_length += 1
        while len(queue) > 0:
            node: TreeNode = queue.popleft()
            if not ascending:
                if node.val % 2 == 1:
                    return False
            else:
                if node.val % 2 == 0:
                    return False
            if level_index == 0:
                level_limit = node.val
            else:
                if ascending:
                    if level_limit >= node.val:
                        return False
                    else:
                        level_limit = node.val
                else:
                    if level_limit <= node.val:
                        return False
                    else:
                        level_limit = node.val
            level_index += 1
            if node.left:
                queue.append(node.left)
                next_level_size += 1
            if node.right:
                queue.append(node.right)
                next_level_size += 1
            if level_index == level_length:
                level_index = 0
                level_length = next_level_size
                next_level_size = 0
                ascending = not ascending

        return True
