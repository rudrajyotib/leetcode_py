from typing import List


def is_palindrome(sample: str) -> bool:
    return sample == sample[::-1]


class Solution:
    result: List[List[str]] = []

    # noinspection PyMethodMayBeStatic
    def partition(self, s: str) -> List[List[str]]:

        Solution.result.clear()

        def partition_recursive(sample: str, start: int, sample_length: int, result_container: List[str]):
            if start == sample_length:
                Solution.result.append(result_container)
            for index in range(start, sample_length, 1):
                sub_string = sample[start:index + 1]
                if is_palindrome(sub_string):
                    partition_recursive(sample, index + 1, sample_length, result_container + [sub_string])

        partition_recursive(sample=s, start=0, sample_length=len(s), result_container=[])
        return Solution.result
