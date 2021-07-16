from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    result: List[TreeNode] = []
    left: str = 'Left'
    right: str = 'Right'

    # noinspection PyTypeChecker
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        if root is None:
            return None
        Solution.result = []

        def delete_nodes_recursive(node: TreeNode, root_node: TreeNode, parent: TreeNode, parent_relation: str):

            if node.val in to_delete:
                if node.val != root_node.val:
                    if parent_relation == Solution.left:
                        parent.left = None
                    if parent_relation == Solution.right:
                        parent.right = None
                if node.left:
                    # noinspection PyTypeChecker
                    delete_nodes_recursive(node=node.left, root_node=node.left, parent=None, parent_relation=None)
                    node.left = None
                if node.right:
                    # noinspection PyTypeChecker
                    delete_nodes_recursive(node=node.right, root_node=node.right, parent=None, parent_relation=None)
                    node.right = None

            else:
                if node.val == root_node.val:
                    Solution.result.append(node)
                if node.left:
                    delete_nodes_recursive(node=node.left, root_node=root_node, parent=node,
                                           parent_relation=Solution.left)
                if node.right:
                    delete_nodes_recursive(node=node.right, root_node=root_node, parent=node,
                                           parent_relation=Solution.right)

        delete_nodes_recursive(node=root, root_node=root, parent=None, parent_relation=None)

        return Solution.result
