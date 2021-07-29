import collections
import queue
from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:

        end_node: int = len(graph) - 1

        result: List[List[int]] = []

        def depth_first_search(node: int, path_trail: queue):
            if node == end_node:
                result.append(list(path_trail))
                return
            for connected_node in graph[node]:
                path_trail.append(connected_node)
                print("appended node:{}".format(connected_node))
                depth_first_search(connected_node, path_trail)
                path_trail.pop()

        trail = collections.deque()
        trail.append(0)
        depth_first_search(node=0, path_trail=trail)

        return result
