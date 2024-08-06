/*
https://www.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1
 */

package gfg;

public class ValidateIpAddress {

    public boolean isValid(String str) {
        // Write your code here
        int[] startOctet = new int[4];
        int[] endOctet = new int[4];
        int strLen = str.length();
        int ctr = 0;
        for (int i = 0; i < strLen; i++) {
            if (str.charAt(i) == '.') {
                if (ctr == 3) {
                    return false;
                }
                endOctet[ctr] = i;
                startOctet[ctr + 1] = i + 1;
                ++ctr;
            }
        }
        if (ctr < 2) {
            return false;
        }
        endOctet[3] = strLen;
        for (int i = 0; i < 4; i++) {
            if (!isValidOctet(str, startOctet[i], endOctet[i])) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidOctet(String str, int startIndex, int endIndex) {
        if (startIndex > (endIndex - 1)) {
            return false;
        }
        if (startIndex >= str.length()) {
            return false;
        }
        if ((endIndex - startIndex) > 3) {
            return false;
        }
        if (str.charAt(startIndex) == '0') {
            return (endIndex - startIndex) <= 1;
        }
        int val = 0;
        for (int i = startIndex; i < endIndex; i++) {
            val = (val * 10) + (str.charAt(i) - '0');
        }
        return val <= 255;
    }

}
