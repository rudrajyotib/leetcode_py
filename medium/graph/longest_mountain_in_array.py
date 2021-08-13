from typing import List


class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        if len(arr) < 3:
            return 0
        longest_mountain = 0
        last_direction = 'V'
        last_length = 0
        for index in range(1, len(arr), 1):
            if arr[index] > arr[index - 1]:
                if last_direction != 'U':
                    last_length = 2
                    last_direction = 'U'
                else:
                    last_length += 1
            elif arr[index] < arr[index - 1]:
                if last_direction != 'V':
                    last_length += 1
                    if last_length > longest_mountain:
                        longest_mountain = last_length
                    last_direction = 'D'
            else:
                last_direction = 'V'
                last_length = 0
        return longest_mountain
