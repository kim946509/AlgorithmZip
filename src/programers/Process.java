package programers;

import java.util.*;

public class Process {
    public static void main(String[] args) {
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location){
        int answer = 0;

        //프로세스를 담을 큐 생성
        Queue<Integer> process = new LinkedList<>();
        for (int priority : priorities){
            process.add(priority);
        }

        //우선순위를 중복제거해서 내림차순 할 리스트 생성
        List<Integer> sortPriorities = new ArrayList<>();
        for(int priority : priorities){
            sortPriorities.add(priority);
        }
        sortPriorities.sort(Collections.reverseOrder());
        while(process.element()!=null){
            //프로세스의 우선순위가 가장 높을 경우
            if(process.peek().equals(sortPriorities.get(0))){
                answer++;
                sortPriorities.remove(0);
                if(location == 0)
                    return answer;
                else{
                    process.remove();
                }
            }
            else{
                process.add(process.peek());
                process.remove();
            }
            location--;
            if(location < 0)
                location = process.size()-1;
        }

        return answer;
    }
}
