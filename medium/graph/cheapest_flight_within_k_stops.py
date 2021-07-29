import collections
import math
import queue
from typing import List, Dict, Tuple


class Solution:
    # noinspection PyMethodMayBeStatic
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:

        adjacency_list: Dict[int, List[Tuple]] = {}
        for flight in flights:
            if (flight[0]) in adjacency_list:
                adjacency_list[(flight[0])].append(((flight[1]), flight[2]))
            else:
                adjacency_list[(flight[0])] = [((flight[1]), flight[2])]

        if src not in adjacency_list:
            return -1

        relaxed_nodes: queue = collections.deque()
        shortest_distance: List = [math.inf] * n
        shortest_distance[src] = 0

        adjacent_nodes = adjacency_list[src]
        for adjacent_node in adjacent_nodes:
            relaxed_nodes.append((adjacent_node[1], 0, adjacent_node[0]))
            shortest_distance[adjacent_node[0]] = adjacent_node[1]

        while len(relaxed_nodes) > 0:
            shortest_relaxed_node = relaxed_nodes.popleft()
            if shortest_relaxed_node[1] >= k:
                continue
            if shortest_relaxed_node[2] in adjacency_list:
                adjacent_nodes = adjacency_list[shortest_relaxed_node[2]]
                for adjacent_node in adjacent_nodes:
                    dist_to_node = shortest_relaxed_node[0] + adjacent_node[1]
                    if dist_to_node < shortest_distance[adjacent_node[0]]:
                        relaxed_nodes.append((dist_to_node, shortest_relaxed_node[1] + 1, adjacent_node[0]))
                        shortest_distance[adjacent_node[0]] = dist_to_node

        if math.inf == shortest_distance[dst]:
            return -1
        return shortest_distance[dst]
