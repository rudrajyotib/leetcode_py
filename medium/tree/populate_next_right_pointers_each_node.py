class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:

    def connect(self, root: 'Node') -> 'Node':
        if root is None:
            return None

        def sub_connect(node: Node):
            if node is None:
                return
            if node.next is None:
                if node.left is not None:
                    if node.right is not None:
                        node.left.next = node.right
            else:
                if node.left is not None:
                    if node.right is not None:
                        node.left.next = node.right
                    elif node.next.left is not None:
                        node.left.next = node.next.left
                    elif node.next.right is not None:
                        node.left.next = node.next.right
                if node.right is not None:
                    if node.next.left is not None:
                        node.right.next = node.next.left
                    elif node.next.right is not None:
                        node.right.next = node.next.right
            sub_connect(node.left)
            sub_connect(node.right)

        sub_connect(node=root)

        return root

