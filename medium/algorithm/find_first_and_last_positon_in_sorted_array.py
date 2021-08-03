from typing import List


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


def search_left_flipping_point(numbers: List[int], start: int, end: int, target: int) -> int:
    if start == end:
        return start
    if end == 0:
        return 0
    if start > end:
        return start
    if numbers[end] == target and numbers[end - 1] < target:
        return end
    mid = (start + end) // 2
    if numbers[mid] < target:
        return search_left_flipping_point(numbers=numbers, start=mid + 1, end=end, target=target)
    else:
        if mid > 0 and numbers[mid] == target and numbers[mid - 1] < target:
            return mid
        return search_left_flipping_point(numbers=numbers, start=start, end=mid - 1, target=target)


def search_right_flipping_point(numbers: List[int], start: int, end: int, target: int) -> int:
    if start == end:
        return start
    if start == len(numbers) - 1:
        return len(numbers) - 1
    if start > end:
        return len(numbers) - 1
    if numbers[start] == target and numbers[start + 1] > target:
        return start
    mid = (start + end) // 2
    if numbers[mid] > target:
        return search_right_flipping_point(numbers=numbers, start=start, end=mid - 1, target=target)
    else:
        if numbers[mid] == target and numbers[mid + 1] > target:
            return mid
        return search_right_flipping_point(numbers=numbers, start=mid + 1, end=end, target=target)


class Solution:
    # noinspection PyMethodMayBeStatic
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1, -1]
        position_of_target = binary_search_recursive(numbers=nums,
                                                     start=0,
                                                     end=len(nums) - 1,
                                                     target=target)
        if position_of_target == -1:
            return [-1, -1]
        start_position = 0
        end_position = len(nums) - 1
        if not nums[0] == target:
            start_position = search_left_flipping_point(numbers=nums, start=0, end=position_of_target, target=target)
        if not nums[end_position] == target:
            end_position = search_right_flipping_point(numbers=nums, start=position_of_target, end=len(nums) - 1,
                                                       target=target)
        return [start_position, end_position]
