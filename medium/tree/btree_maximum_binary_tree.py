from typing import List, Dict


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    index_map: Dict[int, int]

    def constructMaximumBinaryTree(self, nums: List[int]) -> TreeNode:

        if nums is None:
            # noinspection PyTypeChecker
            return None
        if len(nums) == 0:
            # noinspection PyTypeChecker
            return None
        if len(nums) == 1:
            return TreeNode(val=nums[0], left=None, right=None)

        Solution.index_map = {}
        for i in range(0, len(nums), 1):
            Solution.index_map[nums[i]] = i

        def create_tree_recursive(elements: List[int], start_index: int, end_index: int) -> TreeNode:
            if start_index == end_index:
                # noinspection PyTypeChecker
                return None
            if start_index == end_index - 1:
                return TreeNode(val=elements[start_index], left=None, right=None)
            index_of_largest = Solution.index_map[max(elements[start_index: end_index])]
            return TreeNode(val=elements[index_of_largest],
                            left=create_tree_recursive(elements=elements, start_index=start_index,
                                                       end_index=index_of_largest),
                            right=create_tree_recursive(elements=elements, start_index=index_of_largest + 1,
                                                        end_index=end_index))

        return create_tree_recursive(elements=nums, start_index=0, end_index=len(nums))
