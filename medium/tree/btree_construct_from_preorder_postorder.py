from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # noinspection PyMethodMayBeStatic
    def constructFromPrePost(self, pre: List[int], post: List[int]) -> TreeNode:
        pre_index_map = {}
        for index, value in enumerate(post):
            pre_index_map[value] = index

        def build_sub_tree(post_start, post_end):

            if post_start > post_end:
                return None

            node = TreeNode(pre[build_sub_tree.pre_index])

            build_sub_tree.pre_index += 1

            if post_start == post_end:
                return node

            post_index = pre_index_map[pre[build_sub_tree.pre_index]]

            node.left = build_sub_tree(post_start, post_index)
            node.right = build_sub_tree(post_index + 1, post_end - 1)

            return node

        build_sub_tree.pre_index = 0
        return build_sub_tree(0, len(post) - 1)
