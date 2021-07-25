import collections
from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        if len(manager) == 1:
            return 0
        sub_ordinates = {}
        time_to_reach_node = [0] * n
        time_to_reach_node[headID] = 0
        for index in range(0, len(manager), 1):
            if manager[index] != -1:
                if manager[index] in sub_ordinates:
                    sub_ordinates[manager[index]].append(index)
                else:
                    sub_ordinates[manager[index]] = [index]
        queue = collections.deque()
        for subs in sub_ordinates[headID]:
            queue.append(subs)
        while len(queue) > 0:
            sub = queue.popleft()
            time_to_reach_node[sub] = time_to_reach_node[manager[sub]] + informTime[manager[sub]]
            if sub in sub_ordinates:
                for subs in sub_ordinates[sub]:
                    queue.append(subs)

        return max(time_to_reach_node)
