package leet.solutions;

import java.util.LinkedList;
import java.util.List;

public class IntegerToEnglishWord {

    public String solve(int num){
        return new Solution().numberToWords(num);
    }

    static class Solution {

        private final String[] onesPlace = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        private final String[] tenToNineteen = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen", "Nineteen"};
        private final String[] tensPlace = new String[]{"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};


        public String numberToWords(int num) {
            if (num == 0){
                return "Zero";
            }
            List<String> result = new LinkedList<>();
            if (num >= 1000000000){
                wordUpToThousand(num/1000000000,result);
                result.add("Billion");
            }
            num = num % 1000000000;
            if (num >= 1000000){
                wordUpToThousand(num/1000000,result);
                result.add("Million");
            }
            num = num % 1000000;
            if (num >= 1000){
                wordUpToThousand(num/1000,result);
                result.add("Thousand");
            }
            num = num % 1000;
            wordUpToThousand(num,result);
            return String.join(" ", result);
        }

        private void wordUpToThousand(int num, List<String> words){
            if(num>99){
                words.add(onesPlace[num/100]);
                words.add("Hundred");
            }
            num = num % 100;
            if (num > 9 ){
                if (num > 19 ){
                    words.add(tensPlace[num/10]);
                    num = num % 10;
                }else{
                    words.add(tenToNineteen[num-10]);
                    return;
                }
            }
            if (num == 0){
                return;
            }
            words.add(onesPlace[num]);
        }
    }

}
