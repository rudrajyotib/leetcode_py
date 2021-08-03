from typing import List


def find_rotation_point_recursive(numbers: List[int], start: int, end: int) -> int:
    mid = (start + end) // 2
    if mid == len(numbers) - 1:
        return -1
    if start == end:
        return start
    if mid == start:
        if numbers[mid] > numbers[end]:
            return mid
        else:
            return find_rotation_point_recursive(numbers=numbers, start=mid + 1, end=end)
    if numbers[mid] > numbers[mid + 1]:
        return mid
    if numbers[mid] < numbers[0]:
        return find_rotation_point_recursive(numbers=numbers, start=0, end=mid - 1)
    else:
        return find_rotation_point_recursive(numbers=numbers, start=mid + 1, end=end)


def binary_search_recursive(numbers: List[int], start: int, end: int, target: int) -> int:
    if start == end:
        if numbers[start] == target:
            return start
        return -1
    mid = (start + end) // 2
    if numbers[mid] == target:
        return mid
    if target > numbers[end] or target < numbers[start]:
        return -1
    if target > numbers[mid]:
        return binary_search_recursive(numbers=numbers, start=mid + 1, end=end, target=target)
    else:
        return binary_search_recursive(numbers=numbers, start=start, end=mid - 1, target=target)


def find_element(numbers: List[int], start: int, end: int, target: int):
    return binary_search_recursive(numbers=numbers, start=start, end=end, target=target)


def find_pivot(numbers: List[int]) -> int:
    if len(numbers) == 1:
        return 0
    if len(numbers) == 2:
        if numbers[0] > numbers[1]:
            return 0
        return -1
    return find_rotation_point_recursive(numbers=numbers, start=0, end=len(numbers) - 1)


class Solution:

    # noinspection PyMethodMayBeStatic
    def search(self, nums: List[int], target: int) -> int:

        if len(nums) == 1:
            if nums[0] == target:
                return 0
            return -1

        pivot_point = find_pivot(numbers=nums)
        if pivot_point == -1:
            pivot_point = 0
        if nums[0] <= target <= nums[pivot_point]:
            return find_element(numbers=nums, start=0, end=pivot_point, target=target)
        elif nums[pivot_point + 1] <= target <= nums[len(nums) - 1]:
            return find_element(numbers=nums, start=pivot_point + 1, end=len(nums) - 1, target=target)
        else:
            return -1
