from unittest import TestCase

from medium.tree.n_ary_throne_inheritance import ThroneInheritance


class TestThroneInheritance(TestCase):
    def test_should_maintain_family_tree_set1(self):
        throne = ThroneInheritance(kingName="King")
        throne.birth("King", "Alice")
        throne.birth("King", "Bob")
        throne.birth("Alice", "Jack")

        self.assertEqual(["King", "Alice", "Jack", "Bob"], throne.getInheritanceOrder())

