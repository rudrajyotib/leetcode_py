from unittest import TestCase
from btree_bst_to_greater_sum_tree import TreeNode, Solution


class TestSolution(TestCase):
    def test_bst_to_gst_set1(self):
        solution = Solution()
        result = solution.bstToGst(root=TreeNode(val=10,
                                                 left=TreeNode(val=5,
                                                               left=TreeNode(val=2),
                                                               right=TreeNode(val=8,
                                                                              left=TreeNode(val=7))),
                                                 right=TreeNode(val=15,
                                                                left=TreeNode(val=12),
                                                                right=TreeNode(val=19,
                                                                               left=TreeNode(val=17),
                                                                               right=TreeNode(val=20)))))

        self.assertEqual(93, result.val, "Invalid GST")
        self.assertEqual(113, result.left.val, "invalid left GST")
        self.assertEqual(115, result.left.left.val, "invalid left GST")
        self.assertEqual(108, result.left.right.left.val, "invalid left GST")
        self.assertEqual(101, result.left.right.val, "invalid left GST")

    def test_bst_to_gst_set2(self):
        solution = Solution()
        result = solution.bstToGst(root=TreeNode(val=10))
        self.assertEqual(10, result.val)

    def test_bst_to_gst_set3(self):
        solution = Solution()
        result = solution.bstToGst(root=TreeNode(val=10,
                                                 left=TreeNode(val=9,
                                                               left=TreeNode(val=8))))
        self.assertEqual(10, result.val)
        self.assertEqual(19, result.left.val)
        self.assertEqual(27, result.left.left.val)

    def test_bst_to_gst_set4(self):
        solution = Solution()
        result = solution.bstToGst(root=TreeNode(val=10,
                                                 right=TreeNode(val=19,
                                                                right=TreeNode(val=28))))
        self.assertEqual(57, result.val)
        self.assertEqual(47, result.right.val)
        self.assertEqual(28, result.right.right.val)

    def test_bst_to_gst_set5(self):
        root = TreeNode(val=40,
                        left=TreeNode(val=20),
                        right=TreeNode(val=60,
                                       left=TreeNode(val=50,
                                                     left=TreeNode(val=45),
                                                     right=TreeNode(val=55,
                                                                    left=TreeNode(val=52),
                                                                    right=TreeNode(val=57))),
                                       right=TreeNode(val=70, left=TreeNode(val=65))))
        solution = Solution()
        result = solution.bstToGst(root)
        self.assertEqual(135, result.right.right.left.val)
        self.assertEqual(70, result.right.right.val)
        self.assertEqual(195, result.right.val)
        self.assertEqual(252, result.right.left.right.right.val)
        self.assertEqual(359, result.right.left.right.left.val)
        self.assertEqual(307, result.right.left.right.val)
        self.assertEqual(494, result.val)
