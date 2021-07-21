import collections


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Node:
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
        if self._length > 0:
            return self._head.val
        else:
            return None

    def add(self, val):
        if self._head is None:
            self._head = Node(val)
            self._tail = self._head
            self._length = 1
            return
        elif self._length == 1:
            self._tail = Node(val)
            self._head.next = self._tail
            self._length = 2
            return
        else:
            tail = Node(val)
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


class CBTInserter:

    def __init__(self, root: TreeNode):
        self._root = root
        self._queue = LinkedList()
        temp_queue = collections.deque()
        temp_queue.append(root)
        while len(temp_queue) > 0:
            node: TreeNode = temp_queue.popleft()
            if node.left and node.right:
                temp_queue.append(node.left)
                temp_queue.append(node.right)
            else:
                self._queue.add(node)
                if node.left:
                    temp_queue.append(node.left)
                if node.right:
                    temp_queue.append(node.right)

    def insert(self, v: int) -> int:
        node: TreeNode = self._queue.peek()
        new_node = TreeNode(val=v)
        if node.left:
            node.right = new_node
            self._queue.pop()
        else:
            node.left = new_node
        self._queue.add(new_node)
        return node.val

    def get_root(self) -> TreeNode:
        return self._root
