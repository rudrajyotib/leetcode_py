from unittest import TestCase

from medium.algorithm.next_permutation import Solution


class TestSolution(TestCase):
    def test_permutation_possible_set1(self):
        solution = Solution()
        nums = [1, 3, 7, 8]
        solution.nextPermutation(nums=nums)
        self.assertEqual([1, 3, 8, 7], nums)

    def test_permutation_possible_set2(self):
        solution = Solution()
        nums = [1, 3, 4, 5]
        solution.nextPermutation(nums=nums)
        self.assertEqual([1, 3, 5, 4], nums)

    def test_permutation_possible_set3(self):
        solution = Solution()
        nums = [3, 3, 5, 4]
        solution.nextPermutation(nums=nums)
        self.assertEqual([3, 4, 3, 5], nums)

    def test_permutation_possible_set4(self):
        solution = Solution()
        nums = [7, 6, 5, 4]
        solution.nextPermutation(nums=nums)
        self.assertEqual([4, 5, 6, 7], nums)

    def test_permutation_possible_set5(self):
        solution = Solution()
        nums = [7, 7, 7, 7]
        solution.nextPermutation(nums=nums)
        self.assertEqual([7, 7, 7, 7], nums)

    def test_permutation_possible_set6(self):
        solution = Solution()
        nums = [7]
        solution.nextPermutation(nums=nums)
        self.assertEqual([7], nums)

    def test_permutation_possible_set7(self):
        solution = Solution()
        nums = [7, 8]
        solution.nextPermutation(nums=nums)
        self.assertEqual([8, 7], nums)

    def test_permutation_possible_set8(self):
        solution = Solution()
        nums = [7, 7, 6, 6, 6]
        solution.nextPermutation(nums=nums)
        self.assertEqual([6, 6, 6, 7, 7], nums)

    def test_permutation_possible_set9(self):
        solution = Solution()
        nums = [7, 7, 7, 6, 6, 6]
        solution.nextPermutation(nums=nums)
        self.assertEqual([6, 6, 6, 7, 7, 7], nums)

    def test_permutation_possible_set10(self):
        solution = Solution()
        nums = [1, 2, 6, 5, 4]
        solution.nextPermutation(nums=nums)
        self.assertEqual([1, 4, 2, 5, 6], nums)

    def test_permutation_possible_set11(self):
        solution = Solution()
        nums = [1, 2, 7, 6, 5, 4]
        solution.nextPermutation(nums=nums)
        self.assertEqual([1, 4, 2, 5, 6, 7], nums)

    def test_permutation_possible_set12(self):
        solution = Solution()
        nums = [1, 2, 7, 6, 7, 4]
        solution.nextPermutation(nums=nums)
        self.assertEqual([1, 2, 7, 7, 4, 6], nums)

    def test_permutation_possible_set13(self):
        solution = Solution()
        nums = [1, 2, 7, 2, 8, 5, 4, 3]
        solution.nextPermutation(nums=nums)
        self.assertEqual([1, 2, 7, 3, 2, 4, 5, 8], nums)

    def test_permutation_possible_set14(self):
        solution = Solution()
        nums = [1, 8, 8, 7, 7, 5, 4, 3]
        solution.nextPermutation(nums=nums)
        self.assertEqual([3, 1, 4, 5, 7, 7, 8, 8], nums)
