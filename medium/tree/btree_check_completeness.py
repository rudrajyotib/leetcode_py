import collections


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def is_leaf_node(node: TreeNode) -> bool:
    if node.left is None and node.right is None:
        return True
    return False


def is_complete_node(node: TreeNode) -> bool:
    return node.left is not None and node.right is not None


def is_invalid_incomplete_node(node: TreeNode) -> bool:
    return node.left is None and node.right is not None


class Solution:
    # noinspection PyMethodMayBeStatic
    def isCompleteTree(self, root: TreeNode) -> bool:
        if root is None:
            return False
        if root.left is None and root.right is None:
            return True
        incomplete_child_found: bool = False
        queue = collections.deque()
        queue.append(root)
        while len(queue) > 0:
            node: TreeNode = queue.popleft()
            if is_invalid_incomplete_node(node=node):
                return False
            if incomplete_child_found:
                if not is_leaf_node(node):
                    return False
            else:
                if is_complete_node(node=node):
                    queue.append(node.left)
                    queue.append(node.right)
                else:
                    incomplete_child_found = True
                    if node.left:
                        queue.append(node.left)

        return True
