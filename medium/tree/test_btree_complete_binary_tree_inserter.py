from unittest import TestCase

from medium.tree.btree_complete_binary_tree_inserter import TreeNode, CBTInserter


class TestCBTInserter(TestCase):

    def test_should_create_inserter_and_add(self):
        level2_child1 = TreeNode(val=4)
        level2_child2 = TreeNode(val=5)
        level2_child3 = TreeNode(val=6)

        level1_child1 = TreeNode(val=2, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=3, left=level2_child3)

        root = TreeNode(val=1, left=level1_child1, right=level1_child2)

        tree_manipulator = CBTInserter(root=root)

        self.assertEqual(1, tree_manipulator.get_root().val, "root not found")
        self.assertEqual(3, tree_manipulator.insert(7), "inserted in wrong place")
        self.assertEqual(4, tree_manipulator.insert(8), "inserted in wrong place")
        self.assertEqual(4, tree_manipulator.insert(9), "inserted in wrong place")
        self.assertEqual(5, tree_manipulator.insert(10), "inserted in wrong place")
        self.assertEqual(5, tree_manipulator.insert(11), "inserted in wrong place")
        self.assertEqual(6, tree_manipulator.insert(12), "inserted in wrong place")
        self.assertEqual(6, tree_manipulator.insert(13), "inserted in wrong place")
        self.assertEqual(1, tree_manipulator.get_root().val, "root altered")

    def test_should_start_creating_node_from_root_node(self):
        root = TreeNode(val=1)
        tree_manipulator = CBTInserter(root=root)
        self.assertEqual(1, tree_manipulator.insert(2), "not added to root")
        self.assertEqual(1, tree_manipulator.insert(3), "not added to root")
        self.assertEqual(1, tree_manipulator.get_root().val, "root altered")
