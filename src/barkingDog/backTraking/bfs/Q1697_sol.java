package backTraking.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Q1697_sol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int subin = sc.nextInt();
        int brother = sc.nextInt();
        int[] dist = new int[100001];
        Arrays.fill(dist, -1);
        dist[subin] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(subin);
        while (dist[brother] == -1) {
            int p = queue.poll();
            for (int nextP : new int[] { p - 1, p + 1, p * 2 }) {
                if (nextP < 0 || nextP > 100000)
                    continue;
                if (dist[nextP] != -1)
                    continue;
                queue.add(nextP);
                dist[nextP] = dist[p] + 1;
            }
        }
        System.out.println(dist[brother]);
    }
}

// dist 변수 하나만으로 방문여부와 시간을 함께 저장할 수 있다.
// dist[nextP]=dist[p]+1; 을 통해 time(step)을 편리하게 계산할 수 있다.