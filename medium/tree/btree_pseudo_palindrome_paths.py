class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def is_palindromable(path: str) -> bool:
    palindrome_check = [True] * 10
    for node in path:
        ascii_index = ord(node) - 48
        palindrome_check[ascii_index] = not palindrome_check[ascii_index]
    return len(list(filter(lambda x: not x, palindrome_check))) < 2


class Solution:
    palindromable: int

    def pseudoPalindromicPaths(self, root: TreeNode) -> int:
        Solution.palindromable = 0

        def traverse_depth_first(node: TreeNode, path: [bool]):
            if node is None:
                return
            # path_at_node = path[:]
            path_at_node = path
            path_at_node[node.val] = not path_at_node[node.val]
            if node.left is None and node.right is None:
                if len(list(filter(lambda x: not x, path_at_node))) < 2:
                    Solution.palindromable += 1
            else:
                traverse_depth_first(node=node.left, path=path_at_node)
                traverse_depth_first(node=node.right, path=path_at_node)
            path_at_node[node.val] = not path_at_node[node.val]

        traverse_depth_first(node=root, path=[True]*10)

        return Solution.palindromable
