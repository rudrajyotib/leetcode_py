import collections


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def widthOfBinaryTree(self, root: TreeNode) -> int:

        if root is None:
            return 0
        if root.left is None and root.right is None:
            return 1

        Solution.max_width_gap = 0
        queue = collections.deque()
        first_index_of_row: int
        last_index_of_row: int
        queue.append((1, root))
        nodes_in_level = 1
        iteration_in_level = 0
        max_width_gap: int = 0
        while len(queue) > 0:
            node_tuple = queue.popleft()
            if iteration_in_level == 0:
                first_index_of_row = node_tuple[0]
            if node_tuple[1].left:
                queue.append((node_tuple[0] * 2, node_tuple[1].left))
            if node_tuple[1].right:
                queue.append((node_tuple[0] * 2 + 1, node_tuple[1].right))
            iteration_in_level += 1
            if iteration_in_level == nodes_in_level:
                last_index_of_row = node_tuple[0]
                if (last_index_of_row - first_index_of_row) > max_width_gap:
                    max_width_gap = last_index_of_row - first_index_of_row
                iteration_in_level = 0
                nodes_in_level = len(queue)

        return max_width_gap + 1
