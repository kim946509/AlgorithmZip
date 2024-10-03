package programers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution24 {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int[] allAdditionCase = getAllAdditionCase(numbers);
        Arrays.sort(allAdditionCase);
        answer = allAdditionCase.clone(); // 배열 깊은 복사
        for(int number: answer){
            System.out.println("number = " + number);
        }
        return answer;
    }

    public int[] getAllAdditionCase(int[] numbers){
        Set<Integer> caseSet = new HashSet<>();
        // 합한 모든 경우의 수를 set에 저장한다.
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                caseSet.add(numbers[i]+numbers[j]);
            }
        }
        //set을 array로 변환하여 return한다.
        return caseSet.stream().mapToInt(Integer::intValue).toArray();
    }
}

/**
 * # Approach 1
 * - numbers에 중첩 반복문을 통해 합해서 나올 수 있는 모든 숫자를 구한다.
 * - 합한 숫자를 set에 저장한다.
 * - 저장된 set을 배열로 변환한다.
 * - 배열을 오름차순 정렬한다.
 * - return 한다.
 */
