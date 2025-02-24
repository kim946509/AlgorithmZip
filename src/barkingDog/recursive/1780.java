package barkingDog.recursive;

import java.util.*;

class Main {

    private static int[] count = { 0, 0, 0 };

    public static void cut(int n, int startY, int startX, int[][] board) {

        boolean isAllSame = true;

        // 사각형 안에 있는 모든 숫자가 같은지 검사

        int pivot = board[startY][startX];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i + startY][j + startX] != pivot) {
                    isAllSame = false;
                }
            }
        }

        // 같다면 return. BaseCondition
        if (isAllSame) {
            count[pivot + 1]++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cut(n / 3, n / 3 * i + startY, n / 3 * j + startX, board);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                if (!(board[i][j] >= -1 && board[i][j] <= 1)) {
                    System.out.println("잘못된 입력입니다.");
                    return;
                }
            }
        }

        cut(n, 0, 0, board);
        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }
}