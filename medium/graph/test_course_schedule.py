from unittest import TestCase

from medium.graph.course_schedule import Solution


class TestSolution(TestCase):
    def test_should_finish_set1(self):
        solution = Solution()
        self.assertTrue(solution.canFinish(numCourses=10, prerequisites=[[0, 1], [1, 2], [2, 3], [3, 4]]))

    def test_should_finish_set2(self):
        solution = Solution()
        self.assertTrue(solution.canFinish(numCourses=10, prerequisites=[[0, 1],
                                                                         [1, 2],
                                                                         [2, 3],
                                                                         [2, 4],
                                                                         [2, 6]]))

    def test_should_finish_set3(self):
        solution = Solution()
        self.assertFalse(solution.canFinish(numCourses=2, prerequisites=[[0, 1],
                                                                         [1, 0]]))

    def test_should_finish_set4(self):
        solution = Solution()
        self.assertTrue(solution.canFinish(numCourses=6, prerequisites=[[0, 1],
                                                                        [1, 4],
                                                                        [1, 5],
                                                                        [0, 2],
                                                                        [2, 3],
                                                                        [3, 5]]))
