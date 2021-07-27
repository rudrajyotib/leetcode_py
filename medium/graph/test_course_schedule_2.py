from unittest import TestCase

from medium.graph.course_schedule_2 import Solution


class TestSolution(TestCase):
    def test_should_find_course_order_set1(self):
        solution = Solution()
        result = solution.findOrder(8, prerequisites=[[0, 1],
                                                      [1, 2],
                                                      [2, 3],
                                                      [2, 4],
                                                      [4, 3],
                                                      [4, 5]
                                                      ])
        self.assertTrue(result.index(3) < result.index(4))
        self.assertTrue(result.index(5) < result.index(4))
        self.assertTrue(result.index(4) < result.index(2))
        self.assertTrue(result.index(2) < result.index(1))
        self.assertTrue(result.index(1) < result.index(0))
        self.assertEqual(8, len(result))

    def test_should_find_course_order_set2(self):
        solution = Solution()
        result = solution.findOrder(numCourses=10, prerequisites=[[0, 1], [1, 2], [2, 3], [3, 4]])
        self.assertEqual(10, len(result))
        self.assertTrue(result.index(4) < result.index(3))
        self.assertTrue(result.index(3) < result.index(2))
        self.assertTrue(result.index(2) < result.index(1))
        self.assertTrue(result.index(1) < result.index(0))

    def test_should_find_course_order_set3(self):
        solution = Solution()
        result = solution.findOrder(numCourses=10, prerequisites=[[0, 1], [1, 0]])
        self.assertEqual(0, len(result))
