class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def smallestFromLeaf(self, root: TreeNode) -> str:
        if root is None:
            return ''
        leaf_strings = []

        def derive_leaf_string(node: TreeNode, string_till_node: str):
            if node is None:
                return
            if node.left is None and node.right is None:
                leaf_strings.append(chr(97 + node.val) + string_till_node)
                return
            updated_string_till_node = (chr(97 + node.val)) + string_till_node
            derive_leaf_string(node.left, updated_string_till_node)
            derive_leaf_string(node.right, updated_string_till_node)

        derive_leaf_string(root, '')
        return min(leaf_strings)
