from unittest import TestCase

from medium.n_ary_tree_level_order_traversal import Node, Solution


class TestSolution(TestCase):
    def test_level_order(self):
        level3_child1 = Node(val=20)
        level3_child2 = Node(val=21)
        level3_child3 = Node(val=22)
        level3_child4 = Node(val=23)
        level3_child5 = Node(val=24)
        level3_child6 = Node(val=25)

        level2_child1 = Node(val=10, children=[level3_child1, level3_child2, level3_child3])
        level2_child2 = Node(val=10, children=[level3_child4, level3_child5, level3_child6])

        level1_child1 = Node(val=1, children=[level2_child1, level2_child2])

        root = Node(val=0, children=[level1_child1])

        solution = Solution()

        result = solution.levelOrder(root)

        self.assertIsNotNone(result, "Null result reported")
        self.assertEqual(4, len(result), "Not all levels reported")
        self.assertEqual(0, result[0][0], "root not reported")
        self.assertEqual(1, len(result[1]), "Level1 not correctly reported")
        self.assertEqual(2, len(result[2]), "Level2 not correctly reported")
        self.assertEqual([10, 10], (result[2]), "Level2 content not correctly reported")
        self.assertEqual([20, 21, 22, 23, 24, 25], (result[3]), "Level3 content not correctly reported")

