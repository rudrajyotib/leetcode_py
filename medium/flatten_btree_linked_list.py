class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def flatten(self, root: TreeNode):
        if root is None:
            return root
        stack = StackLinkedList()
        if root.right is not None:
            stack.add(root.right)
        if root.left is not None:
            stack.add(root.left)
        root.left = None
        root.right = None
        traversed_root = root
        while stack.has_next():
            tree_node = (stack.pop())
            traversed_root.right = TreeNode(val=tree_node.val)
            traversed_root.left = None
            traversed_root = traversed_root.right
            if tree_node.right is not None:
                stack.add(tree_node.right)
            if tree_node.left is not None:
                stack.add(tree_node.left)



class Node:
    def __init__(self, val):
        self.val = val
        self.next = None


class StackLinkedList:
    def __init__(self):
        self._head = None
        self._length = 0

    def has_next(self):
        return self._length > 0

    def add(self, val):
        if self._head is None:
            self._head = Node(val)
            self._length = 1
            return
        else:
            head = Node(val)
            head.next = self._head
            self._head = head
            self._length += 1

    def pop(self):
        if self._length == 0:
            return None
        val = self._head.val
        if self._length == 1:
            self._length = 0
            self._head = None
        else:
            self._head = self._head.next
            self._length -= 1
        return val

    @property
    def length(self):
        return self._length
