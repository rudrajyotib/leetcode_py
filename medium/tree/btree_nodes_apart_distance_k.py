from typing import List, Tuple


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def is_k_node_apart(path: str, target_path: str, k: int) -> bool:
    nodes_common = 0
    if len(path) < len(target_path):
        for node in path:
            if target_path[nodes_common] == node:
                nodes_common += 1
            else:
                break
        return ((len(path) + len(target_path)) - 2 * nodes_common) == k
    else:
        for node in target_path:
            if path[nodes_common] == node:
                nodes_common += 1
            else:
                break
        return ((len(path) + len(target_path)) - 2 * nodes_common) == k


class Solution:
    result: List[int]
    root_right_path: List[Tuple[str, int, int]]
    root_left_path: List[Tuple[str, int, int]]
    target_path_from_root: str
    target_side_of_root: str
    LEFT_SIDE: str = "Left"
    RIGHT_SIDE: str = "Right"

    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:

        Solution.result = []
        Solution.root_left_path = []
        Solution.root_right_path = []
        Solution.target_path_from_root = ''
        Solution.target_side_of_root = ''

        def traverse_from_root(node: TreeNode, level: int, target_level: int):
            if node is None:
                return
            if level == target_level:
                Solution.result.append(node.val)
            else:
                traverse_from_root(node=node.left, level=level + 1, target_level=target_level)
                traverse_from_root(node=node.right, level=level + 1, target_level=target_level)

        def find_nodes_and_record_paths(node: TreeNode,
                                        side_of_root: str,
                                        depth_from_root: int,
                                        path_from_root: str,
                                        path_list_from_root: List[Tuple[str, int, int]],
                                        target_in_path: bool = False,
                                        depth_from_target: int = 0):
            if node is None:
                return
            if node.val == target.val:
                target_in_path = True
                Solution.target_side_of_root = side_of_root
                Solution.target_path_from_root = path_from_root
                if depth_from_root == k:
                    Solution.result.append(root.val)
            if target_in_path:
                if depth_from_target == k:
                    Solution.result.append(node.val)
                else:
                    find_nodes_and_record_paths(node=node.left,
                                                side_of_root=side_of_root,
                                                depth_from_root=depth_from_root + 1,
                                                path_from_root=path_from_root + 'L',
                                                path_list_from_root=path_list_from_root,
                                                target_in_path=True,
                                                depth_from_target=depth_from_target + 1)
                    find_nodes_and_record_paths(node=node.right,
                                                side_of_root=side_of_root,
                                                depth_from_root=depth_from_root + 1,
                                                path_from_root=path_from_root + 'R',
                                                path_list_from_root=path_list_from_root,
                                                target_in_path=True,
                                                depth_from_target=depth_from_target + 1)
            else:
                path_list_from_root.append((path_from_root, depth_from_root, node.val))
                find_nodes_and_record_paths(node=node.left,
                                            side_of_root=side_of_root,
                                            depth_from_root=depth_from_root + 1,
                                            path_from_root=path_from_root + 'L',
                                            path_list_from_root=path_list_from_root,
                                            target_in_path=False,
                                            depth_from_target=depth_from_target)
                find_nodes_and_record_paths(node=node.right,
                                            side_of_root=side_of_root,
                                            depth_from_root=depth_from_root + 1,
                                            path_from_root=path_from_root + 'R',
                                            path_list_from_root=path_list_from_root,
                                            target_in_path=False,
                                            depth_from_target=depth_from_target)

        if k == 0:
            return [target.val]

        if target.val == root.val:
            traverse_from_root(node=root, target_level=k, level=0)
            return Solution.result

        if root.left:
            find_nodes_and_record_paths(node=root.left,
                                        side_of_root=Solution.LEFT_SIDE,
                                        depth_from_root=1,
                                        path_from_root='L',
                                        path_list_from_root=Solution.root_left_path,
                                        target_in_path=False,
                                        depth_from_target=0
                                        )
        if root.right:
            find_nodes_and_record_paths(node=root.right,
                                        side_of_root=Solution.RIGHT_SIDE,
                                        depth_from_root=1,
                                        path_from_root='R',
                                        path_list_from_root=Solution.root_right_path,
                                        target_in_path=False,
                                        depth_from_target=0
                                        )

        if Solution.target_side_of_root == Solution.RIGHT_SIDE:
            if k > len(Solution.target_path_from_root):
                list_left = list(
                    filter(lambda x: k - x[1] == len(Solution.target_path_from_root), Solution.root_left_path))
                for element in list_left:
                    Solution.result.append(element[2])
            list_right = list(
                filter(lambda x: is_k_node_apart(x[0], Solution.target_path_from_root, k), Solution.root_right_path))
            for element in list_right:
                Solution.result.append(element[2])
        if Solution.target_side_of_root == Solution.LEFT_SIDE:
            if k > len(Solution.target_path_from_root):
                list_right = list(
                    filter(lambda x: k - x[1] == len(Solution.target_path_from_root), Solution.root_right_path))
                for element in list_right:
                    Solution.result.append(element[2])
            list_left = list(
                filter(lambda x: is_k_node_apart(x[0], Solution.target_path_from_root, k), Solution.root_left_path))
            for element in list_left:
                Solution.result.append(element[2])

        return Solution.result
