from unittest import TestCase

from medium.graph.cheapest_flight_within_k_stops import Solution


class TestSolution(TestCase):
    def test_find_cheapest_price_set1(self):
        solution = Solution()
        cost = solution.findCheapestPrice(n=7, flights=[[0, 1, 60],
                                                        [0, 2, 12],
                                                        [0, 5, 10],
                                                        [1, 4, 80],
                                                        [2, 3, 6],
                                                        [5, 6, 5],
                                                        [6, 4, 30],
                                                        [3, 4, 6]], src=0, dst=4, k=2)
        self.assertEqual(24, cost)

    def test_find_cheapest_price_set2(self):
        solution = Solution()
        cost = solution.findCheapestPrice(n=7, flights=[[0, 1, 60],
                                                        [0, 2, 12],
                                                        [0, 5, 10],
                                                        [1, 4, 80],
                                                        [2, 3, 6],
                                                        [5, 6, 5],
                                                        [6, 4, 30],
                                                        [3, 4, 6],
                                                        [0, 4, 200]], src=0, dst=4, k=0)
        self.assertEqual(200, cost)

    def test_find_cheapest_price_set3(self):
        solution = Solution()
        cost = solution.findCheapestPrice(n=7, flights=[[0, 1, 60],
                                                        [0, 2, 12],
                                                        [0, 5, 10],
                                                        [1, 4, 80],
                                                        [2, 3, 6],
                                                        [5, 6, 5],
                                                        [6, 4, 30],
                                                        [3, 4, 6],
                                                        [0, 4, 200]], src=0, dst=6, k=1)
        self.assertEqual(15, cost)

    def test_find_cheapest_price_set4(self):
        solution = Solution()
        cost = solution.findCheapestPrice(n=7, flights=[[0, 1, 60],
                                                        [0, 2, 12],
                                                        [0, 5, 10],
                                                        [1, 4, 80],
                                                        [2, 3, 6],
                                                        [5, 6, 5],
                                                        [6, 4, 30],
                                                        [3, 4, 6],
                                                        [0, 4, 200]], src=0, dst=6, k=0)
        self.assertEqual(-1, cost)

    def test_find_cheapest_price_set5(self):
        solution = Solution()
        cost = solution.findCheapestPrice(n=7, flights=[[0, 1, 60],
                                                        [0, 2, 12],
                                                        [0, 5, 10],
                                                        [1, 4, 80],
                                                        [2, 3, 6],
                                                        [5, 6, 5],
                                                        [6, 4, 30],
                                                        [3, 4, 6],
                                                        [0, 4, 200]], src=3, dst=6, k=10)
        self.assertEqual(-1, cost)

    def test_find_cheapest_price_set6(self):
        solution = Solution()
        cost = solution.findCheapestPrice(n=4, flights=[[0, 1, 1],
                                                        [0, 2, 5],
                                                        [1, 2, 1],
                                                        [2, 3, 1]], src=0, dst=3, k=1)
        self.assertEqual(6, cost)
