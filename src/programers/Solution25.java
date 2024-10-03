package programers;

import java.util.Arrays;

public class Solution25 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int maxValue = citations[citations.length - 1];
        int h_index = 0;
        for(int value=1;value<maxValue;value++){
            int count = 0;
            for(int index=citations.length-1;index>=0;index--){
                if(value<=citations[index])
                    count++;
                else
                    break;
            }
            if(value<=count){
                h_index=value;
            }
        }
        return h_index;
    }
}


/**
 * - i는 1부터 citiations의 최댓값까지 반복한다.
 * - i보다 큰 수의 갯수가 i이상일 경우 h-index를 i로 수정한다.
 * - h-index를 return 한다.
 * - 시간복잡도 O(n^2)
 */
