from unittest import TestCase
from medium.tree import btree_zigzag_level_order_traversal


class TestSolution(TestCase):
    def test_level_order_with_2_child_nodes(self):
        level1_child1 = btree_zigzag_level_order_traversal.TreeNode(2, None, None)
        level1_child2 = btree_zigzag_level_order_traversal.TreeNode(3, None, None)
        root_node = btree_zigzag_level_order_traversal.TreeNode(1, level1_child1, level1_child2)

        s1 = btree_zigzag_level_order_traversal.Solution()
        result = s1.zigzagLevelOrder(root_node)
        self.assertEqual([[1], [3, 2]], result, "Traversal does not match")

    def test_level_order_with_0_child_nodes(self):
        root_node = btree_zigzag_level_order_traversal.TreeNode(1)

        s1 = btree_zigzag_level_order_traversal.Solution()
        result = s1.zigzagLevelOrder(root_node)
        self.assertEqual([[1]], result, "Traversal does not match")

    def test_level_order_with_empty_root(self):
        s1 = btree_zigzag_level_order_traversal.Solution()
        # noinspection PyTypeChecker
        result = s1.zigzagLevelOrder(None)
        self.assertEqual([], result, "Traversal does not match")

    def test_level_order_with_mix_of_child_nodes(self):
        level1_child1 = btree_zigzag_level_order_traversal.TreeNode(2, None, None)
        level1_child2 = btree_zigzag_level_order_traversal.TreeNode(3, None, None)
        level2_child2 = btree_zigzag_level_order_traversal.TreeNode(5, None, None)
        level2_child3 = btree_zigzag_level_order_traversal.TreeNode(6, None, None)
        level2_child4 = btree_zigzag_level_order_traversal.TreeNode(7, None, None)
        level1_child1.right = level2_child2
        level1_child2.left=level2_child3
        level1_child2.right=level2_child4
        root_node = btree_zigzag_level_order_traversal.TreeNode(1, level1_child1, level1_child2)

        s1 = btree_zigzag_level_order_traversal.Solution()
        result = s1.zigzagLevelOrder(root_node)
        self.assertEqual([[1], [3,2], [5,6,7]], result, "Traversal does not match")

    def test_should_create_linked_list(self):
        linked_list = btree_zigzag_level_order_traversal.LinkedList()
        linked_list.add(1)
        linked_list.add(2)
        linked_list.add(3)
        linked_list.add(4)

        self.assertEqual(4, linked_list._length, "not added")
        self.assertEqual(1, linked_list.pop(), "Head not retrieved")
        self.assertEqual(3, linked_list._length, "after pop length not adjusted")
        self.assertEqual(2, linked_list.pop(), "Head not retrieved")
        self.assertEqual(3, linked_list.pop(), "Head not retrieved")
        self.assertEqual(1, linked_list._length, "after pop length not adjusted")
        linked_list.add(5)
        linked_list.add(6)
        linked_list.add(7)
        self.assertEqual(4, linked_list._length, "after add length not adjusted")
        self.assertEqual(4, linked_list.pop(), "Head not retrieved")
        self.assertEqual(5, linked_list.pop(), "Head not retrieved")
        self.assertEqual(6, linked_list.pop(), "Head not retrieved")
        self.assertEqual(7, linked_list.pop(), "Head not retrieved")
        self.assertEqual(0, linked_list._length, "after pop length not adjusted")
        self.assertIsNone(linked_list.pop(), "non empty value returned when pop called on empty list")
        linked_list.add(8)
        linked_list.add(9)
        linked_list.add(10)
        self.assertEqual(3, linked_list._length, "cannot re-initialise an empty list")
