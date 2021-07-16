class Solution:
    def isValidSerialization(self, preorder: str) -> bool:

        def is_valid_serialisation_left_to_right(serialised_string: str) -> bool:
            if not serialised_string:
                return False
            serialised_nodes = serialised_string.split(',')
            if len(serialised_nodes) < 1:
                return False
            if serialised_nodes[0] == '#':
                if len(serialised_nodes) is 1:
                    return True
                return False
            node_to_fill: int = 2
            for index in range(1, len(serialised_nodes), 1):
                if node_to_fill == 0:
                    return False
                if serialised_nodes[index] == '#':
                    node_to_fill -= 1
                else:
                    node_to_fill += 1
            return node_to_fill == 0

        return is_valid_serialisation_left_to_right(serialised_string=preorder)
