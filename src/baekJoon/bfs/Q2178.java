package baekJoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2178 {

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        // int n = 4;
        // int m = 6;
        // int[][] maze = {
        // { 1, 0, 1, 1, 1, 1 },
        // { 1, 0, 1, 0, 1, 0 },
        // { 1, 0, 1, 0, 1, 1 },
        // { 1, 1, 1, 0, 1, 1 }
        // };

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        int visit[][] = new int[n][m];
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        Queue<Point> queue = new LinkedList<>();

        // 시작점이 0일경우 이동할수있는 경로 없음.
        if (maze[0][0] == 0)
            return;

        queue.add(new Point(0, 0));
        visit[0][0] = 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                int mx = p.x + dx[i];
                int my = p.y + dy[i];

                // 범위를 벗어날 경우
                if (mx < 0 || mx >= m || my < 0 || my >= n)
                    continue;

                // 막다른 길일 경우
                if (maze[my][mx] == 0 || visit[my][mx] != 0) {
                    continue;
                }

                visit[my][mx] = visit[p.y][p.x] + 1;
                queue.add(new Point(mx, my));
            }
        }
        System.out.println(visit[n - 1][m - 1]);
    }
}