from unittest import TestCase

from medium.btree_verify_preorder_serialization import Solution


class TestSolution(TestCase):
    def test_should_identify_valid_serialisation_of_complete_btree(self):
        solution = Solution()
        self.assertTrue(solution
                        .isValidSerialization("1,2,4,#,#,5,#,#,3,6,#,#,7,#,#"),
                        "valid serialisation not recognized")

    def test_should_identify_invalid_left_aligned_serialisation(self):
        solution = Solution()
        self.assertFalse(solution
                         .isValidSerialization("1,2,3,#,#,#"),
                         "valid serialisation not recognized")

    def test_should_identify_valid_left_aligned_serialisation(self):
        solution = Solution()
        self.assertTrue(solution
                        .isValidSerialization("1,2,3,#,#,#,#"),
                        "valid serialisation not recognized")

    def test_should_identify_empty_root_serialisation(self):
        solution = Solution()
        self.assertTrue(solution.isValidSerialization("#"), "Empty root serialisation not supported")

    def test_should_identify_valid_disjointed_trees(self):
        solution = Solution()
        self.assertFalse(solution.isValidSerialization("7,2,#,2,#,#,#,6,#"), "Empty root serialisation not supported")
