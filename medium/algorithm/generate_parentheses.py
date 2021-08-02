from typing import List

"""
Number of open and closed braces has to be same and equals to n
If open braces count is less than n, add an open brace and call recursively
If number of closed braces count is less than open braces, add a closing brace and call recursively. 

"""


class Solution:
    result: List[str] = []

    # noinspection PyMethodMayBeStatic
    def generateParenthesis(self, n: int) -> List[str]:

        Solution.result.clear()

        def generate_parentheses_recursive(brace_sequence: str, open_braces: int, closed_braces: int):

            if open_braces == n and closed_braces == n:
                Solution.result.append(brace_sequence)
                return
            if open_braces > closed_braces:
                generate_parentheses_recursive(brace_sequence=brace_sequence + ")", open_braces=open_braces,
                                               closed_braces=closed_braces + 1)
            if open_braces < n:
                generate_parentheses_recursive(brace_sequence=brace_sequence + "(", open_braces=open_braces + 1,
                                               closed_braces=closed_braces)

        generate_parentheses_recursive(brace_sequence="", open_braces=0, closed_braces=0)

        return Solution.result
