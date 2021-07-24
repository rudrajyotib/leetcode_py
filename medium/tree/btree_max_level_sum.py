import collections


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # noinspection PyMethodMayBeStatic
    def maxLevelSum(self, root: TreeNode) -> int:

        if root.left is None and root.right is None:
            return 1

        current_level = 2
        current_index = 0
        max_level = 1
        max_val = root.val
        queue = collections.deque()
        level_depth = 0
        level_sum = 0
        child_level_depth = 0
        if root.left:
            level_depth += 1
            queue.append(root.left)
        if root.right:
            level_depth += 1
            queue.append(root.right)
        while len(queue) > 0:
            node: TreeNode = queue.popleft()
            level_sum += node.val
            if node.left:
                queue.append(node.left)
                child_level_depth += 1
            if node.right:
                queue.append(node.right)
                child_level_depth += 1
            current_index += 1
            if current_index == level_depth:
                if level_sum > max_val:
                    max_val = level_sum
                    max_level = current_level
                current_index = 0
                level_depth = child_level_depth
                child_level_depth = 0
                current_level += 1
                level_sum = 0

        return max_level
