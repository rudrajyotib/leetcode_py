from typing import List, Dict


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    common_subtree_roots: List[TreeNode]
    serialised_sub_trees: Dict[str, int]

    # noinspection PyMethodMayBeStatic
    def findDuplicateSubtrees(self, root: TreeNode) -> List[TreeNode]:
        Solution.common_subtree_roots = []
        Solution.serialised_sub_trees = {}

        def pre_order_traverse(root_node: TreeNode) -> str:
            if root_node is None:
                return "EOT"
            left_child: str = pre_order_traverse(root_node=root_node.left)
            right_child: str = pre_order_traverse(root_node=root_node.right)
            node_serialised = "{self},{left},{right}".format(self=root_node.val, left=left_child, right=right_child)
            count: int = 0
            if node_serialised in Solution.serialised_sub_trees:
                count = Solution.serialised_sub_trees[node_serialised]
            count = count + 1
            if count == 2:
                Solution.common_subtree_roots.append(root_node)
            if count < 3:
                Solution.serialised_sub_trees[node_serialised] = count
            return node_serialised

        pre_order_traverse(root_node=root)
        return Solution.common_subtree_roots
