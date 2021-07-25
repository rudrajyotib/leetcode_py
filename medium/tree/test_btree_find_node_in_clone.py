from unittest import TestCase

from medium.tree.btree_find_node_in_clone import TreeNode, Solution


class TestSolution(TestCase):
    def test_get_target_copy(self):
        orig_level2_child1 = TreeNode(4)
        orig_level2_child2 = TreeNode(5)
        orig_level1_child1 = TreeNode(2)
        orig_level1_child2 = TreeNode(3)
        orig_level1_child2.left = orig_level2_child1
        orig_level2_child2.right = orig_level2_child2
        orig_root = TreeNode(1)
        orig_root.left = orig_level1_child1
        orig_root.right = orig_level1_child2

        cloned_level2_child1 = TreeNode(4)
        cloned_level2_child2 = TreeNode(5)
        cloned_level1_child1 = TreeNode(2)
        cloned_level1_child2 = TreeNode(3)
        cloned_level1_child2.left = cloned_level2_child1
        cloned_level2_child2.right = cloned_level2_child2
        cloned_root = TreeNode(1)
        cloned_root.left = cloned_level1_child1
        cloned_root.right = cloned_level1_child2

        solution = Solution()
        target_set1 = solution.getTargetCopy(original= orig_root,
                                       cloned= cloned_root,
                                       target=orig_level1_child1)

        self.assertEqual(cloned_level1_child1.val, target_set1.val, "cloned node not found")
        self.assertTrue(cloned_level1_child1 is target_set1, "cloned node not found")
        self.assertFalse(orig_level1_child1 is target_set1, "original node found")

        target_set2 = solution.getTargetCopy(original= orig_root,
                                       cloned= cloned_root,
                                       target=orig_root)

        self.assertEqual(cloned_root.val, target_set2.val, "cloned node not found")
        self.assertTrue(cloned_root is target_set2, "cloned node not found")
        self.assertFalse(orig_root is target_set2, "original node found")
