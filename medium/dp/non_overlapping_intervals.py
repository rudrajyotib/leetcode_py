from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        if len(intervals) == 1:
            return 0

        sorted_intervals = sorted(intervals, key=lambda interval: interval[0])
        overlap_count = 0
        last_known_interval = sorted_intervals[0]
        for index in range(1, len(intervals), 1):
            if sorted_intervals[index][0] < last_known_interval[1]:
                if sorted_intervals[index][1] < last_known_interval[1]:
                    last_known_interval = sorted_intervals[index]
                overlap_count += 1
            else:
                last_known_interval = sorted_intervals[index]

        return overlap_count
