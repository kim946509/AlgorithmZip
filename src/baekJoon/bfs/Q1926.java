package baekJoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1926 {

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        // int n = 6;
        // int m = 5;

        // int[][] board = {
        // { 1, 1, 0, 1, 1 },
        // { 0, 1, 1, 0, 0 },
        // { 0, 0, 0, 0, 0 },
        // { 1, 0, 1, 1, 1 },
        // { 0, 0, 1, 1, 1 },
        // { 0, 0, 1, 1, 1 }
        // };
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int[] dx = { 0, 0, 1, -1 }; // 상하좌우
        int[] dy = { 1, -1, 0, 0 }; // 상하좌우

        int[][] visit = new int[n][m];
        int max = 0; // 그림 최대 넓이
        int count = 0; // 그림 개수
        int extend = 0; // 그림 넓이
        Queue<Point> q = new LinkedList<>();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                extend = 0;
                if (board[y][x] != 1 || visit[y][x] == 1)
                    continue; // 이미 방문한 곳이거나, 그림이 아닌곳은 패스
                extend++;
                count++; // 그림 갯수 증가. 단 한번만 증가하게 된다.
                q.add(new Point(x, y));
                visit[y][x] = 1; // 방문했음을 표시
                while (!q.isEmpty()) {
                    Point p = q.poll(); // 큐에서 하나 꺼내기. 해당 점 방문
                    for (int i = 0; i < 4; i++) {
                        int nx = p.x + dx[i];
                        int ny = p.y + dy[i];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                            continue; // 범위를 벗어나면 패스
                        if (visit[ny][nx] == 1 || board[ny][nx] == 0)
                            continue; // 이미 방문한 곳이거나, 그림이 아닌곳은 패스
                        q.add(new Point(nx, ny));
                        visit[ny][nx] = 1; // 방문했음을 표시
                        extend++; // 넓이 증가
                    }
                }
                max = Math.max(max, extend); // 최대값 갱신
            }
        }

        System.out.println(count); // 그림 갯수 출력
        System.out.println(max); // 그림 최대 넓이 출력
    }
}
