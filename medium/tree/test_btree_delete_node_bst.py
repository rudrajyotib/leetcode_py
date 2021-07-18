from unittest import TestCase

from medium.tree.btree_delete_node_bst import TreeNode, Solution


class TestSolution(TestCase):
    def test_should_delete_root_node(self):
        level4_child1 = TreeNode(val=76)
        level4_child2 = TreeNode(val=84)
        level3_child1 = TreeNode(val=70)
        level3_child2 = TreeNode(val=80, left=level4_child1, right=level4_child2)
        level2_child1 = TreeNode(val=40)
        level2_child2 = TreeNode(val=75, left=level3_child1, right=level3_child2)
        level2_child3 = TreeNode(val=125)
        level2_child4 = TreeNode(val=175)
        level1_child1 = TreeNode(val=50, left=level2_child1, right=level2_child2)
        level1_child2 = TreeNode(val=150, left=level2_child3, right=level2_child4)
        root = TreeNode(val=100, left=level1_child1, right=level1_child2)

        solution = Solution()

        updatedRoot = solution.deleteNode(root=root, key=75)

        self.assertEqual(updatedRoot.left.right.val, 76, "Deleted node not updated with correct value")
