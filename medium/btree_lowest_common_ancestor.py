class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    elements_found: bool = False
    element_to_search: int = 0
    searching_first_element: bool = False
    result: TreeNode = None

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        Solution.elements_found = False
        Solution.element_to_search = 0
        Solution.searching_first_element = True
        Solution.result = None

        def find_nodes_recursive(node: TreeNode):
            if Solution.result:
                return
            if not Solution.elements_found and node.left:
                find_nodes_recursive(node.left)
            if not Solution.elements_found and node.right:
                find_nodes_recursive(node.right)
            if Solution.searching_first_element:
                if node.val == Solution.element_to_search:
                    Solution.elements_found = True
                if Solution.elements_found:
                    node.visited = True
            else:
                if Solution.result:
                    return
                if node.val == Solution.element_to_search:
                    Solution.elements_found = True
                if Solution.elements_found:
                    if hasattr(node, 'visited'):
                        Solution.result = node

        Solution.element_to_search = p.val
        find_nodes_recursive(node=root)
        Solution.element_to_search = q.val
        Solution.elements_found = False
        Solution.searching_first_element = False
        find_nodes_recursive(node=root)
        # noinspection PyTypeChecker
        return Solution.result
