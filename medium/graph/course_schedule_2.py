from typing import List, Dict


class Solution:
    # noinspection PyMethodMayBeStatic
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:

        if numCourses == 1:
            return [0]

        node_relations: Dict[int, List[int]] = {}
        for node_relation in prerequisites:
            if node_relation[0] in node_relations:
                node_relations[node_relation[0]].append(node_relation[1])
            else:
                node_relations[node_relation[0]] = [node_relation[1]]
            if node_relation[1] in node_relations:
                if node_relation[0] in node_relations[node_relation[1]]:
                    return []

        def cyclic_directed_graph(vertex: int, visited_nodes: List[bool],
                                  in_path: List[bool], traversed_path: List[int]) -> bool:
            if in_path[vertex]:
                return True
            if visited_nodes[vertex]:
                return False
            visited_nodes[vertex] = True
            in_path[vertex] = True
            if vertex not in node_relations:
                in_path[vertex] = False
                traversed_path.append(vertex)
                return False
            for child in node_relations[vertex]:
                if cyclic_directed_graph(vertex=child, visited_nodes=visited_nodes,
                                         in_path=in_path, traversed_path=traversed_path):
                    return True
            traversed_path.append(vertex)
            in_path[vertex] = False
            return False

        visited_courses = [False] * numCourses
        in_path_course = [False] * numCourses
        path: List[int] = []

        for i in range(0, numCourses, 1):
            if cyclic_directed_graph(vertex=i, visited_nodes=visited_courses,
                                     in_path=in_path_course, traversed_path=path):
                return []
        return path
