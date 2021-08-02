import collections


class Solution:
    # noinspection PyMethodMayBeStatic
    def myAtoi(self, s: str) -> int:
        trimmed_string = s.strip()
        if len(trimmed_string) == 0:
            return 0
        first_char: int = ord(trimmed_string[0])
        if not ((48 <= first_char <= 57) or (first_char == 43) or (first_char == 45)):
            return 0
        number_queue = collections.deque()
        string_length = len(trimmed_string)
        first_digit_found = False
        negative_number = False
        for index in range(string_length - 1, -1, -1):
            if not first_digit_found:
                if 48 <= ord(trimmed_string[index]) <= 57:
                    first_digit_found = True
                    number_queue.append(int(trimmed_string[index]))
            else:
                if ord(trimmed_string[index]) == 43 or ord(trimmed_string[index]) == 45:
                    if index != 0:
                        first_digit_found = False
                        number_queue.clear()
                    elif ord(trimmed_string[index]) == 45:
                        negative_number = True
                elif not (48 <= ord(trimmed_string[index]) <= 57):
                    first_digit_found = False
                    number_queue.clear()
                else:
                    number_queue.appendleft(int(trimmed_string[index]))

        max_positive = 2147483647
        min_negative = -2147483648
        max_negative = 2147483648
        # if len(number_queue) > 10:
        #     if negative_number:
        #         return max_negative
        #     else:
        #         return max_positive
        resultant_number = 0
        while number_queue:
            x = number_queue.popleft()
            resultant_number = (resultant_number * 10) + x
            if not negative_number:
                if resultant_number > max_positive:
                    return max_positive
            else:
                if resultant_number > max_negative:
                    return min_negative

        if negative_number:
            return -resultant_number
        return resultant_number
