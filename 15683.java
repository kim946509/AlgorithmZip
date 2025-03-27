import java.io.IOException;
import java.util.*;
import java.awt.Point;

class Main {

    private static int height;
    private static int width;
    private static int minView = Integer.MAX_VALUE;
    private static int[] dirX = { 1, 0, -1, 0 };
    private static int[] dirY = { 0, 1, 0, -1 };
    private static int[][] office;
    private static int[][] officeTmp;
    private static List<Point> cctvPos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();
        minView = height * width;
        // 1. 사무실 정보 입력
        office = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                office[i][j] = sc.nextInt();
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvPos.add(new Point(j, i));
                }
            }
        }

        int cases = 1;
        officeTmp = new int[height][width];
        for (int i = 0; i < cctvPos.size(); i++) {
            cases *= 4;
        }

        for (int i = 0; i < cases; i++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    officeTmp[y][x] = office[y][x];
                }
            }
            int tmp = i;
            for (int k = 0; k < cctvPos.size(); k++) {
                int dir = tmp % 4;
                tmp /= 4;
                int x = cctvPos.get(k).x;
                int y = cctvPos.get(k).y;

                if (officeTmp[y][x] == 1) {
                    scan(x, y, dir);
                } else if (officeTmp[y][x] == 2) {
                    scan(x, y, dir);
                    scan(x, y, dir + 2);
                } else if (officeTmp[y][x] == 3) {
                    scan(x, y, dir);
                    scan(x, y, dir + 1);
                } else if (officeTmp[y][x] == 4) {
                    scan(x, y, dir);
                    scan(x, y, dir + 1);
                    scan(x, y, dir + 2);
                } else if (officeTmp[y][x] == 5) {
                    scan(x, y, dir);
                    scan(x, y, dir + 1);
                    scan(x, y, dir + 2);
                    scan(x, y, dir + 3);
                }
            }
            int count = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (officeTmp[y][x] == 0) {
                        count++;
                    }
                }
            }
            minView = Math.min(minView, count);
        }
        System.out.println(minView);

    }

    private static boolean isOutOfBound(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return true;
        }
        return false;
    }

    private static void scan(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dirX[dir];
            y += dirY[dir];
            if (isOutOfBound(x, y) || officeTmp[y][x] == 6) {
                break;
            }
            if (officeTmp[y][x] != 0) {
                continue;
            }
            officeTmp[y][x] = 7;
        }
    }
}