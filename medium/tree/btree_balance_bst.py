class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    elements_of_tree: [int]

    # noinspection PyMethodMayBeStatic
    def balanceBST(self, root: TreeNode) -> TreeNode:
        if root is None:
            # noinspection PyTypeChecker
            return None
        if root.left is None and root.right is None:
            return root

        Solution.elements_of_tree = []

        def in_order_traversal(node: TreeNode):
            if node.left:
                in_order_traversal(node=node.left)
            Solution.elements_of_tree.append(node.val)
            if node.right:
                in_order_traversal(node=node.right)

        def create_bst_from_sorted_array(start: int, end: int) -> TreeNode:
            if start > end:
                # noinspection PyTypeChecker
                return None
            if start == end:
                return TreeNode(Solution.elements_of_tree[start])
            mid = (start + end) // 2
            return TreeNode(val=Solution.elements_of_tree[mid],
                            left=create_bst_from_sorted_array(start, mid - 1),
                            right=create_bst_from_sorted_array(mid + 1, end))

        in_order_traversal(node=root)
        return create_bst_from_sorted_array(start=0, end=len(Solution.elements_of_tree) - 1)
