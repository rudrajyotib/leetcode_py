from unittest import TestCase

from medium.algorithm.pacific_atlantic_water_flow import PacificAtlantic


class TestPacificAtlantic(TestCase):
    def test_calculate_water_flow_set1(self):
        pacificAtlantic = PacificAtlantic()
        result = pacificAtlantic.calculate_water_flow(
            heights=[[1, 2, 2, 3, 5], [3, 2, 3, 4, 4], [2, 4, 5, 3, 1], [6, 7, 1, 4, 5], [5, 1, 1, 2, 4]])
        self.assertEqual(7, len(result))
        self.assertTrue([0, 4] in result)
        self.assertTrue([1, 3] in result)
        self.assertTrue([1, 4] in result)
        self.assertTrue([2, 2] in result)
        self.assertTrue([3, 0] in result)
        self.assertTrue([3, 1] in result)
        self.assertTrue([4, 0] in result)

    def test_calculate_water_flow_set2(self):
        pacificAtlantic = PacificAtlantic()
        result = pacificAtlantic.calculate_water_flow(
            heights=[[1, 1, 1]])
        self.assertEqual(3, len(result))
        self.assertTrue([0, 0] in result)
        self.assertTrue([0, 1] in result)
        self.assertTrue([0, 2] in result)
