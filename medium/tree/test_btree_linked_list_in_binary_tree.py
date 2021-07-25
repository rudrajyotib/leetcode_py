from unittest import TestCase

from medium.tree.btree_linked_list_in_binary_tree import ListNode, TreeNode, Solution


class TestSolution(TestCase):
    def test_is_sub_path_set1(self):
        link_list = ListNode(val=2, next=ListNode(val=4, next=ListNode(val=9)))
        tree = TreeNode(val=1,
                        left=TreeNode(val=2,
                                      left=TreeNode(val=5),
                                      right=TreeNode(val=6,
                                                     left=TreeNode(val=7))),
                        right=TreeNode(val=2,
                                       left=TreeNode(val=3),
                                       right=TreeNode(val=4,
                                                      left=TreeNode(val=8),
                                                      right=TreeNode(val=9))))

        solution = Solution()
        self.assertTrue(solution.isSubPath(head=link_list, root=tree))

    def test_is_sub_path_set2(self):
        link_list = ListNode(val=4, next=ListNode(val=4, next=ListNode(val=2)))
        tree = TreeNode(val=1,
                        left=TreeNode(val=2,
                                      left=TreeNode(val=5),
                                      right=TreeNode(val=6,
                                                     left=TreeNode(val=7))),
                        right=TreeNode(val=2,
                                       left=TreeNode(val=4,
                                                     left=TreeNode(val=4,
                                                                   left=TreeNode(val=4,
                                                                                 left=TreeNode(val=2)),
                                                                   right=TreeNode(val=3))),
                                       right=TreeNode(val=4,
                                                      left=TreeNode(val=8),
                                                      right=TreeNode(val=9))))

        solution = Solution()
        self.assertTrue(solution.isSubPath(head=link_list, root=tree))

    def test_is_sub_path_set3(self):
        link_list = ListNode(val=4, next=ListNode(val=4, next=ListNode(val=2)))
        tree = TreeNode(val=1,
                        left=TreeNode(val=2,
                                      left=TreeNode(val=5),
                                      right=TreeNode(val=6,
                                                     left=TreeNode(val=7))),
                        right=TreeNode(val=2,
                                       left=TreeNode(val=4,
                                                     left=TreeNode(val=4,
                                                                   left=TreeNode(val=4,
                                                                                 left=TreeNode(val=12)),
                                                                   right=TreeNode(val=3))),
                                       right=TreeNode(val=4,
                                                      left=TreeNode(val=8),
                                                      right=TreeNode(val=9))))

        solution = Solution()
        self.assertFalse(solution.isSubPath(head=link_list, root=tree))

    def test_is_sub_path_set4(self):
        link_list = ListNode(val=1, next=ListNode(val=2, next=ListNode(val=1, next=ListNode(2, next=ListNode(2)))))
        tree = TreeNode(val=1,
                        left=TreeNode(val=2,
                                      left=TreeNode(val=1,
                                                    left=TreeNode(val=2,
                                                                  left=TreeNode(val=1,
                                                                                left=TreeNode(val=2,
                                                                                              left=TreeNode(val=2)))),
                                                    right=TreeNode(val=2)),
                                      right=TreeNode(val=1,
                                                     left=TreeNode(val=2),
                                                     right=TreeNode(val=2))),
                        right=TreeNode(val=2,
                                       left=TreeNode(val=1,
                                                     left=TreeNode(val=2),
                                                     right=TreeNode(val=2)),
                                       right=TreeNode(val=1,
                                                      left=TreeNode(val=2),
                                                      right=TreeNode(val=2))))

        solution = Solution()
        self.assertTrue(solution.isSubPath(root=tree, head=link_list))

    def test_is_sub_path_set5(self):
        link_list = ListNode(val=1, next=ListNode(val=2, next=ListNode(val=1, next=ListNode(2, next=ListNode(2)))))
        tree = TreeNode(val=1,
                        left=TreeNode(val=2,
                                      left=TreeNode(val=1,
                                                    left=TreeNode(val=2,
                                                                  left=TreeNode(val=1,
                                                                                left=TreeNode(val=2,
                                                                                              left=TreeNode(val=3)))),
                                                    right=TreeNode(val=2)),
                                      right=TreeNode(val=1,
                                                     left=TreeNode(val=2),
                                                     right=TreeNode(val=2))),
                        right=TreeNode(val=2,
                                       left=TreeNode(val=1,
                                                     left=TreeNode(val=2),
                                                     right=TreeNode(val=2)),
                                       right=TreeNode(val=1,
                                                      left=TreeNode(val=2),
                                                      right=TreeNode(val=2))))

        solution = Solution()
        self.assertFalse(solution.isSubPath(root=tree, head=link_list))

    def test_is_sub_path_set6(self):
        link_list = ListNode(val=1)
        tree = TreeNode(val=1)
        solution = Solution()
        self.assertTrue(solution.isSubPath(root=tree, head=link_list))
