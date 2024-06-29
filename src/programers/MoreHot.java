package programers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MoreHot {
    public static void main(String[] args){
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(solution(scoville,k));
    }

    public static int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> pqScoville = new PriorityQueue<>();
        for(Integer i : scoville){
            pqScoville.add(i);
        }

        while(true) {
            if (pqScoville.peek() >= k) {
                return answer;
            }
            else if(pqScoville.size() <= 1){
                return -1;
            }
            else {
                answer++;
                int newFood = pqScoville.remove() + pqScoville.remove() * 2;
                pqScoville.add(newFood);
            }
        }
    }
}
