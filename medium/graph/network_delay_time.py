import math
from typing import List, Dict, Tuple


class Solution:
    # noinspection PyMethodMayBeStatic
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adjacency_list: Dict[int, List[Tuple]] = {}
        n = n - 1
        k = k - 1
        for time in times:
            if (time[0] - 1) in adjacency_list:
                adjacency_list[(time[0] - 1)].append(((time[1] - 1), time[2]))
            else:
                adjacency_list[(time[0] - 1)] = [((time[1] - 1), time[2])]

        if k not in adjacency_list:
            return -1

        relaxed_nodes: List[bool] = [False] * (n + 1)
        visited_nodes: List[bool] = [False] * (n + 1)
        shortest_distance: List = [math.inf] * (n + 1)
        visited_nodes[k] = True
        shortest_distance[k] = 0

        adjacent_nodes = adjacency_list[k]
        for adjacent_node in adjacent_nodes:
            relaxed_nodes[adjacent_node[0]] = True
            shortest_distance[adjacent_node[0]] = adjacent_node[1]

        def shortest_relax_node() -> int:
            shorted_distance_temp = math.inf
            shorted_distance_index = 0
            for i in range(0, n + 1, 1):
                if relaxed_nodes[i] and shortest_distance[i] < shorted_distance_temp:
                    shorted_distance_index = i
                    shorted_distance_temp = shortest_distance[i]
            return shorted_distance_index

        def relaxed_nodes_count() -> int:
            return len(list(filter(lambda x: x, relaxed_nodes)))

        while relaxed_nodes_count() > 0:
            shortest_relaxed_node = shortest_relax_node()
            relaxed_nodes[shortest_relaxed_node] = False
            visited_nodes[shortest_relaxed_node] = True
            if shortest_relaxed_node in adjacency_list:
                adjacent_nodes = adjacency_list[shortest_relaxed_node]
                for adjacent_node in adjacent_nodes:
                    dist_to_node = shortest_distance[shortest_relaxed_node] + adjacent_node[1]
                    if shortest_distance[adjacent_node[0]] > dist_to_node:
                        shortest_distance[adjacent_node[0]] = dist_to_node
                    if not visited_nodes[adjacent_node[0]]:
                        relaxed_nodes[adjacent_node[0]] = True

        max_dist = max(shortest_distance)
        if max_dist == math.inf:
            return -1
        else:
            return max_dist
