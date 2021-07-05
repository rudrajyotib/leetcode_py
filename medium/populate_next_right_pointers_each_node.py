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
        layers_present = True
        present_layer = LinkedList()
        next_layer = LinkedList()
        present_layer.add(root)
        while layers_present:
            while present_layer.has_next():
                node = present_layer.pop()
                if present_layer.peek() is not None:
                    node.next=present_layer.peek()
                if node.left is not None:
                    next_layer.add(node.left)
                if node.right is not None:
                    next_layer.add(node.right)
                if present_layer.length == 0:
                    if next_layer.length==0:
                        layers_present=False
                    else:
                        present_layer = next_layer
                        next_layer = LinkedList()
        return root


class LinkNode:
    def __init__(self, val):
        self.val = val
        self.next = None


class LinkedList:
    def __init__(self):
        self._head = None
        self._tail = None
        self._length = 0

    def has_next(self):
        return self._length > 0

    def peek(self):
        if self._length < 1:
            return None
        return self._head.val

    def add(self, val):
        if self._head is None:
            self._head = LinkNode(val)
            self._tail = self._head
            self._length = 1
            return
        elif self._length == 1:
            self._tail = LinkNode(val)
            self._head.next = self._tail
            self._length = 2
            return
        else:
            tail = LinkNode(val)
            self._tail.next = tail
            self._tail = tail
            self._length += 1

    def pop(self):
        if self._length == 0:
            return None
        val = self._head.val
        if self._length == 1:
            self._length = 0
            self._head = None
            self._tail = None
            self._length = 0
        else:
            self._head = self._head.next
            self._length -= 1
        return val

    @property
    def length(self):
        return self._length
