from typing import List


class Solution:

    # noinspection PyMethodMayBeStatic
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        graph_len = len(graph)
        concluded_nodes: List[int] = [-3] * graph_len

        def check_cyclic_nature(start: int, check_start: int) -> bool:
            if concluded_nodes[start] == check_start:
                concluded_nodes[start] = -1
                concluded_nodes[check_start] = -1
                return False
            if concluded_nodes[start] == -2:
                return True
            concluded_nodes[start] = check_start
            for connected_node in graph[start]:
                if not (check_cyclic_nature(start=connected_node, check_start=check_start)):
                    concluded_nodes[connected_node] = -1
                    return False
            concluded_nodes[start] = -2
            return True

        result: List[int] = []

        for vertex in range(0, graph_len, 1):
            if (concluded_nodes[vertex] == -3) or (concluded_nodes[vertex] >= 0):
                if check_cyclic_nature(vertex, check_start=vertex):
                    result.append(vertex)
            elif concluded_nodes[vertex] == -2:
                result.append(vertex)

        return result
