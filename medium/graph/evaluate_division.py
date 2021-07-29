from typing import List, Dict, Tuple


class Solution:
    # noinspection PyMethodMayBeStatic
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        adjacency_list: Dict[str, List[Tuple]] = {}
        for equation_index in range(0, len(equations), 1):
            if equations[equation_index][0] in adjacency_list:
                adjacency_list[equations[equation_index][0]].append(
                    (equations[equation_index][1], values[equation_index]))
            else:
                adjacency_list[equations[equation_index][0]] = \
                    [(equations[equation_index][1], values[equation_index])]

            if equations[equation_index][1] in adjacency_list:
                adjacency_list[equations[equation_index][1]].append(
                    (equations[equation_index][0], 1 / values[equation_index]))
            else:
                adjacency_list[equations[equation_index][1]] = \
                    [(equations[equation_index][0], 1 / values[equation_index])]

        def traverse_depth_first_and_evaluate(left_operand: str, right_operand: str,
                                              reference_result: float, visited_nodes: List[str]):
            if left_operand not in adjacency_list or right_operand not in adjacency_list:
                return -1
            if left_operand == right_operand:
                return reference_result
            for operand in adjacency_list[left_operand]:
                if operand[0] not in visited_nodes:
                    visited_nodes.append(operand[0])
                    calculated_val = traverse_depth_first_and_evaluate(left_operand=operand[0],
                                                                         right_operand=right_operand,
                                                                         reference_result=reference_result * operand[1],
                                                                         visited_nodes=visited_nodes)
                    if calculated_val != -1:
                        return calculated_val
            return -1

        query_result = []

        for query in queries:
            if query[0] not in adjacency_list or query[1] not in adjacency_list:
                query_result.append(-1)
            elif query[0] == query[1]:
                query_result.append(1)
            else:
                query_result.append(traverse_depth_first_and_evaluate(left_operand=query[0],
                                                                      right_operand=query[1],
                                                                      reference_result=1,
                                                                      visited_nodes=[query[0]]))

        return query_result
