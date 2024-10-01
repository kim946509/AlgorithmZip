package programers;

import java.util.Arrays;

public class Solution23 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        for(int i =0; i<commands.length;i++){
            //배열을 commands에 맞게 자른다.
            int[] cuttedArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);

            //자른 배열을 정렬한다.
            Arrays.sort(cuttedArray);

            //자른 배열에서 commands[i][2]-1 번째 값을 가져온다.
            int index = commands[i][2]-1;
            int result = cuttedArray[index];
            answer[i]=result;
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.println("answer = " + answer[i]);
        }
        return answer;
    }


}

/**
 * - commands[]의 크기 만큼 반복문을 돌며 접근한다.
 * - (commands[i][0]-1)-(commands[i][1]) 까지의 배열을 자른다.
 * - 자른 배열을 정렬한다.
 * - 자른 배열에서 commands[i][2]번째-1번째 값을 가져온다.
 * - 가져온 값을 List에 추가한다.
 */