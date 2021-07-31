from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:

        if len(connections) < (n - 1):
            return -1
        visited_nodes: List[bool] = [False] * n
        adjacency_list: List[List[int]] = []
        for i in range(n):
            adjacency_list.append([])
        for connection in connections:
            adjacency_list[connection[0]].append(connection[1])
            adjacency_list[connection[1]].append(connection[0])

        def visit_nodes_dfs(node: int):
            if not visited_nodes[node]:
                visited_nodes[node] = True
                for adjacent_node in adjacency_list[node]:
                    visit_nodes_dfs(adjacent_node)

        group_counter = 0

        for node_index in range(n):
            if not visited_nodes[node_index]:
                group_counter += 1
                visit_nodes_dfs(node=node_index)

        return group_counter - 1
