package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/first-non-repeating-character-in-a-stream-of-characters/
 */

public class FirstNonRepeatingCharacterInStream {

    public String solve(String stream){
        return new Solution().solve(stream);
    }

    public static class Solution {
        public String solve(String A) {

            boolean[] repeatCharacterTracker = new boolean[26];
            LinkNode[] nonRepeatedCharactersNode = new LinkNode[26];

            LinkNode head = null;

            StringBuilder stringBuilder = new StringBuilder();

            for (char x : A.toCharArray()){
                if (!repeatCharacterTracker[x-'a']){
                    repeatCharacterTracker[x-'a'] = true;
                    LinkNode charNode = new LinkNode(x);
                    if (head == null){
                        head = charNode;
                    }else{
                        LinkNode pointer = head;
                        while (pointer.next != null){
                            pointer = pointer.next;
                        }
                        charNode.prev = pointer;
                        pointer.next = charNode;
                    }
                    nonRepeatedCharactersNode[x-'a'] = charNode;
                    stringBuilder.append(head.value);
                }else{
                    if (nonRepeatedCharactersNode[x-'a'] != null){
                        if (head != null && head.value == x){
                            head = head.next;
                        }
                        LinkNode charNode = nonRepeatedCharactersNode[x-'a'];
                        if (charNode.next != null){
                            if (charNode.prev != null){
                                charNode.prev.next = charNode.next;
                                charNode.next.prev = charNode.prev;
                            }else{
                                charNode.next.prev = null;
                            }
                        }else if (charNode.prev != null){
                            charNode.prev.next = null;
                        }
                        nonRepeatedCharactersNode[x-'a'] = null;
                    }
                    if (head == null){
                        stringBuilder.append('#');
                    }else{
                        stringBuilder.append(head.value);
                    }
                }
            }



            return stringBuilder.toString();
        }

        static class LinkNode{
            final char value;
            LinkNode prev;
            LinkNode next;

            LinkNode(char value) {
                this.value = value;
            }


        }
    }


}
