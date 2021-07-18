import collections


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # noinspection PyMethodMayBeStatic
    def addOneRow(self, root: TreeNode, val: int, depth: int) -> TreeNode:
        if depth == 1:
            return TreeNode(val=val, left=root)
        if depth == 2:
            new_left_node = TreeNode(val=val, left=root.left, right=None)
            new_right_node = TreeNode(val=val, left=None, right=root.right)
            root.left = new_left_node
            root.right = new_right_node
            return root

        current_depth = 1
        current_level_node_count: int = 1
        nodes_in_level = collections.deque()
        level_found: bool = False
        nodes_in_level.append(root)
        while not level_found:
            node = nodes_in_level.popleft()
            current_level_node_count -= 1
            if node.left:
                nodes_in_level.append(node.left)
            if node.right:
                nodes_in_level.append(node.right)
            if current_level_node_count == 0:
                if current_depth == depth - 2:
                    level_found = True
                else:
                    current_depth += 1
                    current_level_node_count = len(nodes_in_level)
        while len(nodes_in_level) > 0:
            node = nodes_in_level.popleft()
            new_left_node = TreeNode(val=val)
            new_right_node = TreeNode(val=val)
            if node.left:
                new_left_node.left = node.left
            if node.right:
                new_right_node.right = node.right
            node.left = new_left_node
            node.right = new_right_node

        return root
