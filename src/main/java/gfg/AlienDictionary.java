/*
https://www.geeksforgeeks.org/problems/alien-dictionary/1
 */

package gfg;

import java.util.*;

public class AlienDictionary {

    public String findOrder(String[] dict) {
        // Write your code here
        Map<Character, List<Character>> adj = generateAdjacencyList(dict);
        if (detectCycle(adj)){
            return "";
        }
        for (String word: dict){
            for (char c: word.toCharArray()){
                if (!adj.containsKey(c)){
                    adj.put(c, new ArrayList<>());
                }
            }
        }
        Stack<Character> order = new Stack<>();
        Set<Character> visit = new HashSet<>();
        topologicalSort(adj, order, visit);
        StringBuilder stringBuilder = new StringBuilder();
        while (!order.isEmpty()){
            stringBuilder.append(order.pop());
        }
        return stringBuilder.toString();
    }

    private void topologicalSort( Map<Character, List<Character>> adj , Stack<Character> order, Set<Character> visit){
        for (Character key: adj.keySet()){
            topologicalSortRecursive(adj, order, visit, key);
        }
    }

    private void topologicalSortRecursive(Map<Character, List<Character>> adj , Stack<Character> order, Set<Character> visit, Character node){
        if (visit.contains(node)){
            return;
        }
        visit.add(node);
        for (Character c: adj.get(node)){
            topologicalSortRecursive(adj, order, visit, c);
        }
        order.push(node);
    }


    private boolean detectCycle(Map<Character, List<Character>> adj){
        Set<Character> visit = new HashSet<>();
        Set<Character> trail = new HashSet<>();
        for (Character c: adj.keySet()){
            if (cycleDetectRecursive(c, adj, visit, trail)){
                return true;
            }
        }
        return false;
    }

    private boolean cycleDetectRecursive(Character node, Map<Character, List<Character>> adj, Set<Character> visit, Set<Character> trail){
        if (trail.contains(node)){
            return true;
        }
        if (visit.contains(node)){
            return false;
        }
        trail.add(node);
        visit.add(node);
        for (Character connect: adj.get(node)){
            if (cycleDetectRecursive(connect, adj, visit, trail)){
                return true;
            }
        }
        trail.remove(node);
        return false;
    }

    private Map<Character, List<Character>> generateAdjacencyList(String[] dict){
        Map<Character, List<Character>> adj = new HashMap<>();
        for (int i=0;i<=dict.length-2;i++){
            int charIndex = 0;
            boolean sameLetters = true;
            while (charIndex<dict[i].length() && charIndex<dict[i+1].length() && sameLetters){
                if (dict[i].charAt(charIndex) != dict[i+1].charAt(charIndex)){
                    sameLetters = false;
                    if (!adj.containsKey(dict[i].charAt(charIndex))){
                        adj.put(dict[i].charAt(charIndex), new ArrayList<>());
                    }
                    if (!adj.containsKey(dict[i+1].charAt(charIndex))){
                        adj.put(dict[i+1].charAt(charIndex), new ArrayList<>());
                    }
                    adj.get(dict[i].charAt(charIndex)).add(dict[i+1].charAt(charIndex));
                }
                ++charIndex;
            }
        }
        return adj;
    }
}
