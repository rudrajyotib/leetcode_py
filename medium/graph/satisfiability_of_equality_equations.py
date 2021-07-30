import collections
from typing import List, Tuple


class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        group_of_equal_variables: List[int] = [-1] * 26
        adjacency_list: List[List[int]] = []
        for i in range(0, 26, 1):
            adjacency_list.append([])
        in_equations: List[Tuple] = []
        for equation in equations:
            lhs = ord(equation[0]) - 97
            rhs = ord(equation[3]) - 97
            if equation[1] == '!':
                if lhs == rhs:
                    return False
                in_equations.append((lhs, rhs))
            else:
                if lhs == rhs:
                    continue
                adjacency_list[lhs].append(rhs)
                adjacency_list[rhs].append(lhs)
                group_of_equal_variables[lhs] = 0
                group_of_equal_variables[rhs] = 0

        def bfs_form_groups_of_equals(start: int, group_number: int) -> bool:
            bfs_queue = collections.deque()
            bfs_queue.append(start)
            while len(bfs_queue) > 0:
                node = bfs_queue.popleft()
                if group_of_equal_variables[node] == 0:
                    group_of_equal_variables[node] = group_number
                    for adjacent_node in adjacency_list[node]:
                        bfs_queue.append(adjacent_node)
                elif group_of_equal_variables[node] != group_number:
                    return False
            return True

        group_counter = 0

        for index in range(26):
            if group_of_equal_variables[index] == 0:
                group_counter += 1
                if not bfs_form_groups_of_equals(start=index,
                                                 group_number=group_counter):
                    return False

        for in_equation in in_equations:
            if group_of_equal_variables[in_equation[0]] == -1 or \
                    group_of_equal_variables[in_equation[1]] == -1:
                continue
            if group_of_equal_variables[in_equation[0]] == group_of_equal_variables[in_equation[1]]:
                return False

        return True
