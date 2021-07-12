from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    elements_found: bool = False
    element_to_search: int = 0

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        Solution.elements_found = False
        Solution.element_to_search = 0

        def find_nodes_recursive(node: TreeNode, path_to_node: List[TreeNode]):
            if not Solution.elements_found and node.left:
                find_nodes_recursive(node.left, path_to_node=path_to_node)
            if not Solution.elements_found and node.right:
                find_nodes_recursive(node.right, path_to_node=path_to_node)
            if node.val == Solution.element_to_search:
                Solution.elements_found = True
            if Solution.elements_found:
                path_to_node.append(node)

        path_to_first_element: List[TreeNode] = []
        path_to_second_element: List[TreeNode] = []
        Solution.element_to_search = p.val
        find_nodes_recursive(node=root, path_to_node=path_to_first_element)
        Solution.element_to_search = q.val
        Solution.elements_found = False
        find_nodes_recursive(node=root, path_to_node=path_to_second_element)
        first_element_path = list(map(lambda n: n.val, path_to_first_element))
        return list(filter(lambda node: node.val in first_element_path, path_to_second_element))[0]
