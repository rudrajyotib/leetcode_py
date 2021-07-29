from unittest import TestCase

from medium.graph.check_graph_bipartite import Solution


class TestSolution(TestCase):
    def test_is_bipartite_set1(self):
        solution = Solution()
        self.assertTrue(solution.isBipartite(graph=[[1, 2],
                                                    [0, 3],
                                                    [0, 4],
                                                    [1, 5],
                                                    [2, 5],
                                                    [3, 4]]))

    def test_is_bipartite_set2(self):
        solution = Solution()
        self.assertFalse(solution.isBipartite(graph=[[1, 2],
                                                     [0, 3],
                                                     [0, 4],
                                                     [1, 4, 5],
                                                     [2, 5],
                                                     [3, 4]]))

    def test_is_bipartite_set3(self):
        solution = Solution()
        self.assertTrue(solution.isBipartite(graph=[[1, 2, 3],
                                                    [0],
                                                    [0],
                                                    [0]]))

    def test_is_bipartite_set4(self):
        solution = Solution()
        self.assertTrue(solution.isBipartite(graph=[[1, 2, 3],
                                                    [0, 4],
                                                    [0, 4],
                                                    [0],
                                                    [1, 2]]))

    def test_is_bipartite_set5(self):
        solution = Solution()
        self.assertTrue(solution.isBipartite(graph=[[1, 2, 3],
                                                    [0, 4],
                                                    [0, 4],
                                                    [0, 4],
                                                    [1, 2, 3]]))

    def test_is_bipartite_set6(self):
        solution = Solution()
        self.assertFalse(solution.isBipartite(graph=[[1, 2, 3],
                                                     [0, 4],
                                                     [0, 4],
                                                     [0, 5],
                                                     [1, 2, 5],
                                                     [4, 3]]))

    def test_is_bipartite_set7(self):
        solution = Solution()
        self.assertTrue(solution.isBipartite(graph=[[1, 2, 3],
                                                    [0, 4],
                                                    [0, 4],
                                                    [0, 4],
                                                    [1, 2, 3],
                                                    []]))

    def test_is_bipartite_set8(self):
        solution = Solution()
        self.assertTrue(solution.isBipartite(graph=[[2, 3, 4],
                                                    [],
                                                    [0, 5],
                                                    [0, 5],
                                                    [0, 5],
                                                    [2, 3, 4],
                                                    []]))

    def test_is_bipartite_set9(self):
        solution = Solution()
        self.assertFalse(solution.isBipartite(graph=[[],
                                                     [2, 4, 6],
                                                     [1, 4, 8, 9],
                                                     [7, 8],
                                                     [1, 2, 8, 9],
                                                     [6, 9],
                                                     [1, 5, 7, 8, 9],
                                                     [3, 6, 9],
                                                     [2, 3, 4, 6, 9],
                                                     [2, 4, 5, 6, 7, 8]]))

    def test_is_bipartite_set10(self):
        solution = Solution()
        self.assertTrue(solution.isBipartite(graph=[[]]))

    def test_is_bipartite_set11(self):
        solution = Solution()
        self.assertFalse(solution.isBipartite(
            graph=[[2, 4],
                   [2, 3, 4],
                   [0, 1],
                   [1],
                   [0, 1],
                   [7],
                   [9],
                   [5],
                   [],
                   [6],
                   [12, 14],
                   [],
                   [10],
                   [],
                   [10],
                   [19],
                   [18],
                   [],
                   [16],
                   [15],
                   [23],
                   [23],
                   [],
                   [20, 21],
                   [],
                   [],
                   [27],
                   [26],
                   [],
                   [],
                   [34],
                   [33, 34],
                   [],
                   [31],
                   [30, 31],
                   [38, 39],
                   [37, 38, 39],
                   [36],
                   [35, 36],
                   [35, 36],
                   [43],
                   [],
                   [],
                   [40],
                   [],
                   [49],
                   [47, 48, 49],
                   [46, 48, 49],
                   [46, 47, 49],
                   [45, 46, 47, 48]]))
