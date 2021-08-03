from unittest import TestCase

from medium.algorithm.find_first_and_last_positon_in_sorted_array import search_left_flipping_point, \
    search_right_flipping_point, Solution


class TestLeftFilp(TestCase):
    def test_search_left_flipping_point_set1(self):
        first_appear = search_left_flipping_point(numbers=[5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6],
                                                  start=0,
                                                  end=10,
                                                  target=6)
        self.assertEqual(4, first_appear)

    def test_search_left_flipping_point_set2(self):
        first_appear = search_left_flipping_point(numbers=[5, 5],
                                                  start=0,
                                                  end=1,
                                                  target=5)
        self.assertEqual(0, first_appear)

    def test_search_left_flipping_point_set3(self):
        first_appear = search_left_flipping_point(numbers=[5],
                                                  start=0,
                                                  end=0,
                                                  target=5)
        self.assertEqual(0, first_appear)

    def test_search_left_flipping_point_set4(self):
        first_appear = search_left_flipping_point(numbers=[5, 6, 7, 8, 9],
                                                  start=0,
                                                  end=4,
                                                  target=9)
        self.assertEqual(4, first_appear)

    def test_search_left_flipping_point_set5(self):
        first_appear = search_left_flipping_point(numbers=[5, 5, 5, 5, 5],
                                                  start=0,
                                                  end=4,
                                                  target=5)
        self.assertEqual(0, first_appear)

    def test_search_left_flipping_point_set6(self):
        first_appear = search_left_flipping_point(numbers=[5, 6],
                                                  start=0,
                                                  end=1,
                                                  target=5)
        self.assertEqual(0, first_appear)

    def test_search_left_flipping_point_set7(self):
        first_appear = search_left_flipping_point(numbers=[5, 6],
                                                  start=0,
                                                  end=1,
                                                  target=6)
        self.assertEqual(1, first_appear)

    def test_search_left_flipping_point_set8(self):
        first_appear = search_left_flipping_point(
            numbers=[1, 1, 1, 1, 1, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8],
            start=0,
            end=9,
            target=5)
        self.assertEqual(5, first_appear)

    def test_search_left_flipping_point_set9(self):
        first_appear = search_left_flipping_point(
            numbers=[1, 1, 1, 1, 1, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8],
            start=0,
            end=6,
            target=5)
        self.assertEqual(5, first_appear)


class TestRightFlip(TestCase):
    def test_search_right_flipping_point_set1(self):
        self.assertEqual(1, search_right_flipping_point(numbers=[1, 1, 2, 3, 4], start=0, end=4, target=1))

    def test_search_right_flipping_point_set2(self):
        self.assertEqual(1, search_right_flipping_point(numbers=[1, 1], start=0, end=1, target=1))

    def test_search_right_flipping_point_set3(self):
        self.assertEqual(7,
                         search_right_flipping_point(numbers=[-1, -1, -1, 0, 0, 0, 1, 1, 2], start=6, end=8, target=1))

    def test_search_right_flipping_point_set4(self):
        self.assertEqual(0, search_right_flipping_point(numbers=[1], start=0, end=0, target=1))

    def test_search_right_flipping_point_set5(self):
        self.assertEqual(0, search_right_flipping_point(numbers=[1, 2, 3, 4, 5], start=0, end=4, target=1))


class TestSolution(TestCase):
    def test_search_range_set1(self):
        solution = Solution()
        self.assertEqual([5, 9], solution.searchRange(
            nums=[1, 1, 1, 1, 1, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8], target=5))

    def test_search_range_set2(self):
        solution = Solution()
        self.assertEqual([10, 17], solution.searchRange(
            nums=[1, 1, 1, 1, 1, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8], target=6))

    def test_search_range_set3(self):
        solution = Solution()
        self.assertEqual([0, 9], solution.searchRange(nums=[1, 1, 1, 1, 1, 1, 1, 1, 1, 1], target=1))

    def test_search_range_set4(self):
        solution = Solution()
        self.assertEqual([-1, -1], solution.searchRange(nums=[1, 1, 1, 1, 1, 1, 1, 1, 1, 1], target=2))

    def test_search_range_set5(self):
        solution = Solution()
        self.assertEqual([1, 1], solution.searchRange(nums=[0, 1], target=1))

    def test_search_range_set6(self):
        solution = Solution()
        self.assertEqual([0, 0], solution.searchRange(nums=[0, 1], target=0))

    def test_search_range_set7(self):
        solution = Solution()
        self.assertEqual([-1, -1], solution.searchRange(nums=[], target=0))
