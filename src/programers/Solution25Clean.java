package programers;

import java.util.Arrays;

public class Solution25Clean {
    public int solution(int [] citations){
        Arrays.sort(citations);
        for(int h=citations.length;h>0;h--){
            if(isHIndex(citations,h)){
                return h;
            }
        }
        return 0;
    }

    private boolean isHIndex(int[] citations, int hIndex){
        int count = 0;
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=hIndex){
                count++;
            }
        }
        return count>=hIndex;
    }
}
