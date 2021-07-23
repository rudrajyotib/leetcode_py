from typing import List


class Solution:
    def pathInZigZagTree(self, label: int) -> List[int]:

        if label == 1:
            return [1]

        elements_index_by_levels: [int] = []
        elements_in_level: [int] = []
        count_of_nodes = 0
        label_level = 0
        level_found: bool = False

        while not level_found:
            items_in_level = pow(2, label_level)
            elements_in_level.append(items_in_level)
            count_of_nodes += items_in_level
            # noinspection PyUnboundLocalVariable
            elements_index_by_levels.append(count_of_nodes)
            if count_of_nodes >= label:
                level_found = True
            else:
                label_level += 1

        result: [int] = [label]
        if label_level % 2 == 0 :
            parent_position = (label - elements_in_level[label_level]) // 2
        else:
            parent_position = (elements_index_by_levels[label_level] - label) // 2
        label_level -= 1
        while label_level > 0:
            if label_level % 2 == 0:
                node_val = elements_index_by_levels[label_level] - elements_in_level[label_level] + 1 + parent_position
                result.append(node_val)
                parent_position = parent_position // 2
                label_level -= 1
            else:
                node_val = elements_index_by_levels[label_level] - parent_position
                parent_position = parent_position // 2
                result.append(node_val)
                label_level -= 1
        result.append(1)

        return list(reversed(result))
