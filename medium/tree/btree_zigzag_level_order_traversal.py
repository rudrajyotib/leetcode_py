class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def zigzagLevelOrder(self, root: TreeNode):
        if root is None:
            return []
        result = [[root.val]]
        next_level = LinkedList()
        if root.left is not None:
            next_level.add(root.left)
        if root.right is not None:
            next_level.add(root.right)
        if next_level.length == 0:
            return result
        next_level_present = True
        left_to_right = False
        while next_level_present:
            temp_next_level = LinkedList()
            line_result = []
            while next_level.has_next():
                node = next_level.pop()
                if node.left:
                    temp_next_level.add(node.left)
                if node.right:
                    temp_next_level.add(node.right)
                line_result.append(node.val)
            next_level = temp_next_level
            if temp_next_level.length == 0:
                next_level_present = False
            if left_to_right :
                left_to_right = False
            else :
                line_result.reverse()
                left_to_right = True
            result.append(line_result)

        return result


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
