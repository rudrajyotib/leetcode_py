class ListNode:
    # noinspection PyShadowingBuiltins
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # noinspection PyMethodMayBeStatic
    def swapPairs(self, head: ListNode) -> ListNode:

        if head is None:
            # noinspection PyTypeChecker
            return None
        if head.next is None:
            return head
        temp_node2 = head.next.next
        temp_node1 = head
        head = head.next
        head.next = temp_node1
        head.next.next = temp_node2
        if temp_node2 is None:
            return head
        swap_possible = True
        swap_node1 = temp_node2
        swap_node2 = swap_node1.next
        last_swapped_node = head.next
        while swap_possible:
            if not swap_node2 or not swap_node1:
                swap_possible = False
            else:
                temp_node2 = swap_node2.next
                last_swapped_node.next = swap_node2
                swap_node2.next = swap_node1
                last_swapped_node = swap_node1
                last_swapped_node.next = temp_node2
                if last_swapped_node.next is None:
                    swap_possible = False
                else:
                    swap_node1 = last_swapped_node.next
                    swap_node2 = swap_node1.next

        return head
