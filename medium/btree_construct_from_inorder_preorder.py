from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        in_index_map = {}
        for index, value in enumerate(inorder):
            in_index_map[value] = index

        def build_sub_tree(in_start, in_end):

            if in_start > in_end:
                return None
            node = TreeNode(preorder[build_sub_tree.pre_index])
            build_sub_tree.pre_index += 1

            if in_start == in_end:
                return node

            in_index = in_index_map[node.val]

            node.left = build_sub_tree(in_start, in_index - 1)
            node.right = build_sub_tree(in_index + 1, in_end)

            return node

        build_sub_tree.pre_index = 0
        return build_sub_tree(0, len(inorder) - 1)
