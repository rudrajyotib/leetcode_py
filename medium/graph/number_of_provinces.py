from typing import List, Dict


class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:

        matrix_length: int = len(isConnected)
        count: int = 0
        city_to_province_map: Dict[int, int] = {}
        province_group: Dict[int, List[int]] = {}

        for i in range(0, matrix_length, 1):
            for j in range(0, matrix_length, 1):
                if isConnected[i][j] == 1:
                    if i == j:
                        if i not in city_to_province_map:
                            city_to_province_map[i] = i
                            province_group[i] = [i]
                    elif j > i:
                        if j not in city_to_province_map:
                            city_to_province_map[j] = city_to_province_map[i]
                            province_group[city_to_province_map[i]].append(j)
                        else:
                            if city_to_province_map[j] != city_to_province_map[i]:
                                cities = province_group.pop(city_to_province_map[j])
                                for city in cities:
                                    city_to_province_map[city] = city_to_province_map[i]
                                    province_group[city_to_province_map[i]].append(city)

        return len(province_group)
