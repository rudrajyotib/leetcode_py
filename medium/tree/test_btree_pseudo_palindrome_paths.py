from unittest import TestCase

from medium.tree.btree_pseudo_palindrome_paths import is_palindromable, TreeNode, Solution


class Test(TestCase):
    def test_is_palindromable(self):
        self.assertTrue(is_palindromable("010"))
        self.assertFalse(is_palindromable("123"))
        self.assertTrue(is_palindromable("444454444"))
        self.assertFalse(is_palindromable("90182787383"))

    def test_should_identify_palindromable_paths_set1(self):
        tree = TreeNode(val=1,
                        left=TreeNode(val=1,
                                      left=TreeNode(val=1),
                                      right=TreeNode(val=1)),
                        right=TreeNode(val=1,
                                       left=TreeNode(val=1),
                                       right=TreeNode(val=1)))

        solution = Solution()

        self.assertEqual(4, solution.pseudoPalindromicPaths(root=tree))

    def test_should_identify_palindromable_paths_set2(self):
        tree = TreeNode(val=1,
                        left=TreeNode(val=2,
                                      left=TreeNode(val=3,
                                                    left=TreeNode(val=2,
                                                                  left=TreeNode(val=1))),
                                      right=TreeNode(val=4)),
                        right=TreeNode(val=1,
                                       left=TreeNode(val=3),
                                       right=TreeNode(val=4)))

        solution = Solution()

        self.assertEqual(3, solution.pseudoPalindromicPaths(root=tree))

    def test_should_identify_palindromable_paths_set3(self):
        tree = TreeNode(val=1,
                        left=TreeNode(val=2,
                                      left=TreeNode(val=3,
                                                    left=TreeNode(val=3,
                                                                  left=TreeNode(val=5))),
                                      right=TreeNode(val=4)),
                        right=TreeNode(val=2,
                                       left=TreeNode(val=3),
                                       right=TreeNode(val=4)))

        solution = Solution()

        self.assertEqual(0, solution.pseudoPalindromicPaths(root=tree))

    def test_should_identify_palindromable_paths_set4(self):
        tree = TreeNode(val=1)

        solution = Solution()

        self.assertEqual(1, solution.pseudoPalindromicPaths(root=tree))
