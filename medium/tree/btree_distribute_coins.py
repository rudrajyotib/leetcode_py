class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    moves: int = 0

    def distributeCoins(self, root: TreeNode) -> int:

        Solution.moves = 0

        def balance_demand_supply(node: TreeNode) -> int:
            if node is None:
                return 0
            surplus_or_deficit_in_left = balance_demand_supply(node.left)
            surplus_or_deficit_in_right = balance_demand_supply(node.right)
            Solution.moves += abs(surplus_or_deficit_in_left) + abs(surplus_or_deficit_in_right)
            return surplus_or_deficit_in_left + surplus_or_deficit_in_right + (node.val - 1)

        balance_demand_supply(node=root)

        return Solution.moves
