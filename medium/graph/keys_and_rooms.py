import collections
from typing import List


class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:

        rooms_count = len(rooms)
        room_visited = [False] * rooms_count
        room_visit_trail = collections.deque()
        room_visit_trail.append(0)
        room_visited[0] = True
        while len(room_visit_trail) > 0:
            current_room = room_visit_trail.popleft()
            room_visited[current_room] = True
            for room in rooms[current_room]:
                if not room_visited[room]:
                    room_visit_trail.append(room)

        return len(list(filter(lambda room: not room, room_visited))) == 0
