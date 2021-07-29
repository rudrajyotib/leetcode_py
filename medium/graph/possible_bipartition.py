from typing import List, Dict


class Solution:
    # noinspection PyMethodMayBeStatic
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:

        adjacency_list: Dict[int, List[int]] = {}
        visited_nodes: List[bool] = [False] * n
        for vertex in dislikes:
            if (vertex[0] - 1) in adjacency_list:
                adjacency_list[(vertex[0] - 1)].append((vertex[1] - 1))
            else:
                adjacency_list[(vertex[0] - 1)] = [(vertex[1] - 1)]
            if (vertex[1] - 1) in adjacency_list:
                adjacency_list[(vertex[1] - 1)].append((vertex[0] - 1))
            else:
                adjacency_list[(vertex[1] - 1)] = [(vertex[0] - 1)]
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
                    if node not in adjacency_list:
                        continue
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

        for vertex in range(0, n, 1):
            if not visited_nodes[vertex]:
                is_bipartite = check_bipartite_graph(root_node=vertex)
                if not is_bipartite:
                    return False

        return True
