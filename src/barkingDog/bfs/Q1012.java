package barkingDog.bfs;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Q1012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int c=0;c<t;c++) {
            int width = sc.nextInt();
            int height = sc.nextInt();
            int k = sc.nextInt();
            int[][] board = new int[height][width];

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                board[y][x] = 1;
            }

            int[][] visit = new int[height][width];
            int[] dirX = {1, 0, -1, 0};
            int[] dirY = {0, 1, 0, -1};
            int count = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (board[i][j] == 0 || visit[i][j] == 1) {
                        continue;
                    }
                    Queue<Point> queue = new ArrayDeque<>();
                    queue.add(new Point(j, i));
                    visit[i][j] = 1;
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = p.x + dirX[dir];
                            int ny = p.y + dirY[dir];

                            if (nx < 0 || nx >= width || ny < 0 || ny >= height)
                                continue;
                            if (board[ny][nx] == 0 || visit[ny][nx]==1)
                                continue;
                            queue.add(new Point(nx, ny));
                            visit[ny][nx] = 1;
                        }
                    }
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
