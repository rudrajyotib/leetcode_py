package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/shortest-unique-prefix/
 */


public class ShortestUniquePrefix {

    public String[] solve(String[] input){
        return new Solution().prefix(input);
    }


    public class Solution {
        public String[] prefix(String[] inputs) {

            TrieNode dictionary = new TrieNode();
            String[] result = new String[inputs.length];

            for(String input : inputs){
                TrieNode node = dictionary;
                for (int i=0;i<input.length();i++){
                    node = node.addLetter(input.charAt(i));
                }
            }

            for (int i=0;i<inputs.length;i++){
                TrieNode node = dictionary;
                boolean uniquePrefixFound = false;
                int letterCounter = 0;
                while (!uniquePrefixFound){
                    node = node.getLetter(inputs[i].charAt(letterCounter));
                    if (node.getFootPrint() == 1){
                        uniquePrefixFound = true;
                    }
                    ++letterCounter;
                }
                result[i] = inputs[i].substring(0, letterCounter);

            }

            return result;
        }
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class TrieNode{
        private final TrieNode[] children = new TrieNode[26];
        private int footPrint = 0;

        public void incrementFootPrint(){
            ++this.footPrint;
        }

        public int getFootPrint(){
            return this.footPrint;
        }

        public TrieNode addLetter(char x){
            TrieNode nextNode;
            if (children[x-'a']==null){
                nextNode = new TrieNode();
                children[x-'a'] = nextNode;
            }else{
                nextNode = children[x-'a'];
            }
            nextNode.incrementFootPrint();
            return nextNode;
        }



        public TrieNode getLetter(char x){
            return children[x-'a'];
        }

    }



}
