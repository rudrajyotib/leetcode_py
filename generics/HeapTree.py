from typing import List


class TreeNode:
    def __init__(self, val: int, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class HeapTree:

    def create_heap_from_List(self, input_array: List[int]) -> TreeNode:
        def create_heap_recursive(root_index: int) -> TreeNode:
            left_index = root_index * 2 + 1
            right_index = root_index * 2 + 2
            return TreeNode(val=input_array[root_index],
                            left=None if left_index >= len(input_array) else create_heap_recursive(
                                root_index=left_index),
                            right=None if right_index >= len(input_array) else create_heap_recursive(
                                root_index=right_index))

        unsorted_heap_root = create_heap_recursive(root_index=0)

        def find_max_among_immediate_child(root_node: TreeNode) -> str:
            if root_node is None:
                return None
            if root_node.left is None and root_node.right is None:
                return "Root"
            if root_node.left is None:
                return "Right" if root_node.right.val > root_node.val else "Root"
            else:
                if root_node.val < root_node.left.val or root_node.val < root_node.right.val:
                    if root_node.left.val < root_node.right.val:
                        return "Right"
                    else:
                        return "Left"
            return "Root"

        def swap(parent: TreeNode, child: TreeNode):
            if child is None:
                return
            temp = parent.val
            parent.val = child.val
            child.val = temp

        def create_max_heap(root_node: TreeNode):
            if root_node is None:
                return
            create_max_heap(root_node.left)
            create_max_heap(root_node.right)
            max_node = find_max_among_immediate_child(root_node=root_node)
            if max_node == "Root":
                return
            elif max_node == "Left":
                swap(parent=root_node, child=root_node.left)
                create_max_heap(root_node=root_node.left)
            else:
                swap(parent=root_node, child=root_node.right)
                create_max_heap(root_node=root_node.right)

        create_max_heap(root_node=unsorted_heap_root)
        return unsorted_heap_root
