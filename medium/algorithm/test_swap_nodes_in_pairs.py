from unittest import TestCase

from medium.algorithm.swap_nodes_in_pairs import ListNode, Solution


class TestSolution(TestCase):
    def test_swap_pairs_set1(self):
        head = ListNode(val=1,
                        next=ListNode(val=2,
                                      next=ListNode(val=3,
                                                    next=ListNode(val=4,
                                                                  next=ListNode(val=5)))))
        solution = Solution()
        result_head = solution.swapPairs(head=head)
        self.assertEqual(2, result_head.val)
        self.assertEqual(1, result_head.next.val)
        self.assertEqual(4, result_head.next.next.val)
        self.assertEqual(3, result_head.next.next.next.val)
        self.assertEqual(5, result_head.next.next.next.next.val)
        self.assertIsNone(result_head.next.next.next.next.next)

    def test_swap_pairs_set2(self):
        head = ListNode(val=1)
        solution = Solution()
        updated_head = solution.swapPairs(head=head)
        self.assertEqual(1, updated_head.val)
        self.assertIsNone(updated_head.next)

    def test_swap_pairs_set3(self):
        head = ListNode(val=1,
                        next=ListNode(val=2))
        solution = Solution()
        updated_head = solution.swapPairs(head=head)
        self.assertEqual(2, updated_head.val)
        self.assertEqual(1, updated_head.next.val)
        self.assertIsNone(updated_head.next.next)
