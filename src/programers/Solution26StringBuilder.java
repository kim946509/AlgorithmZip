package programers;

import java.util.Arrays;

public class Solution26StringBuilder {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return sb.append(charArray).reverse().toString();
    }
}
