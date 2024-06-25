package leet.solutions;

import java.util.*;
import java.util.stream.Collectors;

public class GetWatchedVideosByYourFriends {


    public List<String> solve(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        return new Solution().watchedVideosByFriends(watchedVideos, friends, id, level);
    }

    static class Solution {
        public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

            Map<Integer, List<Integer>> friendMap = new HashMap<>();
            for (int i = 0; i < friends.length; i++) {
                friendMap.put(i, new LinkedList<>());
                for (int f : friends[i]) {
                    friendMap.get(i).add(f);
                }
            }
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> bfsQueue = new LinkedList<>();
            bfsQueue.add(id);
            int bfsLevel = 0;
            visited.add(id);
            Set<Integer> nextLevelFriends = new HashSet<>();
            while (!bfsQueue.isEmpty() && bfsLevel < level) {
                int levelWidth = bfsQueue.size();
                nextLevelFriends.clear();
                for (int i = 0; i < levelWidth; i++) {
                    Integer levelTraverseId = bfsQueue.poll();
                    for (Integer f : friendMap.get(levelTraverseId)) {
                        if (!visited.contains(f)) {
                            nextLevelFriends.add(f);
                        }
                    }
                }
                visited.addAll(nextLevelFriends);
                bfsQueue.addAll(nextLevelFriends);
                ++bfsLevel;
            }
            Map<String, Integer> videoWatchFrequency = new HashMap<>();
            while (!bfsQueue.isEmpty()) {
                Integer f = bfsQueue.poll();
                watchedVideos.get(f).forEach(s -> {
                    if (videoWatchFrequency.containsKey(s)) {
                        videoWatchFrequency.put(s, videoWatchFrequency.get(s) + 1);
                    } else {
                        videoWatchFrequency.put(s, 1);
                    }
                });
            }
            return videoWatchFrequency.entrySet().stream().sorted((o1, o2) -> {
                if (!Objects.equals(o1.getValue(), o2.getValue())) {
                    return Integer.compare(o1.getValue(), o2.getValue());
                }
                return o1.getKey().compareTo(o2.getKey());
            }).map(Map.Entry::getKey).collect(Collectors.toList());


        }
    }
}
