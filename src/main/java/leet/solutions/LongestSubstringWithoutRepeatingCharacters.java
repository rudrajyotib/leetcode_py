package leet.solutions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.isEmpty()) {
                return 0;
            }
            int maxLength = 1;
            Map<Character, Integer> lastKnownLocationOfCharacter = new HashMap<>(26);
            int startIndex = 0;
            int endIndex = 0;
            for (int i=0; i<s.length();i++)
            {
                if (!lastKnownLocationOfCharacter.containsKey(s.charAt(i)))
                {
                    ++endIndex;
                    lastKnownLocationOfCharacter.put(s.charAt(i), i);
                    continue;
                }
                int lastKnownIndex = lastKnownLocationOfCharacter.get(s.charAt(i));
                if ( (lastKnownIndex>=startIndex) )
                {
                    int currentLength = endIndex - startIndex;
                    if(currentLength > maxLength)
                    {
                        maxLength = currentLength;
                    }
                    startIndex = lastKnownIndex+1;
                }
                ++endIndex;
                lastKnownLocationOfCharacter.put(s.charAt(i), i);
            }


            return Math.max(maxLength, (s.length()-startIndex));
        }
    }
}
