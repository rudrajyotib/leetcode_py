from unittest import TestCase

from medium.algorithm.search_in_rotated_sorted_array import Solution, find_element, find_pivot


class TestPivotPoint(TestCase):
    def test_find_rotation_point_recursive_set1(self):
        self.assertEqual(0, find_pivot(numbers=[3, 1, 2]))

    def test_find_rotation_point_recursive_set2(self):
        self.assertEqual(0, find_pivot(numbers=[6, 1, 2, 3, 4, 5]))

    def test_find_rotation_point_recursive_set3(self):
        self.assertEqual(1, find_pivot(numbers=[6, 7, 1, 2, 3, 4, 5]))

    def test_find_rotation_point_recursive_set4(self):
        self.assertEqual(-1, find_pivot(numbers=[-2, 0, 1, 2, 3, 4, 5]))

    def test_find_rotation_point_recursive_set5(self):
        self.assertEqual(0, find_pivot(numbers=[1, 0]))

    def test_find_rotation_point_recursive_set6(self):
        self.assertEqual(3, find_pivot(numbers=[4, 5, 6, 7, 0, 1, 2, 3]))

    def test_find_rotation_point_recursive_set7(self):
        self.assertEqual(2, find_pivot(numbers=[4, 5, 6, 0, 1, 2, 3]))

    def test_find_rotation_point_recursive_set8(self):
        self.assertEqual(1, find_pivot(numbers=[4, 5, 1, 2, 3]))


class TestBinarySearch(TestCase):
    def test_find_element_set1(self):
        self.assertEqual(0, find_element(numbers=[0, 10, 20, 30, 40, 50, 60, 70, 80],
                                         start=0,
                                         end=8,
                                         target=0))

    def test_find_element_set2(self):
        self.assertEqual(-1, find_element(numbers=[0, 10, 20, 30, 40, 50, 60, 70, 80],
                                          start=0,
                                          end=8,
                                          target=1))

    def test_find_element_set3(self):
        self.assertEqual(-1, find_element(numbers=[0, 10, 20, 30, 40, 50, 60, 70, 80],
                                          start=0,
                                          end=8,
                                          target=82))

    def test_find_element_set4(self):
        self.assertEqual(8, find_element(numbers=[0, 10, 20, 30, 40, 50, 60, 70, 80],
                                         start=0,
                                         end=8,
                                         target=80))

    def test_find_element_set5(self):
        self.assertEqual(5, find_element(numbers=[0, 10, 20, 30, 40, 50, 60, 70, 80],
                                         start=0,
                                         end=8,
                                         target=50))

    def test_find_element_set6(self):
        self.assertEqual(5, find_element(numbers=[0, 10, 20, 30, 40, 50, 60, 70, 80],
                                         start=1,
                                         end=7,
                                         target=50))

    def test_find_element_set7(self):
        self.assertEqual(-1, find_element(numbers=[0, 10, 20, 30, 40, 50, 60, 70, 80],
                                          start=1,
                                          end=7,
                                          target=0))

    def test_find_element_set8(self):
        self.assertEqual(-1, find_element(numbers=[0, 10, 20, 30, 40, 50, 60, 70, 80],
                                          start=1,
                                          end=7,
                                          target=80))

    def test_find_element_set9(self):
        self.assertEqual(4, find_element(numbers=[0, 10, 20, 30, 40, 50, 60, 70, 80],
                                         start=0,
                                         end=8,
                                         target=40))


class TestSolution(TestCase):
    def test_search_set1(self):
        solution = Solution()
        self.assertEqual(4, solution.search(nums=[4, 5, 6, 0, 1, 2, 3], target=1))

    def test_search_set2(self):
        solution = Solution()
        self.assertEqual(8, solution.search(nums=[40, 50, 60, 0, 10, 20, 30, 35, 36], target=36))

    def test_search_set3(self):
        solution = Solution()
        self.assertEqual(0, solution.search(nums=[40, 50, 60, 0, 10, 20, 30, 35, 36], target=40))

    def test_search_set4(self):
        solution = Solution()
        self.assertEqual(-1, solution.search(nums=[40, 50, 60, 0, 10, 20, 30, 35, 36], target=1))

    def test_search_set5(self):
        solution = Solution()
        self.assertEqual(0, solution.search(nums=[1], target=1))

    def test_search_set6(self):
        solution = Solution()
        self.assertEqual(-1, solution.search(nums=[1], target=2))

    def test_search_set7(self):
        solution = Solution()
        self.assertEqual(-1, solution.search(nums=[1, 0], target=2))

    def test_search_set8(self):
        solution = Solution()
        self.assertEqual(0, solution.search(nums=[1, 0], target=1))

    def test_search_set9(self):
        solution = Solution()
        self.assertEqual(1, solution.search(nums=[1, 0], target=0))

    def test_search_set10(self):
        solution = Solution()
        self.assertEqual(-1, solution.search(nums=[1, 0], target=-2))

    def test_search_set11(self):
        solution = Solution()
        self.assertEqual(0, solution.search(nums=[1, 2], target=1))

    def test_search_set12(self):
        solution = Solution()
        self.assertEqual(2, solution.search(nums=[1, 2, 3, 4, 6], target=3))

    def test_search_set13(self):
        solution = Solution()
        self.assertEqual(2, solution.search(nums=[4, 5, 1, 2, 3], target=1))

    def test_search_set14(self):
        solution = Solution()
        self.assertEqual(-1, solution.search(nums=[9, 0, 2, 7, 8], target=3))

    def test_search_set15(self):
        solution = Solution()
        self.assertEqual(-1, solution.search(nums=[-1, 0, 2, 7, 8], target=13))
