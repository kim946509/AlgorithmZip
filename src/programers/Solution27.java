package programers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution27 {
    public String[] solution(String[] strings, int n) {
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n)!=o2.charAt(n))
                    return o1.charAt(n)-o2.charAt(n);
                else
                    return o1.compareTo(o2);
            }
        };

        Arrays.sort(strings, comp);
        for (int i = 0; i < strings.length; i++) {
            System.out.println("strings[i] = " + strings[i]);
        }
        return strings;
    }
}
