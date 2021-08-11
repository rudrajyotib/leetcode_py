# Definition for a binary tree node.


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def serialise_recursive(root_node: TreeNode, level: int) -> str:
    if root_node is None:
        return ""
    return "{}({})[{}]({})".format(root_node.val,
                                   serialise_recursive(root_node=root_node.left, level=level + 1),
                                   level,
                                   serialise_recursive(root_node=root_node.right, level=level + 1))


def find_start_and_end_of_sub_tree(sub_tree: str, level: int) -> TreeNode:
    if sub_tree == "":
        # noinspection PyTypeChecker
        return None
    first_child_index = sub_tree.index("(")
    root_node = TreeNode(int(sub_tree[0:first_child_index]))
    index_of_separator = sub_tree[first_child_index:].split("[{}]".format(level + 1))
    root_node.left = find_start_and_end_of_sub_tree(index_of_separator[0][1:len(index_of_separator[0]) - 1],
                                                    level=level + 1)
    root_node.right = find_start_and_end_of_sub_tree(index_of_separator[1][1:len(index_of_separator[1]) - 1],
                                                     level=level + 1)

    return root_node


class Codec:

    # noinspection PyMethodMayBeStatic
    def serialize(self, root):
        return serialise_recursive(root_node=root, level=1)

    # noinspection PyMethodMayBeStatic
    def deserialize(self, data):
        return find_start_and_end_of_sub_tree(sub_tree=data, level=0)
