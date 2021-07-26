from unittest import TestCase

from medium.tree.btree_all_elements_in_two_bst import TreeNode, Solution


class TestSolution(TestCase):
    def test_get_all_elements_set1(self):
        root1 = TreeNode(val=10,
                         left=TreeNode(val=5,
                                       left=TreeNode(val=2,
                                                     left=TreeNode(val=1),
                                                     right=TreeNode(val=3)),
                                       right=TreeNode(val=8,
                                                      left=TreeNode(val=7),
                                                      right=TreeNode(val=9))),
                         right=TreeNode(val=15))

        root2 = TreeNode(val=100,
                         left=TreeNode(val=50,
                                       left=TreeNode(val=20,
                                                     left=TreeNode(val=10),
                                                     right=TreeNode(val=30)),
                                       right=TreeNode(val=80,
                                                      left=TreeNode(val=70),
                                                      right=TreeNode(val=90))),
                         right=TreeNode(val=150))
        solution = Solution()
        self.assertEqual([1, 2, 3, 5, 7, 8, 9, 10, 10, 15, 20, 30, 50, 70, 80, 90, 100, 150],
                         solution.getAllElements(root1=root1, root2=root2))

    def test_get_all_elements_set2(self):
        root1 = TreeNode(val=10,
                         left=TreeNode(val=5,
                                       left=TreeNode(val=2,
                                                     left=TreeNode(val=1),
                                                     right=TreeNode(val=3)),
                                       right=TreeNode(val=8,
                                                      left=TreeNode(val=7),
                                                      right=TreeNode(val=9))),
                         right=TreeNode(val=15))

        root2 = TreeNode(val=100,
                         left=TreeNode(val=50,
                                       left=TreeNode(val=4,
                                                     left=TreeNode(val=2),
                                                     right=TreeNode(val=8)),
                                       right=TreeNode(val=80,
                                                      left=TreeNode(val=70),
                                                      right=TreeNode(val=90))),
                         right=TreeNode(val=150))
        solution = Solution()
        self.assertEqual([1, 2, 2, 3, 4, 5, 7, 8, 8, 9, 10, 15, 50, 70, 80, 90, 100, 150],
                         solution.getAllElements(root1=root1, root2=root2))

    def test_get_all_elements_set3(self):
        root1 = TreeNode(val=10,
                         left=TreeNode(val=5,
                                       left=TreeNode(val=2,
                                                     left=TreeNode(val=1),
                                                     right=TreeNode(val=3)),
                                       right=TreeNode(val=8,
                                                      left=TreeNode(val=7),
                                                      right=TreeNode(val=9))),
                         right=TreeNode(val=15))

        solution = Solution()
        # noinspection PyTypeChecker
        self.assertEqual([1, 2, 3, 5, 7, 8, 9, 10, 15],
                         solution.getAllElements(root1=root1, root2=None))
