from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def maxArea(self, height: List[int]) -> int:
        start_counter = 0
        end_counter = len(height) - 1
        max_area = 0

        while start_counter <= end_counter:
            if height[start_counter] == height[end_counter]:
                area = height[start_counter] * (end_counter - start_counter)
                start_counter += 1
                end_counter -= 1
            elif height[start_counter] > height[end_counter]:
                area = height[end_counter] * (end_counter - start_counter)
                end_counter -= 1
            else:
                area = height[start_counter] * (end_counter - start_counter)
                start_counter += 1
            if area > max_area:
                max_area = area

        return max_area
