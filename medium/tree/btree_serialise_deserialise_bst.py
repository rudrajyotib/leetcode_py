class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:

    def serialize(self, root: TreeNode) -> str:
        if root is None:
            return "NO_TREE"

        def pre_order_traverse(root_node: TreeNode, result_container: [str]):
            if not root_node:
                pass
            else:
                result_container.append(str(root_node.val))
                pre_order_traverse(root_node=root_node.left, result_container=result_container)
                pre_order_traverse(root_node=root_node.right, result_container=result_container)

        result: [str] = []
        pre_order_traverse(root_node=root, result_container=result)
        return ",".join(result)

    def deserialize(self, data: str) -> TreeNode:
        if data == "NO_TREE":
            # noinspection PyTypeChecker
            return None
        if data == '':
            # noinspection PyTypeChecker
            return None
        pre_order_str_split = data.split(",")
        pre_order = list(map(lambda x: int(x), pre_order_str_split))
        in_order = sorted(pre_order)
        in_index_map = {}
        for index, value in enumerate(in_order):
            in_index_map[value] = index

        def build_sub_tree(in_start, in_end):

            if in_start > in_end:
                return None
            node = TreeNode(pre_order[build_sub_tree.pre_index])
            build_sub_tree.pre_index += 1

            if in_start == in_end:
                return node

            in_index = in_index_map[node.val]

            node.left = build_sub_tree(in_start, in_index - 1)
            node.right = build_sub_tree(in_index + 1, in_end)

            return node

        build_sub_tree.pre_index = 0
        return build_sub_tree(0, len(in_order) - 1)