class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class BSTIterator:

    def __init__(self, root: TreeNode):
        self._node_list = []

        def print_in_order(parent_node: TreeNode, result=None):
            if result is None:
                result = []
            if parent_node is None:
                return None
            if parent_node.left:
                print_in_order(parent_node.left, result)
            result.append(parent_node.val)
            if parent_node.right:
                parent_node.next = parent_node.right
                print_in_order(parent_node.right, result)

        print_in_order(root, self._node_list)
        self._current_index = 0
        self._node_length = len(self._node_list) - 1
        self._has_next = True

    def next(self) -> int:
        if self._has_next:
            val = self._node_list[self._current_index]
            self._has_next = self._current_index < self._node_length
            self._current_index += 1
            return val
        else:
            # noinspection PyTypeChecker
            return None

    # noinspection PyPep8Naming
    def hasNext(self) -> bool:
        return self._has_next
