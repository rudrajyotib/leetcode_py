from unittest import TestCase

from medium.tree.btree_flatten_linked_list import StackLinkedList, TreeNode, Solution


class TestStackLinkedList(TestCase):
    def test_stack_linked_list(self):
        stack = StackLinkedList()
        stack.add(1)
        stack.add(2)
        self.assertEqual(2, stack.length, "stack length does not match")
        self.assertEqual(2, stack.pop(), "Last is not first out")
        self.assertEqual(1, stack.pop(), "Single element not popped")
        self.assertEqual(0, stack.length, "empty stack length does not match")
        stack.add(3)
        stack.add(4)
        stack.add(5)
        self.assertEqual(3, stack.length, "stack length does not match")
        self.assertEqual(5, stack.pop(), "Last is not first out")
        self.assertEqual(4, stack.pop(), "Last is not first out")
        stack.add(6)
        self.assertEqual(6, stack.pop(), "Last is not first out")
        self.assertEqual(1, stack.length, "stack length does not match")
        self.assertEqual(3, stack.pop(), "Single element not popped")
        self.assertEqual(0, stack.length, "empty stack length does not match")


class TestSolution(TestCase):
    def test_should_flatten_3_levels(self):
        root_node = TreeNode(val=1)
        level1_child1 = TreeNode(val=2)
        level1_child2 = TreeNode(val=5)
        level2_child1 = TreeNode(val=3)
        level2_child2 = TreeNode(val=4)
        level2_child3 = TreeNode(val=6)
        level2_child4 = TreeNode(val=7)

        root_node.left = level1_child1
        root_node.right = level1_child2

        level1_child1.left = level2_child1
        level1_child1.right = level2_child2
        level1_child2.left = level2_child3
        level1_child2.right = level2_child4

        solution = Solution()
        solution.flatten(root_node)

        self.assertIsNone(root_node.left)
        self.assertEqual(1, root_node.val, "Root node value does not match")

        result_range = range(1, 8, 1)

        for i in result_range:
            self.assertEqual(i, root_node.val, "Value at iteration {} does not match".format(i))
            self.assertIsNone(root_node.left)
            root_node = root_node.right

    def test_should_flatten_only_root(self):
        root_node = TreeNode(val=1)
        solution = Solution()
        solution.flatten(root_node)

        self.assertIsNone(root_node.left)
        self.assertIsNone(root_node.right)

        self.assertEqual(1, root_node.val)

    def test_should_handle_none_root(self):
        solution = Solution()
        # noinspection PyTypeChecker
        solution.flatten(root=None)