package gfg;

public class PrefixSuffixString {

    public int countPrefixSuffix(String[] s1, String[] s2) {
        return new Solution().prefixSuffixString(s1, s2);
    }

    static class Solution {
        public int prefixSuffixString(String[] s1, String[] s2) {

            Trie dictionaryRoot = new Trie();
            Trie reverseDictionaryRoot = new Trie();

            for (String s : s1) {
                Trie tempRoot = dictionaryRoot;
                for (int i = 0; i < s.length(); i++) {
                    tempRoot.markLetter(s.charAt(i));
                    tempRoot = tempRoot.charNode(s.charAt(i));
                }
                tempRoot = reverseDictionaryRoot;
                for (int i = s.length() - 1; i >= 0; i--) {
                    tempRoot.markLetter(s.charAt(i));
                    tempRoot = tempRoot.charNode(s.charAt(i));
                }
            }

            int prefixSuffixCount = 0;

            for (String s : s2) {
                Trie tempRoot = dictionaryRoot;
                boolean allCharsChecked = true;
                for (int i = 0; i < s.length(); i++) {
                    if (tempRoot.exists(s.charAt(i))) {
                        tempRoot = tempRoot.charNode(s.charAt(i));
                    } else {
                        allCharsChecked = false;
                        break;
                    }
                }
                if (allCharsChecked) {
                    ++prefixSuffixCount;
                    continue;
                }
                tempRoot = reverseDictionaryRoot;
                allCharsChecked = true;
                for (int i = s.length() - 1; i >= 0; i--) {
                    if (tempRoot.exists(s.charAt(i))) {
                        tempRoot = tempRoot.charNode(s.charAt(i));
                    } else {
                        allCharsChecked = false;
                        break;
                    }
                }
                if (allCharsChecked) {
                    ++prefixSuffixCount;
                }

            }


            return prefixSuffixCount;
        }

        static class Trie {
            Trie[] child = new Trie[26];

            public void markLetter(char c) {
                if (child[c - 'a'] == null) {
                    child[c - 'a'] = new Trie();
                }
            }

            public boolean exists(char c) {
                return !(child[c - 'a'] == null);
            }

            public Trie charNode(char c) {
                return child[c - 'a'];
            }
        }


    }
}
