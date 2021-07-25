from unittest import TestCase

from medium.tree.n_ary_time_needed_to_inform_all_employees import Solution


class TestSolution(TestCase):
    def test_num_of_minutes(self):
        solution = Solution()
        self.assertEqual(22,
                         solution.numOfMinutes(n=16, headID=3,
                                               manager=[3, 3, 3, -1, 1, 1, 0, 0, 4, 4, 7, 7, 11, 11, 13, 13],
                                               informTime=[4, 5, 0, 2, 6, 0, 0, 7, 0, 0, 0, 5, 0, 4, 0, 0])
                         )
        self.assertEqual(2,
                         solution.numOfMinutes(n=4,
                                               headID=3,
                                               manager=[3, 3, 3, -1],
                                               informTime=[0, 0, 0, 2])
                         )
        self.assertEqual(0,
                         solution.numOfMinutes(n=1,
                                               headID=0,
                                               manager=[-1],
                                               informTime=[0])
                         )
        self.assertEqual(2,
                         solution.numOfMinutes(n=2,
                                               headID=0,
                                               manager=[-1, 0],
                                               informTime=[2, 0])
                         )
