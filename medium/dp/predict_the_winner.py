from typing import List


class Solution:
    # noinspection PyMethodMayBeStatic
    def PredictTheWinner(self, nums: List[int]) -> bool:
        entire_pot = sum(nums)

        def score_by_best_case(start: int, end: int, turn: bool) -> int:

            if start == end:
                return nums[start] if turn else 0
            if start > end:
                return 0
            if turn:
                score_by_taking_left = nums[start] + score_by_best_case(start=start + 1, end=end, turn=not turn)
                score_by_taking_right = nums[end] + score_by_best_case(start=start, end=end - 1, turn=not turn)
                # print( "Score from left is {} and from right is {} on Turn between {} and {}".format(
                # score_by_taking_left, score_by_taking_right, start, end))
                return max(score_by_taking_left, score_by_taking_right)
            else:
                score_by_taking_left = score_by_best_case(start=start + 1, end=end, turn=not turn)
                score_by_taking_right = score_by_best_case(start=start, end=end - 1, turn=not turn)
                # print( "Score from left is {} and from right is {} off Turn between {} and {}".format(
                # score_by_taking_left, score_by_taking_right, start, end))
                return min(score_by_taking_left, score_by_taking_right)

        max_possible = score_by_best_case(start=0, end=len(nums) - 1, turn=True)
        opponent_max = entire_pot - max_possible
        return max_possible >= opponent_max
