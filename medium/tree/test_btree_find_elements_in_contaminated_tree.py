from unittest import TestCase

from medium.tree.btree_find_elements_in_contaminated_tree import TreeNode, FindElements


class TestFindElements(TestCase):
    def test_should_recover_and_find_in_contaminated_tree_set1(self):
        root = TreeNode(val=-1,
                        left=TreeNode(val=-1,
                                      left=TreeNode(val=-1),
                                      right=TreeNode(val=-1)),
                        right=TreeNode(val=-1,
                                       left=TreeNode(val=-1),
                                       right=TreeNode(val=-1)))
        finder = FindElements(root=root)
        self.assertTrue(finder.find(6))
        self.assertTrue(finder.find(0))
        self.assertFalse(finder.find(10))

