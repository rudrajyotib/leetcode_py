# Definition for singly-linked list.
from typing import List


class ListNode:
    # noinspection PyShadowingBuiltins
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # noinspection PyMethodMayBeStatic
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:

        linked_list_array: List[ListNode] = []
        temp_head = head
        while temp_head:
            linked_list_array.append(temp_head)
            temp_head = temp_head.next
        list_len = len(linked_list_array)
        if n == list_len:
            return head.next
        if n == 1:
            linked_list_array[list_len - 2].next = None
            return head
        linked_list_array[(list_len - n - 1)].next = linked_list_array[(list_len + 1 - n)]
        return head
