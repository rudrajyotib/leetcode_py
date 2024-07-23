/*
https://leetcode.com/problems/sort-characters-by-frequency/
 */

package leet.solutions;

import java.util.ArrayList;
import java.util.List;

public class SortCharactersByFrequency {

    public String solve(String s) {
        return new Solution().frequencySort(s);
    }

    static class Solution {
        public String frequencySort(String s) {
            int[] freq = new int[62];
            for (char c : s.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    freq[c - 'a'] += 1;
                } else if (c >= 'A' && c <= 'Z') {
                    freq[(c - 'A') + 26] += 1;
                } else {
                    freq[(c - '0') + 52] += 1;
                }
            }
            List<FreqMonitor> monitors = new ArrayList<>(s.length());
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    monitors.add(new FreqMonitor((char) (97 + i), freq[i]));
                }
            }
            for (int i = 26; i < 52; i++) {
                if (freq[i] > 0) {
                    monitors.add(new FreqMonitor((char) (65 + i - 26), freq[i]));
                }
            }
            for (int i = 52; i < 62; i++) {
                if (freq[i] > 0) {
                    monitors.add(new FreqMonitor((char) ('0' + i - 52), freq[i]));
                }
            }
            monitors.sort(FreqMonitor::compareTo);
            char[] chars = new char[s.length()];
            int counter = 0;
            for (FreqMonitor monitor : monitors) {
                for (int i = 0; i < monitor.freq; i++) {
                    chars[counter + i] = monitor.c;
                }
                counter += monitor.freq;
            }
            return new String(chars);
        }

        @SuppressWarnings("rawtypes")
        public static class FreqMonitor implements Comparable {
            private final char c;
            private final int freq;

            public FreqMonitor(char c, int freq) {
                this.c = c;
                this.freq = freq;
            }

            @Override
            public int compareTo(Object o) {
                FreqMonitor f = (FreqMonitor) o;
                return Integer.compare(f.freq, freq);
            }
        }


    }

}
