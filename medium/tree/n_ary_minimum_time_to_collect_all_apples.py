import collections
from typing import List


class Solution:
    has_parent: [bool]
    tree_structure: dict
    node_relation: dict

    # noinspection PyMethodMayBeStatic
    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:

        if n == 1:
            return 0

        Solution.has_parent = [False] * n
        Solution.tree_structure = {}
        Solution.node_relation = {}
        Solution.has_parent[0] = True
        for edge in edges:
            if edge[0] in Solution.node_relation:
                Solution.node_relation[edge[0]].append(edge[1])
            else:
                Solution.node_relation[edge[0]] = [edge[1]]
            if edge[1] in Solution.node_relation:
                Solution.node_relation[edge[1]].append(edge[0])
            else:
                Solution.node_relation[edge[1]] = [edge[0]]
        queue = collections.deque()
        queue.append(0)
        Solution.has_parent[0] = True
        while len(queue) > 0:
            node = queue.popleft()
            Solution.tree_structure[node] = []
            for vertex in Solution.node_relation[node]:
                if not Solution.has_parent[vertex]:
                    Solution.tree_structure[node].append(vertex)
                    Solution.has_parent[vertex] = True
                    queue.append(vertex)

        def calculate_timing(node_element: int) -> int:
            if len(Solution.tree_structure[node_element]) == 0:
                if hasApple[node_element]:
                    return 2
                else:
                    return 0
            else:
                time_for_node = 0
                for child_node in Solution.tree_structure[node_element]:
                    time_for_node += calculate_timing(child_node)
                if time_for_node == 0 and not hasApple[node_element]:
                    return 0
                else:
                    return time_for_node + (0 if node_element == 0 else 2)

        return calculate_timing(node_element=0)
