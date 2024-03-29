package programers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PassBridgheTruck {
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        System.out.println(solution(bridge_length,weight,truck_weights));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights){
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        int possibleWeight=weight;
        ArrayList<Integer> trucks = new ArrayList<>();
        for (int i : truck_weights){
            trucks.add(i);
        }

        while(!trucks.isEmpty()){
            answer++;
            possibleWeight += bridge.remove();
            //다리위에 올라갈 수 있을 때
            if(possibleWeight >= trucks.get(0)){
                bridge.add(trucks.get(0));
                possibleWeight -= trucks.get(0);
                trucks.remove(0);
            }
            else{
                bridge.add(0);
            }
        }
        answer += bridge_length;

        return answer;
    }

}
