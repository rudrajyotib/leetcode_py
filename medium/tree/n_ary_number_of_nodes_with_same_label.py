from typing import List


class Solution:
    result: [int]

    # noinspection PyMethodMayBeStatic
    def countSubTrees(self, n: int, edges: List[List[int]], labels: str) -> List[int]:

        Solution.result = [1] * n
        tree_structure = {}
        for i in range(0, n, 1):
            tree_structure[i] = []
        for edge in edges:
            tree_structure[edge[0]].append(edge[1])
            tree_structure[edge[1]].append(edge[0])

        def update_frequencies(node: int, parent_node: int) -> [int]:
            relation: [int] = tree_structure[node]
            if len(relation) == 1 and relation[0] == parent_node:
                return labels[node]
            else:
                result_at_node = ''
                for index in range(0, len(relation), 1):
                    if relation[index] != parent_node:
                        result_at_node += update_frequencies(node=relation[index], parent_node=node)
                Solution.result[node] += result_at_node.count(labels[node])
                result_at_node += (labels[node])
                return result_at_node

        update_frequencies(node=0, parent_node=-1)

        return Solution.result
