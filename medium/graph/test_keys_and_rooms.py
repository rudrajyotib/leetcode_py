from unittest import TestCase

from medium.graph.keys_and_rooms import Solution


class TestSolution(TestCase):
    def test_can_visit_all_rooms_set1(self):
        solution = Solution()
        self.assertFalse(solution.canVisitAllRooms(rooms=[[1, 2],
                                                          [0, 3],
                                                          [0, 3],
                                                          [1, 2],
                                                          [5],
                                                          [6],
                                                          []]))

    def test_can_visit_all_rooms_set2(self):
        solution = Solution()
        self.assertTrue(solution.canVisitAllRooms(rooms=[[1, 2],
                                                          [0, 3],
                                                          [0, 3, 4],
                                                          [1, 2],
                                                          [5],
                                                          [6],
                                                          []]))
