package backTraking.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Q1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int subin = sc.nextInt();
        int sister = sc.nextInt();

        int time = 0;

        if (subin == sister) {
            System.out.println(time);
            return;
        }

        Queue<Pair> queue = new ArrayDeque<>();
        Set<Integer> visitPoint = new HashSet<>();
        queue.add(new Pair(subin, 0));
        visitPoint.add(subin);

        while (!queue.isEmpty()) {

            Pair now = queue.poll();
            int np1 = now.p + 1;
            int np2 = now.p - 1;
            int np3 = 2 * now.p;
            if (np1 == sister || np2 == sister || np3 == sister) {
                System.out.println(now.time + 1);
                break;
            }
            if (!visitPoint.contains(np1)) {
                queue.add(new Pair(np1, now.time + 1));
                visitPoint.add(np1);
            }
            if (!visitPoint.contains(np2)) {
                queue.add(new Pair(np2, now.time + 1));
                visitPoint.add(np2);
            }
            if (!visitPoint.contains(np3)) {
                queue.add(new Pair(np3, now.time + 1));
                visitPoint.add(np3);
            }
        }
    }
}

class Pair {
    int p;
    int time;

    public Pair(int p, int time) {
        this.p = p;
        this.time = time;
    }
}
