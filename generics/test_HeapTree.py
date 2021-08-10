from unittest import TestCase

from generics.HeapTree import TreeNode, HeapTree


class TestHeapTree(TestCase):
    def test_create_heap_from_list_set1(self):
        heap_tree = HeapTree()
        result: TreeNode = heap_tree.create_heap_from_List(input_array=[4, 10, 3, 5, 1])
        self.assertEqual(10, result.val)

    def test_create_heap_from_list_set2(self):
        heap_tree = HeapTree()
        result: TreeNode = heap_tree.create_heap_from_List(input_array=[1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17])
        self.assertEqual(17, result.val)
        self.assertEqual(15, result.left.val)
        self.assertEqual(13, result.right.val)
        self.assertEqual(10, result.right.right.val)
        self.assertEqual(5, result.right.left.val)
        self.assertEqual(9, result.left.left.val)
        self.assertEqual(6, result.left.right.val)
        self.assertEqual(1, result.left.right.right.val)
        self.assertEqual(3, result.left.right.left.val)
        self.assertEqual(4, result.left.left.left.val)
        self.assertEqual(8, result.left.left.right.val)
