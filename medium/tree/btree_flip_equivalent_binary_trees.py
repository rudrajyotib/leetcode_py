class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def is_same_value_leaf_node(left_side: TreeNode, right_side: TreeNode) -> bool:
    return left_side.left is None and left_side.right is None and \
           right_side.left is None and right_side.right is None and \
           left_side.val == right_side.val


def children_same_in_both_nodes(left_side: TreeNode, right_side: TreeNode) -> bool:
    left_child_match: bool = (left_side.left is None and right_side.left is None) or \
                             ((left_side.left is not None and right_side.left is not None) and
                              (left_side.left.val == right_side.left.val))
    if not left_child_match:
        return False
    right_child_match: bool = (left_side.right is None and right_side.right is None) or \
                              ((left_side.right is not None and right_side.right is not None) and
                               (left_side.right.val == right_side.right.val))
    return right_child_match


def children_flipped_in_both_nodes(left_side: TreeNode, right_side: TreeNode) -> bool:
    left_child_match: bool = (left_side.left is None and right_side.right is None) or \
                             ((left_side.left is not None and right_side.right is not None)
                              and (left_side.left.val == right_side.right.val))
    right_child_match: bool = (left_side.right is None and right_side.left is None) or \
                              ((left_side.right is not None and right_side.left is not None) and
                               (left_side.right.val == right_side.left.val))
    return right_child_match and left_child_match


class Solution:
    # noinspection PyMethodMayBeStatic
    def flipEquiv(self, root1: TreeNode, root2: TreeNode) -> bool:

        def is_equivalent(left_element: TreeNode, right_element: TreeNode) -> bool:
            if left_element is None and right_element is None:
                return True
            if left_element is None or right_element is None:
                return False
            if is_same_value_leaf_node(left_element, right_element):
                return True
            if left_element.val != right_element.val:
                return False
            if children_same_in_both_nodes(left_element, right_element):
                return is_equivalent(left_element=left_element.left,
                                     right_element=right_element.left) and \
                       is_equivalent(left_element=left_element.right,
                                     right_element=right_element.right)

            if children_flipped_in_both_nodes(left_element, right_element):
                return is_equivalent(left_element=left_element.left,
                                     right_element=right_element.right) and \
                       is_equivalent(left_element=left_element.right,
                                     right_element=right_element.left)

        return is_equivalent(left_element=root1, right_element=root2)
