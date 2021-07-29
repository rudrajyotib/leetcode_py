from typing import List, Dict


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        if numCourses == 1:
            return True

        node_relations: Dict[int, List[int]] = {}
        for node_relation in prerequisites:
            if node_relation[0] in node_relations:
                node_relations[node_relation[0]].append(node_relation[1])
            else:
                node_relations[node_relation[0]] = [node_relation[1]]
            if node_relation[1] in node_relations:
                if node_relation[0] in node_relations[node_relation[1]]:
                    return False

        def cyclic_directed_graph(vertex: int, visited_nodes: List[bool], in_path: List[bool]) -> bool:
            if in_path[vertex]:
                return True
            if visited_nodes[vertex]:
                return False
            visited_nodes[vertex] = True
            in_path[vertex] = True
            if vertex not in node_relations:
                in_path[vertex] = False
                return False
            for child in node_relations[vertex]:
                if cyclic_directed_graph(vertex=child, visited_nodes=visited_nodes, in_path=in_path):
                    return True
            in_path[vertex] = False
            return False

        visited_courses = [False] * numCourses
        in_path_course = [False] * numCourses

        for i in range(0, numCourses, 1):
            if cyclic_directed_graph(vertex=i, visited_nodes=visited_courses, in_path=in_path_course):
                return False
        return True

        # def cyclic_graph_at_node(vertex: int) -> bool:
        #     queue = collections.deque()
        #     queue.append(vertex)
        #     visited: Set[int] = set()
        #     while len(queue) > 0:
        #         current_node = queue.popleft()
        #         if current_node in visited:
        #             return True
        #         if current_node in node_relations:
        #             for dependent in node_relations[current_node]:
        #                 queue.append(dependent)
        #         visited.add(current_node)
        #     return False

        # for node in node_relations:
        #     if cyclic_graph_at_node(node):
        #         return False
