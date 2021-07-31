from unittest import TestCase

from medium.graph.course_schedule_4 import Solution


class TestSolution(TestCase):
    def test_check_if_prerequisite_set1(self):
        solution = Solution()
        result = solution.checkIfPrerequisite(numCourses=4,
                                              prerequisites=[[0, 1], [1, 2], [2, 3]],
                                              queries=[[0, 1], [1, 0], [0, 3], [1, 3], [2, 3]])
        self.assertEqual([True, False, True, True, True], result)

    def test_check_if_prerequisite_set2(self):
        solution = Solution()
        result = solution.checkIfPrerequisite(numCourses=5,
                                              prerequisites=[[0, 1], [1, 2], [2, 3], [2, 4]],
                                              queries=[[0, 1], [1, 0], [0, 3], [1, 3], [2, 3],
                                                       [3, 0], [3, 1], [3, 2], [1, 4], [2, 4], [3, 4]])
        self.assertEqual([True, False, True, True, True, False, False, False, True, True, False], result)

    def test_check_if_prerequisite_set3(self):
        solution = Solution()
        result = solution.checkIfPrerequisite(numCourses=6,
                                              prerequisites=[[0, 1], [1, 2], [2, 3], [2, 4]],
                                              queries=[[0, 1], [1, 0], [0, 3], [1, 3], [2, 3],
                                                       [3, 0], [3, 1], [3, 2], [1, 4], [2, 4], [3, 4],
                                                       [0, 5], [1, 5], [2, 5]])
        self.assertEqual([True, False, True, True, True, False, False, False, True, True, False, False, False, False],
                         result)

    def test_check_if_prerequisite_set4(self):
        solution = Solution()
        result = solution.checkIfPrerequisite(numCourses=2,
                                              prerequisites=[[0, 1], [1, 0]],
                                              queries=[[0, 1], [1, 0]])
        self.assertEqual([True, True], result)

    def test_check_if_prerequisite_set5(self):
        solution = Solution()
        result = solution.checkIfPrerequisite(numCourses=2,
                                              prerequisites=[],
                                              queries=[[0, 1], [1, 0]])
        self.assertEqual([False, False], result)
