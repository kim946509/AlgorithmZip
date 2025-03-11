import java.io.IOException;
import java.util.*;
import java.io.*;
import java.awt.Point;

class Main {

    private static List<Point> princess = new ArrayList<>();
    private static int count = 0;
    private static char[][] seat;
    private static final int SEAT_SIZE = 5;
    private static final int PRINCESS_SIZE = 7;

    public static void sequence(int cur) {
        if (princess.size() == PRINCESS_SIZE) {
            if (checkDasomMore()) {
                if (checkConnect()) {
                    count++;
                }
            }
            return;
        }
        for (int i = cur; i < SEAT_SIZE * SEAT_SIZE; i++) {
            int y = i / SEAT_SIZE;
            int x = i % SEAT_SIZE;
            princess.add(new Point(x, y));
            sequence(i + 1);
            princess.remove(princess.size() - 1);
        }
    }

    public static boolean checkConnect() {
        int[] dirX = { 1, 0, -1, 0 };
        int[] dirY = { 0, 1, 0, -1 };
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[SEAT_SIZE][SEAT_SIZE];
        queue.add(princess.get(0));
        visited[princess.get(0).y][princess.get(0).x] = true;
        int size = 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                Point newP = new Point(p.x + dirX[i], p.y + dirY[i]);
                int dx = newP.x;
                int dy = newP.y;
                if (dy < 0 || dy >= SEAT_SIZE || dx < 0 || dx >= SEAT_SIZE)
                    continue;
                if (!princess.contains(newP) || visited[dy][dx] == true)
                    continue;
                queue.add(new Point(dx, dy));
                visited[dy][dx] = true;
                size++;
            }
        }
        if (size == PRINCESS_SIZE)
            return true;
        return false;
    }

    public static boolean checkDasomMore() {

        int dasomCount = 0;
        for (Point p : princess) {
            int x = (int) p.getX();
            int y = (int) p.getY();
            if (seat[y][x] == 'S') {
                dasomCount++;
            }
        }
        if (dasomCount >= 4) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        seat = new char[SEAT_SIZE][SEAT_SIZE];
        for (int i = 0; i < SEAT_SIZE; i++) {
            String s = br.readLine();
            for (int j = 0; j < SEAT_SIZE; j++) {
                seat[i][j] = s.charAt(j);
            }
        }

        sequence(0);
        System.out.println(count);
    }
}