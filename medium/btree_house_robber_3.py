from typing import Dict


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    node_history: Dict[str, int] = {}

    # noinspection PyMethodMayBeStatic
    def rob(self, root: TreeNode) -> int:
        Solution.node_history = {}

        def calculate_rob_recursive(root_node: TreeNode, node_name: str) -> int:
            if root_node is None:
                return 0
            if Solution.node_history.get(node_name) is not None:
                return Solution.node_history.get(node_name)
            rob_from_left_sub_children = 0 if not root_node.left else calculate_rob_recursive(
                root_node=root_node.left.left, node_name=node_name + ".L.L") + calculate_rob_recursive(
                root_node=root_node.left.right, node_name=node_name + ".L.R")
            rob_from_right_sub_children = 0 if not root_node.right else calculate_rob_recursive(
                root_node=root_node.right.left, node_name=node_name + ".R.L") + calculate_rob_recursive(
                root_node=root_node.right.right, node_name=node_name + ".R.R")
            rob_from_self_node = root_node.val + rob_from_left_sub_children + rob_from_right_sub_children
            rob_from_immediate_children = calculate_rob_recursive(root_node=root_node.left,
                                                                  node_name=node_name + ".L") + \
                                          calculate_rob_recursive(
                                              root_node=root_node.right, node_name=node_name + ".R")
            node_rob = max(rob_from_self_node, rob_from_immediate_children)
            Solution.node_history.update({node_name: node_rob})
            return node_rob

        return calculate_rob_recursive(root_node=root, node_name='Root')
