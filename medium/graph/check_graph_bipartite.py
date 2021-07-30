from typing import List, Dict


class Solution:
    # noinspection PyMethodMayBeStatic
    def isBipartite(self, graph: List[List[int]]) -> bool:

        adjacency_list: Dict[int, List[int]] = {}
        visited_nodes: List[bool] = [False] * len(graph)
        for vertex in enumerate(graph):
            if len(vertex[1]) == 0:
                visited_nodes[vertex[0]] = True
                continue
            adjacency_list[vertex[0]] = vertex[1]
        if len(adjacency_list) < 1:
            return True

        def check_bipartite_graph(root_node: int) -> bool:
            next_level: List[int] = []
            present_level: List[int] = []
            next_level_present: bool = True
            level_span: int = 1
            # root_node = list(adjacency_list.keys())[0]
            present_level.append(root_node)
            visited_nodes[root_node] = True
            while next_level_present:
                for i in range(0, level_span, 1):
                    node = present_level[i]
                    visited_nodes[node] = True
                    for adjacent_node in adjacency_list[node]:
                        if adjacent_node in present_level:
                            return False
                        if not visited_nodes[adjacent_node] and adjacent_node not in next_level:
                            next_level.append(adjacent_node)
                if len(next_level) == 0:
                    next_level_present = False
                else:
                    present_level = next_level
                    next_level = []
                    level_span = len(present_level)
            return True

        for vertex in range(0, len(graph), 1):
            if not visited_nodes[vertex]:
                is_bipartite = check_bipartite_graph(root_node=vertex)
                if not is_bipartite:
                    return False

        return True