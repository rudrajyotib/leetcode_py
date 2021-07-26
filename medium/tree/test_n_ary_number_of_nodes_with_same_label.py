from unittest import TestCase

from medium.tree.n_ary_number_of_nodes_with_same_label import Solution


class TestSolution(TestCase):
    def test_count_sub_trees(self):
        solution = Solution()
        self.assertEqual([3, 1, 1, 1, 1], solution.countSubTrees(n=5,
                                                                 edges=[[0, 1], [2, 0], [3, 1], [2, 4]],
                                                                 labels="abbaa"))

        self.assertEqual([5, 2, 2, 1, 1], solution.countSubTrees(n=5,
                                                                 edges=[[0, 1], [2, 0], [3, 1], [2, 4]],
                                                                 labels="aaaaa"))

        self.assertEqual([1], solution.countSubTrees(n=1,
                                                     edges=[],
                                                     labels="a"))

        self.assertEqual([2, 1], solution.countSubTrees(n=2,
                                                        edges=[[0, 1]],
                                                        labels="aa"))
