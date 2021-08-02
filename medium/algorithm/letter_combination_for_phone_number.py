from typing import List, Dict


class Solution:
    digit_dictionary: Dict[str, List[str]] = {
        "2": ["a", "b", "c"],
        "3": ["d", "e", "f"],
        "4": ["g", "h", "i"],
        "5": ["j", "k", "l"],
        "6": ["m", "n", "o"],
        "7": ["p", "q", "r", "s"],
        "8": ["t", "u", "v"],
        "9": ["w", "x", "y", "z"]
    }

    result: List[str] = []

    # noinspection PyMethodMayBeStatic
    def letterCombinations(self, digits: str) -> List[str]:
        Solution.result.clear()

        if digits == "":
            return []

        def append_next_char(source: str, current_num: int, end_goal: int):
            if end_goal == current_num:
                # noinspection PyShadowingNames
                for letter in Solution.digit_dictionary[digits[current_num]]:
                    Solution.result.append(source + letter)
            else:
                # noinspection PyShadowingNames
                for letter in Solution.digit_dictionary[digits[current_num]]:
                    append_next_char(source + letter, current_num=current_num + 1, end_goal=end_goal)

        append_next_char("", current_num=0, end_goal=len(digits) - 1)

        return Solution.result
