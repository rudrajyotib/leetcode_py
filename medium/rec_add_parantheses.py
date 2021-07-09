from typing import List


def operate(operator_symbol: str, left_operand: int, right_operand: int):
    if '*' == operator_symbol:
        return left_operand * right_operand
    if '-' == operator_symbol:
        return left_operand - right_operand
    if '+' == operator_symbol:
        return left_operand + right_operand


class Solution:
    # noinspection PyPep8Naming,PyMethodMayBeStatic
    def diffWaysToCompute(self, expression: str) -> List[int]:

        digits = []
        operator = []

        temp_digit = 0
        permissible_operators = ['+', '-', '*']
        for char in expression:
            if char in permissible_operators:
                operator.append(char)
                digits.append(temp_digit)
                temp_digit = 0
            else:
                temp_digit = (temp_digit * 10) + int(char)
        digits.append(temp_digit)

        if len(digits) == 1:
            return [digits[0]]

        def calculate_by_operator(start: int, end: int):
            calculated_numbers = []
            if start > end:
                return [digits[end]]
            if start == end:
                return [digits[start]]
            for i in range(start, end, 1):
                left = calculate_by_operator(start, i)
                right = calculate_by_operator(i + 1, end)
                for left_operand in left:
                    for right_operand in right:
                        calculated_numbers.append(operate(operator[i], left_operand, right_operand))
            return calculated_numbers

        return calculate_by_operator(start=0, end=(len(operator)))
