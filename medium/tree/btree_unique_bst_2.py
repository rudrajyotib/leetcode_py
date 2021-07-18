from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        if n == 1:
            return [TreeNode(1)]

        def generate_sub_trees(start, end) -> Optional[List[TreeNode]]:
            if start > end:
                return None
            if start == end:
                return [TreeNode(val=start)]
            sub_trees = []
            for counter in range(start, end + 1, 1):
                left_subtrees = generate_sub_trees(start, counter - 1)
                right_subtrees = generate_sub_trees(counter + 1, end)
                if left_subtrees is not None:
                    for left_subtree in left_subtrees:
                        if right_subtrees is not None:
                            for right_subtree in right_subtrees:
                                sub_trees.append(TreeNode(val=counter, left=left_subtree, right=right_subtree))
                        else:
                            sub_trees.append(TreeNode(val=counter, left=left_subtree))
                elif right_subtrees is not None:
                    for right_subtree in right_subtrees:
                        sub_trees.append(TreeNode(val=counter, right=right_subtree))
                else:
                    sub_trees.append(TreeNode(val=counter))
            return sub_trees

        return generate_sub_trees(1, n)
