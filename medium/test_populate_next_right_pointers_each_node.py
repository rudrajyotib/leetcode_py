from unittest import TestCase

from medium.populate_next_right_pointers_each_node import Node, Solution


class TestSolution(TestCase):

    def test_should_handle_none(self):
        solution = Solution()
        solution.connect(None)

    def test_should_handle_single_child(self):
        rootNode = Node(val=1)
        level1_child1 = Node(val=2)
        rootNode.left = level1_child1

        solution = Solution()
        solution.connect(rootNode)

        self.assertIsNone(rootNode.next)
        self.assertIsNone(rootNode.left.next)

    def test_should_connect_to_right(self):
        rootNode = Node(val=1)
        level1_child1 = Node(val=2)
        level1_child2 = Node(val=3)
        level2_child1 = Node(val=4)
        level2_child2 = Node(val=5)
        level2_child3 = Node(val=6)
        level2_child4 = Node(val=7)
        rootNode.left = level1_child1
        rootNode.right = level1_child2

        level1_child1.left=level2_child1
        level1_child1.right = level2_child2
       # level1_child2.left=level2_child3
        level1_child2.right=level2_child4

        solution = Solution()
        solution.connect(rootNode)

        self.assertIsNone(rootNode.next)
        self.assertIsNotNone(level1_child1.next)
        self.assertEqual(level1_child1.next.val, 3, "Not pointing to correct right")
        self.assertIsNone(level1_child2.next, "wrong assignment of next")
        self.assertIsNone(level2_child4.next, "wrong assignment of next")

        self.assertEqual(level2_child1.next.val, level2_child2.val, "wrong assignment of next")
        self.assertEqual(level2_child2.next.val, level2_child4.val, "wrong assignment of next")
      #  self.assertEqual(level2_child3.next.val, level2_child4.val, "wrong assignment of next")



