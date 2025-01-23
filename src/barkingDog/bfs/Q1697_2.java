package barkingDog.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Q1697_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int subin = sc.nextInt();
        int sister = sc.nextInt();

        if(subin==sister){
            System.out.println(0);
            return;
        }

        Queue<Pair> queue = new ArrayDeque<>();
        Set<Integer> visitPoint = new HashSet<>();
        queue.add(new Pair(subin,0));
        visitPoint.add(subin);

        while(!queue.isEmpty()){
            Pair now = queue.poll();
            int np;
            for(int i=0;i<3;i++){
                if(i==0){
                    np=now.p+1;
                }
                if(i==1){
                    np=now.p-1;
                }
                else{
                    np=now.p*2;
                }
                if(np<0||np>100000)
                    continue;
                if(visitPoint.contains(np)){
                    continue;
                }
                if(np==sister){
                    System.out.println(now.time+1);
                    break;
                }
                queue.add(new Pair(np,now.time+1));
            }

        }
    }
}
