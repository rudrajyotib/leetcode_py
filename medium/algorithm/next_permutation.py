from typing import List, Tuple


class Solution:
    # noinspection PyMethodMayBeStatic
    def nextPermutation(self, nums: List[int]) -> None:

        if len(nums) == 1:
            return

        def swap(numbers: List[int], swap_index: Tuple[int, int]):
            temp = numbers[swap_index[0]]
            numbers[swap_index[0]] = numbers[swap_index[1]]
            numbers[swap_index[1]] = temp

        def index_of_next_smallest_number(numbers: List[int], reference: int, start_index: int, end_index: int) -> int:
            smallest_number = numbers[start_index]
            smallest_number_index = start_index
            for index in range(start_index, end_index, 1):
                if smallest_number > numbers[index] > reference:
                    smallest_number_index = index
                    smallest_number = numbers[index]
            return smallest_number_index

        def permutation_possible(numbers: List[int]) -> bool:
            number_length = len(numbers)
            number_swapped = False
            for outer_index in range(number_length - 1, 0, -1):
                if numbers[outer_index] > numbers[outer_index - 1]:
                    index_to_swap = index_of_next_smallest_number(numbers=numbers,
                                                                  reference=numbers[outer_index - 1],
                                                                  start_index=outer_index,
                                                                  end_index=len(numbers))
                    swap(numbers=numbers, swap_index=(index_to_swap, outer_index - 1))
                    number_swapped = True
                    break
            if number_swapped:
                # noinspection PyUnboundLocalVariable
                sorted_subarray = sorted(numbers[outer_index:])
                for index in range(len(sorted_subarray)):
                    numbers[index + outer_index] = sorted_subarray[index]
            return number_swapped

        def sort_reverse(numbers: List[int], start_index: int, end_index: int):
            while end_index > start_index:
                if numbers[start_index] > numbers[end_index]:
                    temp = numbers[start_index]
                    numbers[start_index] = numbers[end_index]
                    numbers[end_index] = temp
                    end_index -= 1
                    start_index += 1
                else:
                    return

        if not permutation_possible(numbers=nums):
            sort_reverse(numbers=nums, start_index=0, end_index=len(nums) - 1)

        """
        Do not return anything, modify nums in-place instead.
        """
