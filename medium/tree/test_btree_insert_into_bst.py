from unittest import TestCase

from medium.tree.btree_insert_into_bst import TreeNode, Solution


def create_bst() -> TreeNode:
    level4_child1 = TreeNode(val=56)
    level4_child2 = TreeNode(val=68)
    level4_child3 = TreeNode(val=80)
    level4_child4 = TreeNode(val=92)
    level4_child5 = TreeNode(val=160)
    level4_child6 = TreeNode(val=172)
    level4_child7 = TreeNode(val=190)
    level4_child8 = TreeNode(val=220)

    level3_child1 = TreeNode(val=62, left=level4_child1, right=level4_child2)
    level3_child2 = TreeNode(val=87, left=level4_child3, right=level4_child4)
    level3_child3 = TreeNode(val=166, left=level4_child5, right=level4_child6)
    level3_child4 = TreeNode(val=200, left=level4_child7, right=level4_child8)

    level2_child1 = TreeNode(val=25)
    level2_child2 = TreeNode(val=75, left=level3_child1, right=level3_child2)
    level2_child3 = TreeNode(val=125)
    level2_child4 = TreeNode(val=175, left=level3_child3, right=level3_child4)

    level1_child1 = TreeNode(val=50, left=level2_child1, right=level2_child2)
    level1_child2 = TreeNode(val=150, left=level2_child3, right=level2_child4)

    root = TreeNode(val=100, left=level1_child1, right=level1_child2)

    return root


class TestSolution(TestCase):

    def test_should_insert_right_subtree_leaf(self):
        root: TreeNode = create_bst()
        solution = Solution()
        solution.insertIntoBST(root=root, val=140)
        self.assertEqual(140, root.right.left.right.val, "Leaf node not inserted")
        self.assertIsNone(root.right.left.right.left, "new node is not leaf node")
        self.assertIsNone(root.right.left.right.right, "new node is not leaf node")

    def test_should_insert_left_subtree_leaf(self):
        root: TreeNode = create_bst()
        solution = Solution()
        solution.insertIntoBST(root=root, val=10)
        self.assertEqual(10, root.left.left.left.val, "Leaf node not inserted")
        self.assertIsNone(root.left.left.left.left, "new node is not leaf node")
        self.assertIsNone(root.left.left.left.right, "new node is not leaf node")

    def test_should_insert_at_the_bottom_level(self):
        root: TreeNode = create_bst()
        solution = Solution()
        solution.insertIntoBST(root=root, val=82)
        self.assertEqual(82, root.left.right.right.left.right.val, "Leaf node not inserted")
        self.assertIsNone(root.left.right.right.left.right.left, "new node is not leaf node")
        self.assertIsNone(root.left.right.right.left.right.right, "new node is not leaf node")

    def test_should_add_to_single_node_tree(self):
        root = TreeNode(val=100)
        solution = Solution()
        solution.insertIntoBST(root=root, val=120)
        self.assertEqual(120, root.right.val, "right node not assigned")
        self.assertIsNone(root.left)
        self.assertIsNone(root.right.left)
        self.assertIsNone(root.right.right)

    def test_should_add_to_empty_array(self):
        solution = Solution()
        # noinspection PyTypeChecker
        root = solution.insertIntoBST(root=None, val=10)
        self.assertIsNotNone(root, "New root not created")
        self.assertTrue(root.left is None and root.right is None, "new node is not leaf")
        self.assertEqual(10, root.val)
