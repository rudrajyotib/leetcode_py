from typing import List


class FamilyMember:
    def __init__(self, name):
        self._name = name
        self._alive = True
        self._kids = []

    def name(self) -> str:
        return self._name

    def die(self):
        self._alive = False

    def kids(self):
        return self._kids

    def is_alive(self):
        return self._alive

    def give_birth(self, name: str):
        member = FamilyMember(name)
        self._kids.append(member)
        return member


class ThroneInheritance:

    def __init__(self, kingName: str):
        self._members = {}
        self._family_head = kingName
        self._members[kingName] = FamilyMember(kingName)

    def birth(self, parentName: str, childName: str):
        new_born = self._members[parentName].give_birth(name=childName)
        self._members[childName] = new_born

    def death(self, name: str) -> None:
        self._members[name].die()

    def getInheritanceOrder(self) -> List[str]:
        king = self._members[self._family_head]
        family_tree: List[str] = []

        def create_successor(member: FamilyMember, successor: List[str]):
            if member.is_alive():
                successor.append(member.name())
            for member in member.kids():
                create_successor(member, successor=successor)

        create_successor(member=king, successor=family_tree)
        return family_tree
