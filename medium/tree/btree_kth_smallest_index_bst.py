class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    nodes_traversed = 0
    result = 0

    # noinspection PyMethodMayBeStatic
    def kthSmallest(self, root: TreeNode, k: int) -> int:

        Solution.nodes_traversed = 0
        Solution.result = 0

        if root is None:
            return 0

        def iterate_over_nodes(node: TreeNode):
            if Solution.nodes_traversed >= k:
                return
            if node.left:
                iterate_over_nodes(node=node.left)
            Solution.nodes_traversed += 1
            if Solution.nodes_traversed == k:
                Solution.result = node.val
                return
            if node.right:
                iterate_over_nodes(node=node.right)

        iterate_over_nodes(node=root)

        return Solution.result
