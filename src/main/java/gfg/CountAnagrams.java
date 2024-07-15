package gfg;

public class CountAnagrams {


    public int search(String pat, String txt) {

        if (pat.length() > txt.length() ){
            return 0;
        }

        int[] chars = new int[26];
        for (char x: pat.toCharArray()){
            chars[x-'a'] += 1;
        }

        int[] txtCharCount = new int[26];

        for(int i=0;i<pat.length();i++){
            ++txtCharCount[txt.charAt(i)-'a'];
        }

        int count = 0;
        if (patMatch(chars, txtCharCount)){
            ++count;
        }

        int patLen = pat.length();
        char[] txtInChar = txt.toCharArray();
        for (int i= patLen; i<txt.length();i++){
            --txtCharCount[txtInChar[i-patLen]-'a'];
            ++txtCharCount[txtInChar[i]-'a'];
            if (patMatch(chars, txtCharCount)){
                ++count;
            }
        }

        // code here
        return count;
    }

    private boolean patMatch(int[] pat, int[] text){
        for (int i=0;i<pat.length;i++){
            if (pat[i] != text[i]){
                return false;
            }
        }
        return true;
    }
}
