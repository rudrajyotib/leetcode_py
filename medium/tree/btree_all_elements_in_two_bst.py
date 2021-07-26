from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def in_order_traversal(node: TreeNode, result: [int]):
    if node.left:
        in_order_traversal(node=node.left, result=result)
    result.append(node.val)
    if node.right:
        in_order_traversal(node=node.right, result=result)


def append_to_result(result: [int], extended_elements1: [int], extended_elements2: [int]):
    for element in extended_elements1:
        result.append(element)
    for element in extended_elements2:
        result.append(element)


class Solution:
    # noinspection PyMethodMayBeStatic
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        if root1 is None:
            if root2 is None:
                return []
            else:
                result = []
                in_order_traversal(node=root2, result=result)
                return result
        if root1 is not None and root2 is None:
            result = []
            in_order_traversal(node=root1, result=result)
            return result
        tree1 = []
        # noinspection PyTypeChecker
        in_order_traversal(node=root1, result=tree1)
        tree2 = []
        in_order_traversal(node=root2, result=tree2)
        result = []
        tree1_counter = 0
        tree2_counter = 0
        while tree1_counter < len(tree1) and tree2_counter < len(tree2):
            if tree1[tree1_counter] == tree2[tree2_counter]:
                result.append(tree1[tree1_counter])
                result.append(tree1[tree1_counter])
                tree1_counter += 1
                tree2_counter += 1
            elif tree1[tree1_counter] > tree2[tree2_counter]:
                result.append(tree2[tree2_counter])
                tree2_counter += 1
            else:
                result.append(tree1[tree1_counter])
                tree1_counter += 1

        append_to_result(result=result,
                         extended_elements1=tree1[tree1_counter:],
                         extended_elements2=tree2[tree2_counter:])

        return result
