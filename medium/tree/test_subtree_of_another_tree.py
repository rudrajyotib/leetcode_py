from unittest import TestCase

from medium.tree.subtree_of_another_tree import SubTreeOfAnotherTree, TreeNode


class TestSubTreeOfAnotherTree(TestCase):
    def test_should_validate_presence_of_subtree(self):
        solution = SubTreeOfAnotherTree()
        self.assertTrue(solution.solve(root=TreeNode(val=4,
                                                     left=TreeNode(val=2),
                                                     right=TreeNode(val=3,
                                                                    left=TreeNode(val=6),
                                                                    right=TreeNode(val=7))),
                                       subRoot=TreeNode(val=3,
                                                        left=TreeNode(val=6),
                                                        right=TreeNode(val=7))))

        self.assertFalse(solution.solve(root=TreeNode(val=4,
                                                      left=TreeNode(val=2),
                                                      right=TreeNode(val=3,
                                                                     left=TreeNode(val=6),
                                                                     right=TreeNode(val=8))),
                                        subRoot=TreeNode(val=3,
                                                         left=TreeNode(val=6),
                                                         right=TreeNode(val=7))))

        self.assertFalse(solution.solve(root=None, subRoot=TreeNode(val=1)))

        self.assertFalse(solution.solve(root=TreeNode(val=1), subRoot=None))

        self.assertTrue(solution.solve(root=TreeNode(val=1), subRoot=TreeNode(val=1)))

        self.assertFalse(solution.solve(root=TreeNode(val=2), subRoot=TreeNode(val=1)))
