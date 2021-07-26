import collections


class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    # noinspection PyMethodMayBeStatic
    def cloneGraph(self, node: 'Node') -> 'Node':

        if node is None:
            # noinspection PyTypeChecker
            return None

        queue = collections.deque()
        queue.append(node)
        node_map = {}
        while len(queue) > 0:
            orig_node: Node = queue.popleft()
            if orig_node.val not in node_map:
                node_map[orig_node.val] = orig_node
            for neighbor in orig_node.neighbors:
                if neighbor.val not in node_map:
                    queue.append(neighbor)

        cloned_node_map = {}
        for orig_node_index, orig_node in node_map.items():
            cloned_node: Node
            if orig_node_index not in cloned_node_map:
                cloned_node = Node(val=orig_node.val)
                cloned_node_map[orig_node_index] = cloned_node
            else:
                cloned_node = cloned_node_map[orig_node_index]
            for neighbor in orig_node.neighbors:
                if neighbor.val in cloned_node_map:
                    cloned_node.neighbors.append(cloned_node_map[neighbor.val])
                else:
                    cloned_neighbor = Node(val=neighbor.val)
                    cloned_node.neighbors.append(cloned_neighbor)
                    cloned_node_map[neighbor.val] = cloned_neighbor

        return cloned_node_map[node.val]
