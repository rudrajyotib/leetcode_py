from unittest import TestCase

from medium.algorithm.remove_nth_node_from_end import ListNode, Solution


class TestSolution(TestCase):
    def test_remove_nth_from_end_set1(self):
        head = ListNode(val=0,
                        next=ListNode(
                            val=1,
                            next=ListNode(
                                val=2,
                                next=ListNode(
                                    val=3,
                                    next=ListNode(
                                        val=4,
                                        next=ListNode(
                                            val=5,
                                            next=ListNode(
                                                val=6,
                                                next=ListNode(
                                                    val=7))))))))
        solution = Solution()
        updated_head = solution.removeNthFromEnd(head=head, n=1)
        last_element = updated_head
        while last_element.next:
            last_element = last_element.next
        self.assertEqual(6, last_element.val)

    def test_remove_nth_from_end_set2(self):
        head = ListNode(val=0,
                        next=ListNode(
                            val=1,
                            next=ListNode(
                                val=2,
                                next=ListNode(
                                    val=3,
                                    next=ListNode(
                                        val=4,
                                        next=ListNode(
                                            val=5,
                                            next=ListNode(
                                                val=6,
                                                next=ListNode(
                                                    val=7))))))))
        solution = Solution()
        updated_head = solution.removeNthFromEnd(head=head, n=8)
        self.assertEqual(1, updated_head.val)

    def test_remove_nth_from_end_set3(self):
        head = ListNode(val=0,
                        next=ListNode(
                            val=1,
                            next=ListNode(
                                val=2,
                                next=ListNode(
                                    val=3,
                                    next=ListNode(
                                        val=4,
                                        next=ListNode(
                                            val=5,
                                            next=ListNode(
                                                val=6,
                                                next=ListNode(
                                                    val=7))))))))
        solution = Solution()
        updated_head = solution.removeNthFromEnd(head=head, n=7)
        self.assertEqual(0, updated_head.val)
        self.assertEqual(2, updated_head.next.val)
