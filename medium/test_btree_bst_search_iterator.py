from unittest import TestCase

from medium.btree_bst_search_iterator import TreeNode, BSTIterator


class Test(TestCase):
    def test_print_in_order(self):
        level4_child1 = TreeNode(val=11)
        level4_child2 = TreeNode(val=9)
        level3_child1 = TreeNode(val=10, left=level4_child1)
        level3_child2 = TreeNode(val=8, right=level4_child2)
        level2_child1 = TreeNode(val=3)
        level2_child2 = TreeNode(val=4, left=level3_child1)
        level2_child3 = TreeNode(val=6)
        level2_child4 = TreeNode(val=7, left=level3_child2)
        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=5, left=level2_child3, right=level2_child4)
        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        iterator = BSTIterator(root=root)
        self.assertTrue(iterator.hasNext(), "Iterator not generated")
        self.assertEqual(3, iterator.next(), "Iterator does not return correct first element")
        for i in range(1, 10, 1):
            iterator.next()
        self.assertTrue(iterator.hasNext(), "Last element is discarded")
        self.assertEqual(7, iterator.next(), "Last element wrong")
        self.assertFalse(iterator.hasNext(), "Last pointer messed up")
