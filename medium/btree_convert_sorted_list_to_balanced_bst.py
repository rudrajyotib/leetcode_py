from typing import List


class ListNode:
    # noinspection PyShadowingBuiltins
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def create_bst(array: List[int], start: int, end: int) -> TreeNode:
    if start > end:
        # noinspection PyTypeChecker
        return None
    if start == end:
        return TreeNode(val=array[start])
    mid = int((start + end) / 2)
    root_node = TreeNode(val=array[mid])
    root_node.left = create_bst(array, start, mid - 1)
    root_node.right = create_bst(array, mid + 1, end)
    return root_node


class Solution:
    # noinspection PyPep8Naming,PyMethodMayBeStatic
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        if head is None:
            # noinspection PyTypeChecker
            return None
        sorted_array = [head.val]
        length = 0
        while head.next is not None:
            head = head.next
            sorted_array.append(head.val)
            length += 1
        return create_bst(sorted_array, 0, length)
