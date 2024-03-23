package programers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

//LV2 stack/queue
public class FuntionDevelopment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] progresses = {95,90,99,99,80,99};
        int[] speeds = {1,1,1,1,1,1};
        ArrayList<Integer> solution = solution(progresses, speeds);
        for (int i = 0; i < solution.size(); i++) {
            System.out.print(solution.get(i)+" ");
        }
    }

    public static ArrayList<Integer> solution(int[] progresses, int[] speeds){
        ArrayList<Integer> answer = new ArrayList<>();
        int count = 1;
        int[] days = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            days[i] = (int)Math.ceil((double) (100 - progresses[i]) /speeds[i]);
        }

        int max=days[0];

        for (int cur = 1; cur < progresses.length; cur++) {
            if(max >= days[cur])
                count++;
            else{
                answer.add(count);
                max = days[cur];
                count=1;
            }
        }
        answer.add(count);
        return answer;
    }
}
