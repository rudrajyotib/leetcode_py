//https://leetcode.com/problems/most-frequent-subtree-sum/

package leet.solutions;

import ds.util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {

    public int[] solve(TreeNode treeNode){
        return new Solution().findFrequentTreeSum(treeNode);
    }

    static class Solution {

        Map<Integer, Integer> frequency = new HashMap<>();
        int maxFrequency = 0;
        List<Integer> mostFrequent = new LinkedList<>();
        public int[] findFrequentTreeSum(TreeNode root) {
            calculateSubTreeSum(root, frequency);
            int[] result = new int[mostFrequent.size()];
            int counter = 0;
            for (Integer integer : mostFrequent) {
                result[counter] = integer;
                ++counter;
            }
            return result;
        }

        private int calculateSubTreeSum(TreeNode treeNode, Map<Integer, Integer> frequency){
            if (treeNode == null){
                return 0;
            }
            int sum = treeNode.val + calculateSubTreeSum(treeNode.left, frequency) + calculateSubTreeSum(treeNode.right, frequency);
            if (frequency.containsKey(sum)){
                frequency.put(sum, frequency.get(sum)+1);
            }else{
                frequency.put(sum, 1);
            }
            if (frequency.get(sum) > maxFrequency){
                maxFrequency = frequency.get(sum);
                mostFrequent.clear();
                mostFrequent.add(sum);
            }else if (frequency.get(sum) == maxFrequency){
                mostFrequent.add(sum);
            }
            return sum;
        }
    }
}



