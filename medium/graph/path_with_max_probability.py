import collections
import heapq
from typing import List, Dict, Tuple


class Solution:
    # noinspection PyMethodMayBeStatic
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:

        visited: List[bool] = [False] * n
        result: List[float] = [0.0] * n
        adjacency_list: Dict[int, List[Tuple]] = collections.defaultdict(list)

        for index, edge in enumerate(edges):
            adjacency_list[edge[0]].append((succProb[index], edge[1]))
            adjacency_list[edge[1]].append((succProb[index], edge[0]))

        result[start] = 1.0

        priority_queue = [(-1.0, start)]
        heapq.heapify(priority_queue)
        while len(priority_queue) > 0:
            node = heapq.heappop(priority_queue)
            if node[1] == end:
                return -1.0 * node[0]
            visited[node[1]] = True
            for adjacent_node in adjacency_list[node[1]]:
                if not visited[adjacent_node[1]]:
                    heapq.heappush(priority_queue, (adjacent_node[0] * node[0], adjacent_node[1]))

        return 0.0
